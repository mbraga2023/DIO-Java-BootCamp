import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Digite o primeiro parâmetro");
                int parametroUm = terminal.nextInt();
                System.out.println("Digite o segundo parâmetro");
                int parametroDois = terminal.nextInt();

                if (parametroUm < parametroDois) {
                    contar(parametroUm, parametroDois);
                    break; // If no exception occurred, break out of the loop
                } else {
                    throw new IllegalArgumentException("O segundo parâmetro deve ser maior que o primeiro");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                terminal.nextLine(); // Consume the invalid input
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        terminal.close(); // Close the scanner when done
    }

    static void contar(int parametroUm, int parametroDois) {
        try {
            if (parametroUm >= parametroDois) {
                throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
            }

            int contagem = parametroDois - parametroUm;
            System.out.println("Resultado: " + contagem);
            for (int i = parametroUm; i < parametroDois; i++) {
                System.out.println(i);
            }
        } catch (ParametrosInvalidosException e) {
            System.out.println(e.getMessage());
        }
    }
}