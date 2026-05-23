package tareas;
public class PruebaJuego {

    public static void main(String[] args) {

        LogroRto logro = new LogroRto(
                "Sistema",
                "Has derrotado al dragon",
                500
        );

        AlertaMision mision = new AlertaMision(
                "Rey Arturo",
                "Ve al castillo oscuro",
                "Epico"
        );

        logro.mostrar();
        System.out.println();
        mision.mostrar();
    }
}

//Clase padre
class Notificacion {

    protected String emisor;
    protected String mensaje;

    public Notificacion(String emisor, String mensaje) {
        this.emisor = emisor;
        this.mensaje = mensaje;
    }

    public void mostrar() {
        System.out.println(emisor + ": " + mensaje);
    }
}

class LogroRto extends Notificacion {

    private int puntosExperiencia;

    public LogroRto(String emisor, String mensaje, int puntosExperiencia) {
        super(emisor, mensaje);
        this.puntosExperiencia = puntosExperiencia;
    }

    @Override
    public void mostrar() {

        System.out.println("LOGRO DESBLOQUEADO!");
        System.out.println(emisor + " dice: " + mensaje);
        System.out.println("Recompensa: +" + puntosExperiencia + " pts");

    }
}

class AlertaMision extends Notificacion {

    private String nivelDificultad;

    public AlertaMision(String emisor, String mensaje, String nivelDificultad) {
        super(emisor, mensaje);
        this.nivelDificultad = nivelDificultad;
    }

    @Override
    public void mostrar() {

        System.out.println("NUEVA MISION de " + emisor);
        System.out.println(mensaje);
        System.out.println("Dificultad: " + nivelDificultad);

    }
}
