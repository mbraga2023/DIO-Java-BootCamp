import dominio.BancoDigital;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BancoDigital banco = new BancoDigital();
        Scanner scanner = new Scanner(System.in);
        boolean menu = true;

        while (menu) {
            System.out.println("********************************");
            System.out.println("Banco Digital - Visão Bancária");
            System.out.println("********************************");
            System.out.println("1. Criar conta");
            System.out.println("2. Depósito");
            System.out.println("3. Saque");
            System.out.println("4. Transferência");
            System.out.println("5. Lista todos os clientes e saldo");
            System.out.println("6. Extrato");
            System.out.println("7. Sair");
            System.out.print("Digite uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (opcao) {
                case 1:
                    criarConta(banco, scanner);
                    break;
                case 2:
                    // Implement deposit method
                    break;
                case 3:
                    // Implement withdraw method
                    break;
                case 4:
                    // Implement transfer method
                    break;
                case 5:
                    banco.listarClientes();
                    break;
                case 6:
                    System.out.print("Informe o número da conta: ");
                    String numeroConta = scanner.nextLine();
                    banco.extratoConta(numeroConta);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    menu = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

        scanner.close();
    }

    private static void criarConta(BancoDigital banco, Scanner scanner) {
        System.out.println("Criar Nova Conta:");
        System.out.print("Nome do Cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.println("Selecione o tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        System.out.print("Escolha a opção: ");
        int opcaoConta = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        String tipoConta;
        if (opcaoConta == 1) {
            tipoConta = "Corrente";
        } else if (opcaoConta == 2) {
            tipoConta = "Poupança";
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        System.out.print("Informe o depósito inicial: ");
        double depositoInicial = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        banco.criarConta(nomeCliente, tipoConta, depositoInicial);
        System.out.println();
    }
}
