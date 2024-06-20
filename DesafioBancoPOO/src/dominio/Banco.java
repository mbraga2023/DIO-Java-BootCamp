package dominio;

import java.util.List;

public abstract class Banco {
    public abstract void criarConta(String nomeCliente,
                                    String tipoConta,
                                    double depositoInicial);
}

