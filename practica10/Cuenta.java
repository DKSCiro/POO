package practica10;

public class Cuenta {

    private double saldo;

    public Cuenta() {
        saldo = 0;
    }

    public void depositar(double monto) {
        System.out.println("Depositando " + monto);
        saldo += monto;
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        System.out.println("Retirando " + monto);
        if (saldo < monto)
            throw new SaldoInsuficienteException();
        else
            saldo -= monto;
    }

    public double getSaldo() {
        return saldo;
    }
}

