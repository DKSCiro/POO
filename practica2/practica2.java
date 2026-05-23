package practica2;
import java.util.Scanner;
public class practica2 {
    public static void main(String[] args) {
        int a, b, c; 
        Scanner sc = new Scanner(System.in);

        System.out.println("Dame el valor entero de a: ");
        a = sc.nextInt();

        System.out.println("Dame el valor entero de b: ");
        b = sc.nextInt();

        System.out.println("Dame el valor entero de c: ");
        c = sc.nextInt();

        // Comparaciones usando a, b y c
        if (a == b) {
            System.out.println("A y B son iguales");
        } else if (a == c) {
            System.out.println("A y C son iguales");
        } else if (b == c) {
            System.out.println("B y C son iguales");
        } else {
            System.out.println("Ninguno es igual");
        }

        // Cerramos el Scanner
        sc.close();
    }
}
