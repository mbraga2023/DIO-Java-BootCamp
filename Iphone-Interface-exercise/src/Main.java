import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        iPhone iPhone = new iPhone("iPhone 12");

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Telefone");
            System.out.println("2. Música");
            System.out.println("3. Internet");
            System.out.println("4. Desligar iPhone e sair");

            System.out.print("Escolha uma opção: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                switch (choice) {
                    case 1:
                        showTelefoneMenu();
                        handleTelefoneMenu(scanner, iPhone);
                        break;
                    case 2:
                        showMusicaMenu();
                        handleMusicaMenu(scanner, iPhone);
                        break;
                    case 3:
                        showInternetMenu();
                        handleInternetMenu(scanner, iPhone);
                        break;
                    case 4:
                        iPhone.desligar();
                        System.out.println("Encerrando o programa.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } else {
                System.out.println("Opção inválida. Por favor, digite um número.");
                scanner.nextLine(); // Clear the invalid input
                choice = 0; // Set choice to 0 to keep the loop running
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void showTelefoneMenu() {
        System.out.println("\nMenu Telefone:");
        System.out.println("1. Fazer chamada");
        System.out.println("2. Atender chamada");
        System.out.println("3. Iniciar correio de voz");
    }

    private static void handleTelefoneMenu(Scanner scanner, iPhone iPhone) {
        int choice;
        System.out.print("Escolha uma opção: ");
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    System.out.print("Digite o número para fazer a chamada: ");
                    String numeroChamada = scanner.nextLine();
                    iPhone.ligar(numeroChamada);
                    break;
                case 2:
                    iPhone.atender();
                    break;
                case 3:
                    iPhone.iniciarCorreioVoz();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } else {
            System.out.println("Opção inválida. Por favor, digite um número.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    private static void showMusicaMenu() {
        System.out.println("\nMenu Música:");
        System.out.println("1. Tocar música");
        System.out.println("2. Pausar música");
        System.out.println("3. Selecionar música");
    }

    private static void handleMusicaMenu(Scanner scanner, iPhone iPhone) {
        int choice;
        System.out.print("Escolha uma opção: ");
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    iPhone.tocar();
                    break;
                case 2:
                    iPhone.pausar();
                    break;
                case 3:
                    System.out.print("Digite o nome da música: ");
                    String musica = scanner.nextLine();
                    iPhone.selecionarMusica(musica);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } else {
            System.out.println("Opção inválida. Por favor, digite um número.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    private static void showInternetMenu() {
        System.out.println("\nMenu Internet:");
        System.out.println("1. Exibir página no navegador");
        System.out.println("2. Adicionar nova aba no navegador");
        System.out.println("3. Atualizar página no navegador");
    }

    private static void handleInternetMenu(Scanner scanner, iPhone iPhone) {
        int choice;
        System.out.print("Escolha uma opção: ");
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    System.out.print("Digite a URL para exibir no navegador: ");
                    String url = scanner.nextLine();
                    iPhone.exibirPagina(url);
                    break;
                case 2:
                    iPhone.adicionarNovaAba();
                    break;
                case 3:
                    iPhone.atualizarPagina();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } else {
            System.out.println("Opção inválida. Por favor, digite um número.");
            scanner.nextLine(); // Clear the invalid input
        }
    }
}
