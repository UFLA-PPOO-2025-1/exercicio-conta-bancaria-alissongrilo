import java.util.Scanner;

public class CaixaEletronico {
    private ContaBancaria contaBancaria;
    private Scanner scanner;

    public CaixaEletronico() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        int opcao = 0;

        while (opcao != 5) {
            menu();
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    criarConta();

                    break;
                case 2:
                    consultarSaldo();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    sacar();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public void menu() {
        System.out.println("1 - Criar conta");
        System.out.println("2 - Consultar Saldo");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");
        System.out.println("5 - Sair");
    }

    public void criarConta() {
        System.out.println("Digite o nome do titular da conta: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o limite inicial da conta: ");
        double limite = Double.parseDouble(scanner.nextLine());

        System.out.println("Você deseja iniciar a conta com saldo? (Y/N)");
        String resposta = scanner.nextLine();

        while (!resposta.equalsIgnoreCase("Y") && !resposta.equalsIgnoreCase("N")) {
            System.out.println("Resposta inválida! Digite Y para sim ou N para não.");
            resposta = scanner.nextLine();
        }

        if (resposta.equalsIgnoreCase("Y")) {
            System.out.println("Digite o saldo inicial da conta: ");
            double saldo = Double.parseDouble(scanner.nextLine());
            contaBancaria = new ContaBancaria(nome, limite, saldo);
        } else {
            contaBancaria = new ContaBancaria(nome, limite);
        }

        System.out.println("Conta criada com sucesso!");
    }

    public void consultarSaldo() {
        if (contaBancaria == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        System.out.println("Saldo: " + contaBancaria.getSaldo());
    }

    public void depositar() {
        if (contaBancaria == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        System.out.println("Digite o valor a ser depositado: ");
        double valor = Double.parseDouble(scanner.nextLine());

        if (contaBancaria.depositar(valor)) {
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor inválido!");
        }
    }

    public void sacar() {
        if (contaBancaria == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        System.out.println("Digite o valor a ser sacado: ");
        double valor = Double.parseDouble(scanner.nextLine());

        if (contaBancaria.sacar(valor)) {
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
}
