package practica11;

import java.io.FileOutputStream;
import java.IO.IOException;

public class ClaseFileOutputStream {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        byte[] buffer = new Byte[81];
        int nBytes; 
        try {
            System.out.println("Escribe el texto a guardar en el archivo:");
            nBytes = System.in.read(buffer);
            fos = new FileOutputStream("fos.txt");
            fos.write(buffer, 0, nBytes);
        } catch (IOException e) {
            System.out.println("Error: " + ioe.toString());
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: ");
            }
        }
    }    
}
