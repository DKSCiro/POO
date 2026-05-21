package practica10;

public class TryCatchFinally {
    public static void main(String[] args) {
        try {
            String mensajes[] = {"primero", "segundo", "tercero"};
            for (int i = 0; i < mensajes.length; i++) {
                System.out.println(mensajes[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Apuntador fuera del rango del arreglo");
        } finally {
            System.out.println("Finalizando ejecución del programa.");
        }
    }
}
