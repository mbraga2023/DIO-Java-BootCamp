package dominio;

public class ContaCorrente extends Conta {

    public ContaCorrente(double saldoInicial) {
        super("Corrente", saldoInicial);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    @Override
    public void transferir(Conta destino, double valor) {
        if (destino instanceof ContaCorrente || destino instanceof ContaPoupanca) {
            if (saldo >= valor) {
                saldo -= valor;
                destino.depositar(valor);
            } else {
                System.out.println("Saldo insuficiente para transferência.");
            }
        } else {
            System.out.println("Tipo de conta destino inválido para transferência.");
        }
    }
}
