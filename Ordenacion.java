import java.util.Random;
import java.io.*;

public class Ordenacion {
    
    public static void main(String[] args) {
        int[] v1 = new int[5];
        Random r = new Random();
        
        for(int i=0; i<5; i++) {
            v1[i] = r.nextInt(90) + 10;
        }
        
        // Mostrar en consola
        System.out.println("Vector V1");
        for(int i=0; i<5; i++) {
            System.out.print(v1[i] + " ");
        }
        System.out.println();
        
        // Ordenar por insercion
        int[] v2 = v1.clone();
        for(int i=1; i<5; i++) {
            int temp = v2[i];
            int j = i-1;
            while(j>=0 && v2[j] > temp) {
                v2[j+1] = v2[j];
                j--;
            }
            v2[j+1] = temp;
        }
        
        System.out.println("Vector V2");
        for(int i=0; i<5; i++) {
            System.out.print(v2[i] + " ");
        }
        System.out.println();
        
        crearHTML(v1, v2);
    }
    
    public static void printVectorHTML(PrintWriter pw, int[] vector, String titulo) {
        if(titulo.length() != 0) {
            pw.println("<H1>" + titulo + "</H1>");
        }
        pw.println("<BR>");
        pw.println("<TABLE CELLPADDING=5 CELLSPACING=1 BORDER=0 BGCOLOR=#FF0000>");
        pw.println("<TR>");
        for(int i=0; i<vector.length; i++) {
            pw.println("<TD BGCOLOR=#00FF00>");
            pw.println("&nbsp;<FONT COLOR=#0000FF>" + vector[i] + "</FONT>&nbsp;");
            pw.println("</TD>");
        }
        pw.println("</TR>");
        pw.println("</TABLE>");
    }
    
    public static void crearHTML(int[] v1, int[] v2) {
        try {
            PrintWriter pw = new PrintWriter("resultado.html");
            
            
            pw.println("<html>");
            pw.println("<head>");
            pw.println("</head>");
            pw.println("<body bgcolor=#D9E997>");
            pw.println();
            pw.println("<h1>Ordenación por Inserción</h1>");
            pw.println("<hr>");
            pw.println();
            
           
            printVectorHTML(pw, v1, "Vector Desordenado update actualizando V1");
            pw.println("<br>");
            printVectorHTML(pw, v2, "Vector Ordenado V2");
            
            pw.println("<hr>");
            pw.println("</body>");
            pw.println("</html>");
            
            pw.close();
            System.out.println("HTML creado: resultado.html");
            
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}