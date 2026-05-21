package practica10;

public class TryCatchFinally4 {
    public static void main(String[] args) {
        try {
            int equis = 5/0;
            System.out.println("Equis = " + equis);
        } catch (ArithmeticException e) {
            System.out.println("Error: División entre cero");
        } catch (Exception e) {
            System.out.println("Error: Excepción general");
        } finally {
            System.out.println("El bloque finally siempre se ejecuta");
        }
    }
}
