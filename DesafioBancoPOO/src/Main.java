import dominio.BancoDigital;
import dominio.Cliente;
import dominio.Conta;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BancoDigital banco = new BancoDigital();
        criarClienteDummy(banco);

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
                    realizarDeposito(banco, scanner);
                    break;
                case 3:
                    realizarSaque(banco, scanner);
                    break;
                case 4:
                    realizarTransferencia(banco, scanner);
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

    private static void realizarDeposito(BancoDigital banco, Scanner scanner) {
        System.out.print("Informe o número da conta: ");
        String numeroConta = scanner.nextLine();

        System.out.print("Informe o valor do depósito: ");
        double valorDeposito = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        banco.depositar(numeroConta, valorDeposito);

    }

    private static void realizarSaque(BancoDigital banco, Scanner scanner) {
        System.out.print("Informe o número da conta: ");
        String numeroConta = scanner.nextLine();

        System.out.print("Informe o valor do saque: ");
        double valorSaque = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        banco.sacar(numeroConta, valorSaque);
    }


    private static void realizarTransferencia(BancoDigital banco, Scanner scanner) {
        System.out.print("Informe o número da conta de origem: ");
        String numeroContaOrigem = scanner.nextLine();

        System.out.print("Informe o número da conta de destino: ");
        String numeroContaDestino = scanner.nextLine();

        System.out.print("Informe o valor da transferência: ");
        double valorTransferencia = scanner.nextDouble();
        scanner.nextLine();

        banco.depositar(numeroContaDestino, valorTransferencia);
        banco.sacar(numeroContaOrigem, valorTransferencia);
    }

    private static void criarClienteDummy(BancoDigital banco) {
        banco.criarConta("Cliente1", "Corrente", 2000.0); // Example initialization with dummy data
        banco.criarConta("Cliente2", "Poupança", 3000.0); // Example initialization with dummy data
    }
}
