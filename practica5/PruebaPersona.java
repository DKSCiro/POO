class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha() {
    }

    public Fecha(int dia, int mes, int anio) {
        setDia(dia);
        setMes(mes);
        setAnio(anio);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dia > 0 && dia < 32) {
            this.dia = dia;
        } else {
            System.out.println("Día no válido");
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (mes > 0 && mes < 13) {
            this.mes = mes;
        } else {
            System.out.println("Mes no válido");
        }
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        if (anio > 0) {
            this.anio = anio;
        } else {
            System.out.println("El año no puede ser negativo");
        }
    }
}

class Persona {
    private String nombre;
    private String apellido;
    private Fecha fNacimiento;

    public Persona() {
    }

    public Persona(String nombre, String apellido, Fecha fNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fNacimiento = fNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Fecha getFNacimiento() {
        return fNacimiento;
    }

    public void setFNacimiento(Fecha fNacimiento) {
        this.fNacimiento = fNacimiento;
    }
}

public class PruebaPersona {

    public static void main(String[] args) {
        Persona per1 = new Persona();
        Fecha nac = new Fecha();

        per1.setNombre("Juan");
        per1.setApellido("Perez");

        nac.setDia(15);
        nac.setMes(8);
        nac.setAnio(1950);

        per1.setFNacimiento(nac);

        System.out.println("Nombre: " + per1.getNombre());
        System.out.println("Apellido: " + per1.getApellido());
        System.out.println("Fecha Nacimiento: " 
            + per1.getFNacimiento().getDia() + "/" 
            + per1.getFNacimiento().getMes() + "/" 
            + per1.getFNacimiento().getAnio());
    }
}