package practica6.paqueteCalculadora;

import java.util.Scanner;

public class Calculadora {
    public void operar() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Ingresa primer número: ");
            int a = sc.nextInt();
            System.out.print("Ingresa segundo número: ");
            int b = sc.nextInt();

            System.out.println("Suma: " + (a + b));
            System.out.println("Resta: " + (a - b));
            System.out.println("Multiplicación: " + (a * b));
            if (b != 0) {
                System.out.println("División: " + (a / b));
            } else {
                System.out.println("No se puede dividir entre cero.");
            }
        } finally {
            sc.close();
        }
    }
}