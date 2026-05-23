package practica11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LeeTecladoCompleto {
    public static void main(String[] leer) {
        String texto = "";
        try {
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escribir texto:");
            texto = br.readLine();

            System.out.println("\n\nEl texto separado por espacios es:");
            StringTokenizer st = new StringTokenizer(texto);
            while (st.hasMoreTokens()) {
                System.out.println(st.nextToken());
            }
        } catch (Exception e) {
            System.out.println("\n\nError al leer de teclado:");
            e.printStackTrace();
        }
    }
}
