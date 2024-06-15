import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static class CarrinhoCompras{
        public List<Item> itens;

        public CarrinhoCompras() {
            this.itens = new ArrayList<>();
        }


        public void adicionarItem(int codigo, String nome, double preco, int quantidade) {

            itens.add(new Item(codigo,nome, preco, quantidade));

        }

        public void removerItem(String nome) {
            itens.removeIf(item -> item.getNome().equals(nome));

        }

/*        public double calcularValorTotal() {
            double total = 0;
            for (Item item : itens) {
                total += item.getPreco() * item.getQuantidade();
            }
            return total;
        }*/

        //função, lambda
        public double calcularValorTotal(){
            return itens.stream().mapToDouble(item -> item.getPreco() * item.getQuantidade()).sum();
        }

        //method reference "::"
        public List<Item> ordenarItensPorNome() {
            List<Item> listaOrdenada = new ArrayList<>(itens);
            listaOrdenada.sort(Comparator.comparing(Item::getNome));
            return listaOrdenada;
        }

        public void exibirItens() {
            System.out.println("Itens no carrinho:");
            for (Item item : itens) {
                System.out.println("Nome: " + item.getNome() + ", Preço unitário: " + item.getPreco() + ", Quantidade: " + item.getQuantidade());
            }
        }


    }

    public static void main(String[] args) {

        CarrinhoCompras carrinho = new CarrinhoCompras();

        carrinho.adicionarItem(1, "Smartphone", 999.99, 1);
        carrinho.adicionarItem(2, "Laptop", 1499.99, 1);
        carrinho.adicionarItem(3, "Headphones", 149.50, 2);
        carrinho.adicionarItem(4, "Smart Watch", 299.99, 1);
        carrinho.adicionarItem(5, "Wireless Mouse", 29.99, 3);
        carrinho.adicionarItem(6, "External Hard Drive", 129.99, 1);
        carrinho.adicionarItem(7, "Keyboard", 79.99, 1);
        carrinho.adicionarItem(8, "Monitor", 299.00, 1);
        carrinho.adicionarItem(9, "Desk Lamp", 39.95, 1);
        carrinho.adicionarItem(10, "Backpack", 49.99, 1);


        //carrinho.exibirItens();

        double total = carrinho.calcularValorTotal();
        System.out.println("Valor total: " + total);

        carrinho.ordenarItensPorNome();
        List<Item> itensOrdenados = carrinho.ordenarItensPorNome();
        System.out.println(itensOrdenados);
        for (Item item : itensOrdenados) {
            System.out.println("Nome: " + item.getNome() +
                    ", Preço unitário: " + item.getPreco() +
                    ", Quantidade: " + item.getQuantidade());
        }
    }

}