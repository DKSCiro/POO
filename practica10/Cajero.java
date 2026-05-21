package practica10;

public class Cajero {

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta();
        try {
            cuenta.depositar(2000);
            cuenta.retirar(1000);
            cuenta.getSaldo();
            cuenta.retirar(1000);
            cuenta.getSaldo();
            cuenta.retirar(1000);
            cuenta.getSaldo();
            cuenta.depositar(200);
            cuenta.retirar(100);
        } catch (SaldoInsuficienteException e) {
            e.printStackTrace();
        }
    }

}
