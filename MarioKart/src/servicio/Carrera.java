package servicio;

import modelo.Participante;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private final List<String> ranking = new ArrayList<>();

    public Carrera() {
        
    }

    public synchronized void registrarLlegada(Participante p) {
        if (ranking.contains(p.getNombre())) return;
        ranking.add(p.getNombre());
        int puesto = ranking.size();
        String linea = puesto + ". " + p.getNombre() + " - " + LocalDateTime.now();

        try (FileWriter fw = new FileWriter("ranking_final.txt", true)) {
            fw.write(linea + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Error escribiendo ranking: " + e.getMessage());
        }

        System.out.println(linea);
    }

    public synchronized void actualizarPosicion(String nombre, int pos) {
        System.out.println(nombre + " está en posición " + pos);
    }
}
