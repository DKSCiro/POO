package modelo;

import servicio.Carrera;
import util.TipoObjeto;

import java.util.Random;

public class Participante implements Runnable {
    private final String nombre;
    private final Carrera carrera;
    private int posicion = 0;
    private final int META = 100;

    //estados por turnos
    private int bloqueadoTurnos = 0;
    private int reduccionTurnos = 0;

    private final Random rnd = new Random();

    public Participante(String nombre, Carrera carrera) {
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public synchronized int getPosicion() {
        return posicion;
    }

    //metodos para aplicar efectos
    public synchronized void aplicarBloqueo(int turnos) {
        bloqueadoTurnos = Math.max(bloqueadoTurnos, turnos);
    }

    public synchronized void aplicarReduccion(int turnos) {
        reduccionTurnos = Math.max(reduccionTurnos, turnos);
    }

    @Override
    public void run() {
        while (posicion < META) {
            //simula el sleep 
            if (bloqueadoTurnos > 0) {
                carrera.actualizarPosicion(nombre, posicion);
                bloqueadoTurnos--;
                try {
                    Thread.sleep(300); //pausa entre turnos
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
                continue;
            }

            int maxDado = (reduccionTurnos > 0) ? 3 : 6;
            int avance = rnd.nextInt(maxDado) + 1;

            int posicionAnterior = posicion;
            posicion += avance;
            if (posicion > META) posicion = META;
            if (reduccionTurnos > 0) reduccionTurnos--;

            //informar la posicion a Carrera (synchronized)
            carrera.actualizarPosicion(nombre, posicion);

            for (int caja = 10; caja < META; caja += 10) {
                if (posicionAnterior < caja && posicion >= caja) {
                    //el personaje toma un objeto REDUCCION y BLOQUEO (es aleatorio)
                    TipoObjeto tipo = rnd.nextBoolean() ? TipoObjeto.REDUCCION : TipoObjeto.BLOQUEO;
                    System.out.printf("[CAJA] %s tomó %s en la caja %d%n", nombre, tipo, caja);
                    carrera.lanzarObjetoDesde(this, tipo);
                    break;
                }
            }

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
