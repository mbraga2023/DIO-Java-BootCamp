import java.util.Arrays;
import java.util.List;

public class PredicateExample {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("java", "php", "python", "kotlin", "javaScript", "c", "go", "ruby");

       /* Predicate<String> maisDeCincoCaracteres = palavra -> palavra.length() >5;

        palavras.stream().filter(maisDeCincoCaracteres).forEach(System.out::println);*/
        palavras.stream().filter(p -> p.length() > 5).forEach(System.out::println);
    }
}
