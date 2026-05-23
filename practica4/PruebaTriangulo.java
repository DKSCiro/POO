package practica4;
class Triangulo {
    float base, altura;

    // Usa los atributos del objeto
    public float area() {
        return (base * altura) / 2.0f;
    }

    // Usa parámetros enteros
    public float area(int base, int altura) {
        return (base * altura) / 2.0f;
    }

    // Usa parámetros flotantes
    public float area(float base, float altura) {
        return (base * altura) / 2.0f;
    }
}

public class PruebaTriangulo {
    public static void main(String[] args){ 
        Triangulo triangulo = new Triangulo();
        triangulo.base = 5;
        triangulo.altura = 8;

        System.out.println("Base: " + triangulo.base);
        System.out.println("Altura: " + triangulo.altura);

        // Ahora sí existen los métodos
        System.out.println("Area() = " + triangulo.area());
        System.out.println("Area(6, 2) = " + triangulo.area(6, 2));
        System.out.println("Area(5.5f, 3.2f) = " + triangulo.area(5.5f, 3.2f));
    }
}