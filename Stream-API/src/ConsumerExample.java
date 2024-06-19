import java.util.Arrays;
import java.util.List;

public class ConsumerExample {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

/*        Consumer<Integer> imprimirNumeroPar = numero -> {
            if (numero % 2 == 0) {
                System.out.println(numero);
            }
        };
        //usar o consumer
        numeros.stream().forEach(imprimirNumeroPar);*/

        numeros.forEach(n -> {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        });
    }
}
