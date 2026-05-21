package practica10;

public class TryCatchFinally2 {

    public static void main(String[] args) {
        try {
            float equis = 5/0;
            System.out.println("Equis es igual a: " + equis);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division entre cero");
        } finally {
            System.out.println("A pesar de todo, se ejecuta el bloque finally");
        }
    }
}