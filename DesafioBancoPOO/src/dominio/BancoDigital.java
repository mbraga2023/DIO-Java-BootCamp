package dominio;

import java.util.ArrayList;
import java.util.List;

public class BancoDigital {
    private List<Cliente> clientes;

    public BancoDigital() {
        this.clientes = new ArrayList<>();
    }

    public void criarConta(String nomeCliente, String tipoConta, double depositoInicial) {
        Cliente cliente = new Cliente(nomeCliente);

        Conta conta;
        if (tipoConta.equalsIgnoreCase("Corrente")) {
            conta = new ContaCorrente(depositoInicial);
        } else if (tipoConta.equalsIgnoreCase("Poupança")) {
            conta = new ContaPoupanca(depositoInicial);
        } else {
            System.out.println("Tipo de conta inválido.");
            return;
        }

        cliente.adicionarConta(conta);
        clientes.add(cliente);
        System.out.println("Conta criada para o cliente: " + cliente.getNome());
    }

    public void listarClientes() {
        System.out.println("Clientes do Banco:");
        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.getNome());
            cliente.listarContas();
            System.out.println(); // Blank line between clients
        }
    }
}
