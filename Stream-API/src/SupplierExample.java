import java.util.List;
import java.util.stream.Stream;

public class SupplierExample {
    public static void main(String[] args) {

        List<String> listaSaudacoes = Stream.generate(()->"Olá, seja bem vindo(a)!").limit(5).toList();

        listaSaudacoes.forEach(System.out::println); //reference method
    }
}
