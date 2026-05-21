package interfaz;

import modelo.Participante;
import servicio.Carrera;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando MarioKart - prueba mínima");
        Carrera carrera = new Carrera();

        List<Thread> hilos = new ArrayList<>();
        for (String nombre : new String[] {"Mario", "Luigi"}) {
            Participante p = new Participante(nombre, carrera);
            Thread t = new Thread(p);
            hilos.add(t);
            t.start();
        }

        // esperar a que terminen todos los hilos
        for (Thread t : hilos) {
            try { t.join(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }

        System.out.println("Todos los participantes han terminado.");
    }
}

