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
    public void deposito(double valor) {
        saldo += valor;
        registrarExtrato("Depósito", valor, saldo);
    }


}
