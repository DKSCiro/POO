package practica11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LeeTecladoBR {
    public static void main(String[] args){
        try{
            String texto = "";
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escribe el texto deseado: ");
            texto = br.readLine();
            System.out.println("El texto escrito fue: " + texto);
        } catch (IOException ioe){
            System.out.println(("Error al leer los caracteres: \n" + ioe));
        }
    }
}
