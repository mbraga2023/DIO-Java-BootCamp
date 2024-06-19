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
                ", Saldo após transação: " + saldoAposTransacao;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public double getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(double valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public double getSaldoAposTransacao() {
        return saldoAposTransacao;
    }

    public void setSaldoAposTransacao(double saldoAposTransacao) {
        this.saldoAposTransacao = saldoAposTransacao;
    }
}
