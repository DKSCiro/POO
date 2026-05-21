package practica6.paqueteScanner;

import java.util.Scanner;

public class contadorHojas {
    public void contar() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Ingresa número de hojas: ");
            int hojas = sc.nextInt();
            System.out.println("Total de hojas: " + hojas);
        } finally {
            sc.close();
        }
    }
}