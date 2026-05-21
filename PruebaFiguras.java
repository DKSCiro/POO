class Circulo {
    static float PI = 3.14159f;
    private float radio;

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public float perimetro() {
        return 2 * PI * radio;
    }

    public float area() {
        return PI * radio * radio;
    }

    public String toString() {
        return "Circulo [radio=" + radio + "]";
    }
}

public class PruebaFiguras {
    public static void main(String[] args) {
        Circulo cir = new Circulo();
        cir.setRadio(7.2f);
        System.out.println("El area es " + cir.area());
    }
}