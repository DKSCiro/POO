import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

// 1. CLASE IMPRESORA
class Impresora {
    private String tipo;
    private double costoPorHoja;
    private int totalImpresiones;
    private final int LIMITE_MAXIMO = 50; // Límite por máquina según tus apuntes

    public Impresora(String tipo, double costoPorHoja) {
        this.tipo = tipo;
        this.costoPorHoja = costoPorHoja;
        this.totalImpresiones = 0;
    }

    public double procesarImpresion(int cantidadSolicitada) {
        if (this.totalImpresiones + cantidadSolicitada <= LIMITE_MAXIMO) {
            this.totalImpresiones += cantidadSolicitada;
            return cantidadSolicitada * this.costoPorHoja;
        } else {
            System.out.println("   [!] ALERTA: La impresora de " + tipo + " llegó a su límite (50). No se pudo imprimir.");
            return 0.0;
        }
    }

    public int getTotalImpresiones() { return totalImpresiones; }
    public String getTipo() { return tipo; }
}

// 2. CLASE CLIENTE (Representa a las personas en la fila)
class Cliente {
    private int id;
    private int tiempoUso; // Random time para desocupar
    private int tipoImpresion; // 0: Ninguna, 1: B/N, 2: Color
    private int cantidadImpresiones;

    public Cliente(int id) {
        Random rand = new Random();
        this.id = id;
        this.tiempoUso = rand.nextInt(50) + 10; // Tiempo aleatorio entre 10 y 60 mins
        this.tipoImpresion = rand.nextInt(3);   // Decide aleatoriamente qué imprimir (0, 1 o 2)
        
        if (this.tipoImpresion != 0) {
            // Regla de negocio: Impresión max = 3 por persona
            this.cantidadImpresiones = rand.nextInt(3) + 1; 
        } else {
            this.cantidadImpresiones = 0;
        }
    }

    public int getId() { return id; }
    public int getTiempoUso() { return tiempoUso; }
    public int getTipoImpresion() { return tipoImpresion; }
    public int getCantidadImpresiones() { return cantidadImpresiones; }
}

// 3. CLASE PRINCIPAL (El Sistema / Flujo)
public class PruebaCiber {

    public static void main(String[] args) {
        // Inicializamos los costos y componentes según tu diagrama
        double costoBaseComputadora = 20.0;
        double totalGanancia = 0.0;
        
        Impresora impresoraBN = new Impresora("Blanco y Negro", 5.0);
        Impresora impresoraColor = new Impresora("Color", 15.0);
        
        // Creamos la fila de personas (simularemos 15 clientes en la fila)
        Queue<Cliente> filaPersonas = new LinkedList<>();
        for (int i = 1; i <= 15; i++) {
            filaPersonas.add(new Cliente(i));
        }

        System.out.println("=== INICIANDO SISTEMA DEL CENTRO DE CÓMPUTO ===\n");

        // Procesamos la fila (tomando en cuenta que hay 3 computadoras)
        int computadoraActual = 1;

        while (!filaPersonas.isEmpty()) {
            Cliente clienteActivo = filaPersonas.poll(); // Saca a la persona de la fila
            double cobroCliente = 0.0;

            System.out.println("-> Cliente #" + clienteActivo.getId() + " asignado a Computadora " + computadoraActual);
            System.out.println("   Tiempo de uso: " + clienteActivo.getTiempoUso() + " minutos.");
            
            // Cobro base por uso de PC
            cobroCliente += costoBaseComputadora;

            // Lógica de impresión
            if (clienteActivo.getTipoImpresion() == 1) {
                System.out.println("   Solicita: " + clienteActivo.getCantidadImpresiones() + " impresiones en B/N.");
                cobroCliente += impresoraBN.procesarImpresion(clienteActivo.getCantidadImpresiones());
            } 
            else if (clienteActivo.getTipoImpresion() == 2) {
                System.out.println("   Solicita: " + clienteActivo.getCantidadImpresiones() + " impresiones a Color.");
                cobroCliente += impresoraColor.procesarImpresion(clienteActivo.getCantidadImpresiones());
            } 
            else {
                System.out.println("   No solicitó impresiones.");
            }

            System.out.println("   Total a pagar por Cliente #" + clienteActivo.getId() + ": $" + cobroCliente);
            System.out.println("--------------------------------------------------");

            // Sumamos al total de la ganancia del negocio
            totalGanancia += cobroCliente;

            // Rotamos las computadoras (1, 2, 3, 1, 2, 3...)
            computadoraActual++;
            if (computadoraActual > 3) {
                computadoraActual = 1;
            }
        }

        // Resumen final del día
        System.out.println("\n=== CORTE DE CAJA Y RESUMEN FINAL ===");
        System.out.println("Total Ganancia: $" + totalGanancia);
        System.out.println("Hojas consumidas B/N: " + impresoraBN.getTotalImpresiones() + "/50");
        System.out.println("Hojas consumidas Color: " + impresoraColor.getTotalImpresiones() + "/50");
    }
}
