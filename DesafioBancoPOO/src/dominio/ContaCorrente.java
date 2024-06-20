package dominio;

public class ContaCorrente extends Conta {

    public ContaCorrente(double saldoInicial) {
        super("Corrente", saldoInicial);
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
    public void deposito(double valor) {
        saldo += valor;
        registrarExtrato("Depósito", valor, saldo);
    }


}
