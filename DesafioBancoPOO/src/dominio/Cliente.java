package dominio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private List<Conta> contas;

    public Cliente(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public List<Conta> getContas() {
        return contas;
    }

    public String getNome() {
        return nome;
    }

    public void listarContas() {
        System.out.println("Contas de " + nome + ":");
        for (Conta conta : contas) {
            System.out.println("   - " + conta.getTipoConta() + ": " + conta.getNumeroConta() + " - Saldo: R$ " + conta.getSaldo());
        }
    }
}
