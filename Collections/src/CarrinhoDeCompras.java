import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarrinhoDeCompras {

        Scanner scanner = new Scanner(System.in);

        public List<Item> itens;

        public CarrinhoDeCompras() {
                this.itens = new ArrayList<>();
        }


        public void adicionarItem(String nome, double preco, int quantidade) {

                itens.add(new Item(nome, preco, quantidade));

        }

        public void removerItem(String nome) {
                itens.removeIf(item -> item.getNome().equals(nome));

        }

        public double calcularValorTotal() {
                double total = 0;
                for (Item item : itens) {
                        total += item.getPreco() * item.getQuantidade();
                }
                return total;
        }

        public void exibirItens() {
                System.out.println("Itens no carrinho:");
                for (Item item : itens) {
                        System.out.println("Nome: " + item.getNome() + ", Preço unitário: " + item.getPreco() + ", Quantidade: " + item.getQuantidade());
                }
        }
}
