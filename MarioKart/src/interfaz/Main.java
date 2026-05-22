package interfaz;

import modelo.Participante;
import servicio.Carrera;

import java.util.ArrayList;
import java.util.List;

//este es para crear a los personajes y hacer la carrera
public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando MarioKart");

        Carrera carrera = new Carrera();

        String[] nombres = {"luigi", "mario", "bowser", "rosalina", "yoshi", "peach", "toad", "donkey kong"};

        List<Thread> hilos = new ArrayList<>();
        for (String nombre : nombres) {
            Participante p = new Participante(nombre, carrera);
            carrera.registrarParticipante(p); //registra la Carrera
            Thread t = new Thread(p);
            hilos.add(t);
            t.start();
        }

        //espera a que todos terminen
        for (Thread t : hilos) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Todos los participantes han terminado.");
        System.out.println("Revisar ranking_final.txt");
    }
}