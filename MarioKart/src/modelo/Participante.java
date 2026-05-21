package modelo;

import servicio.Carrera;

public class Participante implements Runnable {
    private final String nombre;
    private final Carrera carrera;
    private int posicion = 0;
    private final int META = 100;

    public Participante(String nombre, Carrera carrera) {
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        
        while (posicion < META) {
            int avance = (int) (Math.random() * 10) + 1;
            posicion += avance;
            carrera.actualizarPosicion(nombre, posicion);

            if (posicion >= META) {
                carrera.registrarLlegada(this);
                break;
            }

            try {
                Thread.sleep(300); //pausa entre turnos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
