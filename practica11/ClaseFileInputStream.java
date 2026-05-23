package practica11;

import java.io.FileInputStream;
import java.io.IOException;

public class ClaseFileInputStream {
    public static void main(String[] args){
        FileInputStream fis = null;
        byte[] buffer = new byte[81];
        int nBytes;
        try{0
            fis = new FileInputStream("leer.txt");
            nBytes = fis.read(buffer, 0, 81);
            System.out.println(texto);
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.toString());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                } catch (IOException ioe) {
                    System.out.println("Error al cerrar el archivo");
                }
            }
        }
    }    
}
