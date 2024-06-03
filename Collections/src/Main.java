import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar item ao carrinho");
            System.out.println("2. Remover item do carrinho");
            System.out.println("3. Exibir itens do carrinho");
            System.out.println("4. Sair");

            System.out.print("Escolha uma opção: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                switch (choice) {
                    case 1:
                        System.out.print("Nome do item: ");
                        String nome = scanner.nextLine();
                        System.out.print("Preço do item: ");
                        double preco = scanner.nextDouble();
                        System.out.print("Quantidade do item: ");
                        int quantidade = scanner.nextInt();
                        carrinho.adicionarItem(nome, preco, quantidade);
                        break;
                    case 2:
                        System.out.println("Itens no carrinho:");
                        for (Item item : carrinho.itens) {
                            System.out.println("Item: " + item.getNome());
                        }
                        System.out.println("***");
                        System.out.print("Nome do item a ser removido: ");
                        String nomeRemover = scanner.nextLine();
                        carrinho.removerItem(nomeRemover);
                        System.out.println("***");
                        System.out.println("Item removido");
                        break;

                    case 3:
                        carrinho.exibirItens();
                        System.out.println("Valor total do carrinho: " + carrinho.calcularValorTotal());

                        break;
                    case 4:
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
        } while (choice != 5);

        scanner.close();
    }
}
