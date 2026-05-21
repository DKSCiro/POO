package practica6.paqueteAgenda;

import java.util.Scanner;

public class Agenda {
    private String[][] contactos = {
        {"Lalo", "5551234752", "Mexico"},
        {"Yael", "5555678412", "Mexico"},
        {"Diego", "5559876900", "Mexico"}
    };

    public void buscar() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Ingresa nombre del contacto: ");
            String nombre = sc.nextLine();

            boolean encontrado = false;
            for (String[] c : contactos) {
                if (c[0].equalsIgnoreCase(nombre)) {
                    System.out.println("Nombre: " + c[0]);
                    System.out.println("Celular: " + c[1]);
                    System.out.println("País: " + c[2]);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Contacto no encontrado.");
            }
        } finally {
            sc.close();
        }
    }
}