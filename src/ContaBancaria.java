public class ContaBancaria {
    private String nomeTitular;
    private double saldo;
    private double limite;

    public String getNomeTitular() {
        return nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean sacar(double valor) {
        if (valor > saldo + limite) {
            return false;
        }

        saldo -= valor;
        return true;
    }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            return false;
        }

        saldo += valor;
        return true;
    }
}
