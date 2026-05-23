package practica4;
class Punto {
    int x, y;

    public void ImprimePunto() {
        System.out.println("Punto [x = " + x + ", y = " + y + "]");
    }
}

public class PruebaPunto {
    public static void main(String[] args){ 
        // Declaramos y creamos el objeto p
        Punto p = new Punto(); 
        p.x = 5;
        p.y = 8;
        p.ImprimePunto();

        // Segundo punto
        Punto x = new Punto();
        x.x = 7;
        x.y = 2;
        x.ImprimePunto();
    }
}
