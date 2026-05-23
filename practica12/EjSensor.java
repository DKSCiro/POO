package practica12;

import java.util.Random;

class Sensor extends Thread {
    private String nombre;
    private int tiempoEspera;

    public Sensor(String nombre) {
        this.nombre = nombre;
        //tiempo aleatorio entre 500 y 1500
        this.tiempoEspera = new Random().nextInt(1001) + 500;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Lectura " + i + " del sensor " + nombre);
            try {
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class EjSensor {
    public static void main(String[] args) {
        //crear tres sensores
        Sensor temp = new Sensor("Temperatura");
        Sensor hum = new Sensor("Humedad");
        Sensor pres = new Sensor("Presión");

        //lanzados al mismo tiempo
        temp.start();
        hum.start();
        pres.start();
    }
}
