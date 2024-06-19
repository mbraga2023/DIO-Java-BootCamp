package dominio;

public class Extrato {
    private String tipoTransacao;
    private double valorTransacao;
    private double saldoAposTransacao;

    public Extrato(String tipoTransacao, double valorTransacao, double saldoAposTransacao) {
        this.tipoTransacao = tipoTransacao;
        this.valorTransacao = valorTransacao;
        this.saldoAposTransacao = saldoAposTransacao;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipoTransacao +
                ", Valor: " + valorTransacao +
                ", Saldo após transação: R$ " + saldoAposTransacao;
    }
}
