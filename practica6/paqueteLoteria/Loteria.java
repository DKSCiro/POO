package practica6.paqueteLoteria;

import java.util.Scanner;
import java.util.Random;

public class Loteria {
    public void jugar() {
        Scanner sc = new Scanner(System.in);
        try {
            int[] numerosUsuario = new int[5];
            int[] numerosSorteo = new int[5];
            Random rand = new Random();

            //eliges 5 numeros
            System.out.println("Elige 5 numeros entre 1 y 50:");
            for (int i = 0; i < 5; i++) {
                System.out.print("Numero " + (i+1) + ": ");
                int num = sc.nextInt();
                if (num >= 1 && num <= 50) {
                    numerosUsuario[i] = num;
                } else {
                    System.out.println("Numero invalido, se asigna 1 por defecto.");
                    numerosUsuario[i] = 1;
                }
            }

            //sorteo aleatorio de 5 numeros
            System.out.println("\nNumeros sorteados:");
            for (int i = 0; i < 5; i++) {
                numerosSorteo[i] = rand.nextInt(50) + 1;
                System.out.print(numerosSorteo[i] + " ");
            }
            System.out.println();

            //comparar resultados
            int aciertos = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (numerosUsuario[i] == numerosSorteo[j]) {
                        aciertos++;
                    }
                }
            }

            System.out.println("\nTus numeros:");
            for (int n : numerosUsuario) {
                System.out.print(n + " ");
            }
            System.out.println("\nAciertos: " + aciertos);
        } finally {
            sc.close();
        }
    }
}