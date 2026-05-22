public class Empleado3 {
    private String nombre;
    private int numEmpleado, sueldo;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNumEmpleado(int numEmpleado){
        this.numEmpleado = numEmpleado;
    }

    public int getNumEmpleado(){
        return this.numEmpleado;
    }

    public void setSueldo(int sueldo){
        if (sueldo >= 0) {
            this.sueldo = sueldo;
        }
    }

    public int getSueldo(){
        return this.sueldo;
    }

    public void aumentarSueldo(int porcentaje){
        sueldo += (int) (sueldo * porcentaje / 100);
    }

    public String toString (){
        return "Nombre: " + this.nombre +
               "\nNúmero: " + this.numEmpleado +
               "\nSueldo: " + this.sueldo;
    }
}

class Gerente extends Empleado3 {
    private int presupuesto;

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getPresupuesto() {
        return this.presupuesto;
    }

    void asignarPresupuesto(int p) {
        presupuesto = p;
    }

    public String toString() {
        return super.toString() +
            "\nPresupuesto: " + this.presupuesto;
    }
}

class PruebaEmpleado3 {
    public static void main (String [] args){
        Gerente gerente = new Gerente();
        gerente.setNombre("Luis Aguilar");
        gerente.setNumEmpleado(8524);
        gerente.setSueldo(16000);
        gerente.setPresupuesto(50000);
        // Se manda llamar el método toString, el cual
        // fue sobrescrito en la clase Empleado.
        System.out.println(gerente);
    }
}