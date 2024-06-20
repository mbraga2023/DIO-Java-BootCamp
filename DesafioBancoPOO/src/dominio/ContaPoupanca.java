package dominio;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(double saldoInicial) {
        super("Poupança", saldoInicial);
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            registrarExtrato("Saque", -valor, saldo);
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    @Override
    public void transferir(Conta destino, double valor) {
        if (destino instanceof ContaPoupanca) {
            if (saldo >= valor) {
                saldo -= valor;
                destino.deposit(valor);
                registrarExtrato("Transferência - Enviado", -valor, saldo);
                destino.registrarExtrato("Transferência - Recebido", valor, destino.getSaldo());
            } else {
                System.out.println("Saldo insuficiente para transferência.");
            }
        } else {
            System.out.println("Tipo de conta destino inválido para transferência.");
        }
    }
}
