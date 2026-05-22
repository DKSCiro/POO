import java.util.Scanner;
public class palindromo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa una palabra o frase: ");
        String palabra = sc.nextLine();

        // Convertimos a minúsculas para que no importe mayúsculas/minúsculas
        palabra = palabra.toLowerCase();

        // Eliminamos espacios
        palabra = palabra.replaceAll(" ", "");

        // Invertimos la palabra
        String invertida = new StringBuilder(palabra).reverse().toString();

        // Comparamos
        if (palabra.equals(invertida)) {
            System.out.println("La palabra o frase es palíndroma.");
        } else {
            System.out.println("La palabra o frase NO es palíndroma.");
        }

        sc.close();
    }
}

