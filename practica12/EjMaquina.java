package practica12;

import java.util.ArrayList;
import java.util.List;

class MaquinaProductora extends Thread {
    private List<String> bandaTransportadora;

    public MaquinaProductora(List<String> bandaTransportadora) {
        this.bandaTransportadora = bandaTransportadora;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 20; i++) {
                synchronized (bandaTransportadora) {
                    String pieza = "Pieza-" + i;
                    bandaTransportadora.add(pieza);
                    System.out.println("Máquina produjo: " + pieza);
                    bandaTransportadora.notifyAll(); // avisar a los robots
                }
                Thread.sleep(200); // simula tiempo de producción
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class RobotEnsamblador extends Thread {
    private String nombre;
    private List<String> bandaTransportadora;

    public RobotEnsamblador(String nombre, List<String> bandaTransportadora) {
        this.nombre = nombre;
        this.bandaTransportadora = bandaTransportadora;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String pieza = null;
                synchronized (bandaTransportadora) {
                    while (bandaTransportadora.isEmpty()) {
                        bandaTransportadora.wait(); // esperar hasta que haya piezas
                    }
                    pieza = bandaTransportadora.remove(0);
                }
                System.out.println("Robot " + nombre + " procesando " + pieza);
                Thread.sleep(500); // simula ensamblaje
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class EjMaquina {
    public static void main(String[] args) {
        List<String> bandaTransportadora = new ArrayList<>();

        // Crear productor
        MaquinaProductora maquina = new MaquinaProductora(bandaTransportadora);

        // Crear dos consumidores
        RobotEnsamblador robot1 = new RobotEnsamblador("A", bandaTransportadora);
        RobotEnsamblador robot2 = new RobotEnsamblador("B", bandaTransportadora);

        // Lanzar hilos
        maquina.start();
        robot1.start();
        robot2.start();
    }
}

