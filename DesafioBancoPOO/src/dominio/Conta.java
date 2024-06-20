package dominio;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    protected String tipoConta;
    protected String numeroConta;
    protected double saldo;
    protected List<Extrato> extratos;

    public Conta(String tipoConta, double saldoInicial) {
        this.tipoConta = tipoConta;
        this.saldo = saldoInicial;
        this.numeroConta = gerarNumeroConta(); // Generate a new account number
        this.extratos = new ArrayList<>();
        registrarExtrato("Depósito", saldoInicial, saldoInicial);
    }

    public void deposit(double valor) {
        saldo += valor;
        registrarExtrato("Depósito", valor, saldo);
    }

    public abstract void sacar(double valor);

    public abstract void transferir(Conta destino, double valor);

    public String getTipoConta() {
        return tipoConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Extrato> getExtratos() {
        return extratos;
    }

    public void setExtratos(List<Extrato> extratos) {
        this.extratos = extratos;
    }

    // Method to generate a random 4-digit account number
    private String gerarNumeroConta() {
        int numConta = (int) (Math.random() * (9999 - 1000 + 1)) + 1000; // Random number between 1000 and 9999
        return "CC" + numConta; // Example: CC1234
    }

    protected void registrarExtrato(String tipoTransacao, double valorTransacao, double saldoAposTransacao) {
        Extrato extrato = new Extrato(tipoTransacao, valorTransacao, saldoAposTransacao);
        extratos.add(extrato);
    }
}
