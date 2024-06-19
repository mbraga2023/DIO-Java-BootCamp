package dominio;

import java.util.Random;

public abstract class Conta {
    protected String tipoConta;
    protected String numeroConta;
    protected double saldo;

    public Conta(String tipoConta, double saldoInicial) {
        this.tipoConta = tipoConta;
        this.saldo = saldoInicial;
        this.numeroConta = gerarNumeroConta(); // Generate a new account number
    }

    // Abstract methods for depositar, sacar, transferir

    public String getTipoConta() {
        return tipoConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    // Method to generate a random 4-digit account number
    private String gerarNumeroConta() {
        Random random = new Random();
        int numConta = random.nextInt(9000) + 1000; // Generate number between 1000 and 9999
        return "Conta: " + numConta; // Example: CC1234
    }

    // Setter for numeroConta (if needed)
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public abstract void depositar(double valor);

    public abstract void sacar(double valor);

    public abstract void transferir(Conta destino, double valor);
}
