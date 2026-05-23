package practica1;
public class arreglos {
    public static void main(String[] args) {
        int[] numeros = new int[100];

        //Llenamos el arreglo con valores del 1 al 100
        for (int i = 0; i < 100; i++) {
            numeros[i] = i + 1; 
        }

        //Se imprime solo de 10 en 10
        for (int i = 9; i < 100; i += 10) {
            System.out.println(numeros[i]);
        }
    }
}
