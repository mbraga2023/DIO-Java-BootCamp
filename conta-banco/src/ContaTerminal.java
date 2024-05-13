import java.util.Random;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {

        Random aleatorio = new Random();
        int numero = aleatorio.nextInt(10000); // Generate a random number up to 9999
        String numeroFormatado = String.format("%04d", numero); // Format the number with leading zeros
        String nomeCliente;
        String agenciaNumero;
        Double saldoCliente;

         
        System.out.println("Desafio DIO -  Conta Banco");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        nomeCliente = scanner.nextLine();

        System.out.print("Digite o numero da agência: ");
        agenciaNumero = scanner.nextLine();

        System.out.print("Digite o saldo do cliente R$: ");
        saldoCliente= (double) scanner.nextInt();

        System.out.println("Olá "+ nomeCliente + 
        ", obrigado por criar uma conta em nosso banco, sua agência é " + 
        agenciaNumero + ", conta " + numeroFormatado + " e seu saldo R$" + saldoCliente + 
        " já está disponível para saque");

        scanner.close();


    }
}
