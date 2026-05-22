public class Empleado2 {
    private String nombre;
    private int numEmpleado, sueldo;

    public Empleado2(String nombre, int sueldo, int numEmpleado){
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.numEmpleado = numEmpleado;
    }
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
    public void aumentarSueldo(int porcentaje) {
        sueldo += (int)(sueldo * porcentaje / 100);
    }
    @Override
    public String toString (){
        return "Nombre: " + this.nombre +
               "\nNúmero: " + this.numEmpleado +
               "\nSueldo: " + this.sueldo;
    }
}

class Gerente extends Empleado2 {
    private int presupuesto;
    public Gerente(String nombre, int sueldo, int numEmpleado, int presupuesto) {
        super(nombre, sueldo, numEmpleado); 
        this.presupuesto = presupuesto;
    }
    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }
    public int getPresupuesto() {
        return this.presupuesto;
    }
    void asignarPresupuesto(int p) {
        presupuesto = p;
    }
    @Override
    public String toString() {
        return super.toString() +
               "\nPresupuesto: " + this.presupuesto;
    }
}

class PruebaEmpleado2 {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Luis Aguilar", 16000, 8524, 50000);
        System.out.println(gerente);
    }
}