package list.operacoesBasicas;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListaTarefasTest {

    private ListaTarefas listaTarefas;

    @Before
    public void setUp() {
        listaTarefas = new ListaTarefas(new ArrayList<>()); // Create an empty list
    }

    @Test
    public void testAdicionarNaLista() {
        String descricao = "Comprar leite";
        listaTarefas.adicionarNaLista(descricao);

        assertEquals(1, listaTarefas.obterNumeroTotalDeTarefas());
        assertTrue(listaTarefas.listaTarefas.get(0).getDescricao().equals(descricao));
    }

    @Test
    public void testRemoverTarefa() {
        String descricao1 = "Lavar carro";
        String descricao2 = "Passear com o cachorro";

        listaTarefas.adicionarNaLista(descricao1);
        listaTarefas.adicionarNaLista(descricao2);

        listaTarefas.removerTarefa(descricao1);

        assertEquals(1, listaTarefas.obterNumeroTotalDeTarefas());
        assertFalse(listaTarefas.listaTarefas.get(0).getDescricao().equals(descricao1));
        assertTrue(listaTarefas.listaTarefas.get(0).getDescricao().equals(descricao2));
    }

    @Test
    public void testObterDescricaoTarefasComListaVazia() {
        // Test to see if the method handles an empty list gracefully
        listaTarefas.obterDescricaoTarefas(); // No assertion needed here, just verifying no errors
    }

    @Test
    public void testRemoverTarefaInexistente() {
        String descricao1 = "Lavar carro";

        listaTarefas.adicionarNaLista(descricao1);

        // Trying to remove a task that doesn't exist
        listaTarefas.removerTarefa("Passear com o cachorro");

        assertEquals(1, listaTarefas.obterNumeroTotalDeTarefas());
    }

    @Test
    public void testAdicionarMultiplasTarefas() {
        String descricao1 = "Lavar carro";
        String descricao2 = "Passear com o cachorro";

        listaTarefas.adicionarNaLista(descricao1);
        listaTarefas.adicionarNaLista(descricao2);

        assertEquals(2, listaTarefas.obterNumeroTotalDeTarefas());
    }

    @Test
    public void testRemoverTodasTarefas() {
        String descricao1 = "Lavar carro";
        String descricao2 = "Passear com o cachorro";

        listaTarefas.adicionarNaLista(descricao1);
        listaTarefas.adicionarNaLista(descricao2);

        listaTarefas.removerTarefa(descricao1);
        listaTarefas.removerTarefa(descricao2);

        assertEquals(0, listaTarefas.obterNumeroTotalDeTarefas());
    }

    @Test
    public void testRemoverTarefaComDescricaoDuplicada() {
        String descricao = "Lavar carro";

        listaTarefas.adicionarNaLista(descricao);
        listaTarefas.adicionarNaLista(descricao);

        listaTarefas.removerTarefa(descricao);

        assertEquals(0, listaTarefas.obterNumeroTotalDeTarefas());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarTarefaComDescricaoVazia() {
        listaTarefas.adicionarNaLista("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverTarefaComDescricaoVazia() {
        listaTarefas.removerTarefa("");
    }

    @Test
    public void testAdicionarTarefaComDescricaoDuplicada() {
        String descricao = "Lavar carro";

        listaTarefas.adicionarNaLista(descricao);
        listaTarefas.adicionarNaLista(descricao);

        assertEquals(1, listaTarefas.obterNumeroTotalDeTarefas());
    }


}

