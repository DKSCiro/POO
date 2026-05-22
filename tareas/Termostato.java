//Ejercicio 1

public class Termostato {
    private double temperaturaActual;
    public Termostato() {
        temperaturaActual = 20.0;
    }

    public double getTemperatura() {
        return temperaturaActual;
    }

    public void setTemperatura(double nuevaTemperatura) {

        if(nuevaTemperatura >= -50.0 && nuevaTemperatura <= 100.0) {
            temperaturaActual = nuevaTemperatura;
        } 
        else {
            System.out.println("Error: Temperatura fuera de rango");
        }
    }

    public static void main(String[] args) {

        Termostato t1 = new Termostato();

        System.out.println("Temperatura inicial: " + t1.getTemperatura());

        t1.setTemperatura(35.5);
        System.out.println("Temperatura nueva: " + t1.getTemperatura());

        t1.setTemperatura(200);
    }
}