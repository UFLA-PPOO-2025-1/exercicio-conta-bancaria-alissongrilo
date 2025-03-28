import java.util.ArrayList;
import java.util.Scanner;

public class CaixaEletronico {
    private ArrayList<ContaBancaria> contas;
    private Scanner scanner;

    public CaixaEletronico() {
        scanner = new Scanner(System.in);
        contas = new ArrayList<>();
    }

    public void run() {
        int opcao = 0;

        while (opcao != 8) {
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
                    exibirContas();
                    break;
                case 6:
                    render();
                    break;
                case 7:
                    modificarTaxaRendimento();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void menu() {
        System.out.println("1 - Criar conta");
        System.out.println("2 - Consultar Saldo");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");
        System.out.println("5 - Exibir contas");
        System.out.println("6 - Render");
        System.out.println("7 - Modificar taxa de rendimento");
        System.out.println("8 - Sair");
    }

    private void criarConta() {
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

        ContaBancaria contaBancaria;

        if (resposta.equalsIgnoreCase("Y")) {
            System.out.println("Digite o saldo inicial da conta: ");
            double saldo = Double.parseDouble(scanner.nextLine());

            contaBancaria = new ContaBancaria(nome, limite, saldo);
            contas.add(contaBancaria);
        } else {
            contaBancaria = new ContaBancaria(nome, limite);
            contas.add(contaBancaria);
        }

        System.out.println("Conta ID: " + contaBancaria.getId() + " criada com sucesso!");
    }

    private void consultarSaldo() {
        if (contas.isEmpty()) {
            System.out.println("Contas não encontrada!");
            return;
        }

        System.out.println("Digite o ID da conta: ");
        int id = Integer.parseInt(scanner.nextLine());

        ContaBancaria contaBancaria = getContaById(id);

        if (contaBancaria == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        System.out.println("Saldo: " + contaBancaria.getSaldo());
    }

    private void depositar() {
        if (contas.isEmpty()) {
            System.out.println("Contas não encontrada!");
            return;
        }

        System.out.println("Digite o ID da conta: ");
        int id = Integer.parseInt(scanner.nextLine());

        ContaBancaria contaBancaria = getContaById(id);

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

    private void sacar() {
        if (contas.isEmpty()) {
            System.out.println("Contas não encontrada!");
            return;
        }

        System.out.println("Digite o ID da conta: ");
        int id = Integer.parseInt(scanner.nextLine());

        ContaBancaria contaBancaria = getContaById(id);

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

    private void exibirContas() {
        for (ContaBancaria conta : contas) {
            System.out.println(conta.getId() + " - " + conta.getNomeTitular());
        }
    }

    private ContaBancaria getContaById(int id) {
        for (ContaBancaria conta : contas) {
            if (conta.getId() == id) {
                return conta;
            }
        }

        return null;
    }

    private void render() {
        if (contas.isEmpty()) {
            System.out.println("Contas não encontrada!");
            return;
        }

        for (ContaBancaria conta : contas) {
            conta.render();
        }

        System.out.println("Rendimento aplicado com sucesso!");
    }

    private void modificarTaxaRendimento() {
        System.out.println("Digite a nova taxa de rendimento: ");
        double taxaRendimento = Double.parseDouble(scanner.nextLine());

        ContaBancaria.setTaxaRendimento(taxaRendimento);
        System.out.println("Taxa de rendimento modificada com sucesso!");
    }
}
