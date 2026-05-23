package practica11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class ClaseFileWriter {
    public static void main(String[] leer){
        String texto = "";
        try {
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escribe el texto: ");
            texto = br.readLine();
            FIleWriter fw = new FileWriter("archivo.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            salida.println(texto);
            salida.close();
        } catch (IOException ioe){
            System.out.println("\n\nError al abrir o guardar el archivo: ");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("\n\nError al leer el teclado: ");
            e.printStackTrace();
    }
}
