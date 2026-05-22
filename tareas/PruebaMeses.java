public interface Meses {
    int UNO = 1, DOS = 2, TRES = 3, CUATRO = 4, CINCO = 5, SEIS = 6;
    int SIETE = 7, OCHO = 8, NUEVE = 9, DIEZ = 10, ONCE = 11, DOCE = 12;

    String [] NOMBRES_MESES = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "ovtubre", "Noviembre", "Diciembre"};
}

public class PruebaMeses {
    public static void main(String[] args) {
        //se puede acceder a las variables de la interfaz sin crear instancias 
        System.out.println("El mes " + Meses.DOS + " corresponde a: " );
        System.out.println(Meses.NOMBRES_MESES[Meses.DOS]);
    }
}