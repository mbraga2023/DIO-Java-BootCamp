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

    public void extratoConta(String numeroConta) {
        boolean found = false;
        for (Cliente cliente : clientes) {
            for (Conta conta : cliente.getContas()) {
                if (conta.getNumeroConta().equals("CC" + numeroConta)) {
                    found = true;
                    System.out.println("Extrato da Conta " + conta.getNumeroConta());
                    List<Extrato> extratos = conta.getExtratos();
                    for (Extrato extrato : extratos) {
                        System.out.println(extrato);
                    }
                    break;
                }
            }
            if (found) break;
        }
        if (!found) {
            System.out.println("Conta não encontrada.");
        }
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
