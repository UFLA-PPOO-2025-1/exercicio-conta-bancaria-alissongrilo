public class ContaBancaria {
    private String nomeTitular;
    private double saldo;
    private double limite;
    private int id;

    private static double taxaRendimento = 0.1;
    private static int ultimoId = 100;

    public ContaBancaria(String nomeTitular, double limite) {
        this.id = ++ultimoId;
        this.nomeTitular = nomeTitular;
        this.limite = limite;
        this.saldo = 0;
    }

    public ContaBancaria(String nomeTitular, double limite, double saldo) {
        this(nomeTitular, limite);
        this.saldo = saldo;
    }

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

    public int getId() {
        return id;
    }

    public void render() {
        saldo += saldo * taxaRendimento;
    }
}
