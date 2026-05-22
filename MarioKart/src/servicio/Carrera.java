package servicio;

import modelo.Participante;
import util.TipoObjeto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.*;

public class Carrera {
    private final List<String> ranking = new ArrayList<>();
    private final List<Participante> participantes = new ArrayList<>();
    private final Set<Integer> cajas = new HashSet<>();
    private final int META = 100;

    private final Path rankingPath;

    public Carrera() {
        //hay cajas cada 10 espacios excepto la final
        for (int i = 10; i < META; i += 10) {
            cajas.add(i);
        }

        //determina la ruta del archivo
        rankingPath = Paths.get("ranking_final.txt").toAbsolutePath();

        //divide las ejecuciones (modo append)
        String cabecera = "------------------------" + LocalDateTime.now() + " ------------------------";
        try {
            Files.write(rankingPath, Arrays.asList(cabecera), StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Cabecera escrita en: " + rankingPath);
        } catch (IOException e) {
            System.err.println("No se pudo escribir cabecera en " + rankingPath + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    public synchronized void registrarParticipante(Participante p) {
        participantes.add(p);
    }

    public synchronized boolean estaEnRanking(String nombre) {
        for (String linea : ranking) {
            if (linea.contains(". " + nombre + " -")) {
                return true;
            }
        }
        return false;
    }

    public synchronized void registrarLlegada(Participante p) {
        if (estaEnRanking(p.getNombre())) {
            System.out.println("Registro ignorado: " + p.getNombre() + " ya está en el ranking.");
            return;
        }

        int puesto = ranking.size() + 1;
        String linea = puesto + ". " + p.getNombre() + " - " + LocalDateTime.now();
        ranking.add(linea);

        System.out.println("Intentando escribir llegada de " + p.getNombre() + " en " + rankingPath);
        try {
            Files.write(rankingPath, Arrays.asList(linea), StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Escritura OK para " + p.getNombre());
        } catch (IOException e) {
            System.err.println("Error escribiendo ranking para " + p.getNombre() + ": " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("[LLEGADA] " + linea);
    }

    public synchronized void actualizarPosicion(String nombre, int pos) {
        System.out.printf("[TURNO] %s está en posición %d%n", nombre, pos);
    }

    public synchronized void lanzarObjetoDesde(Participante origen, TipoObjeto tipo) {
        List<Participante> posibles = new ArrayList<>();
        for (Participante p : participantes) {
            if (!p.getNombre().equals(origen.getNombre()) && p.getPosicion() < META) {
                posibles.add(p);
            }
        }
        if (posibles.isEmpty()) {
            System.out.printf("[OBJETO] %s obtuvo %s pero no hay objetivos válidos.%n",
                    origen.getNombre(), tipo);
            return;
        }
        Participante objetivo = posibles.get(new Random().nextInt(posibles.size()));
        aplicarObjeto(tipo, objetivo.getNombre(), origen.getNombre());
    }

    public synchronized void aplicarObjeto(TipoObjeto tipo, String objetivoNombre, String desdeNombre) {
        Participante objetivo = null;
        for (Participante p : participantes) {
            if (p.getNombre().equals(objetivoNombre)) {
                objetivo = p;
                break;
            }
        }
        if (objetivo == null) {
            System.out.printf("[OBJETO] No se encontró objetivo %s para aplicar %s%n", objetivoNombre, tipo);
            return;
        }

        switch (tipo) {
            case REDUCCION:
                objetivo.aplicarReduccion(3);
                System.out.printf("[OBJETO] %s lanzó REDUCCION a %s (3 turnos).%n", desdeNombre, objetivoNombre);
                break;
            case BLOQUEO:
                objetivo.aplicarBloqueo(3);
                System.out.printf("[OBJETO] %s lanzó BLOQUEO a %s (3 turnos).%n", desdeNombre, objetivoNombre);
                break;
            default:
                System.out.printf("[OBJETO] Tipo desconocido %s lanzado por %s%n", tipo, desdeNombre);
        }
    }

    public synchronized boolean esCaja(int posicion) {
        return cajas.contains(posicion);
    }

    public synchronized List<String> obtenerNombresParticipantes() {
        List<String> nombres = new ArrayList<>();
        for (Participante p : participantes) nombres.add(p.getNombre());
        return nombres;
    }
}