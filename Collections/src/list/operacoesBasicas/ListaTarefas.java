package list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class ListaTarefas {
    public List<Tarefas> listaTarefas;

    public ListaTarefas(List<Tarefas> listaTarefas) {
        this.listaTarefas = new ArrayList<>(listaTarefas);
    }

    public void adicionarNaLista(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição da tarefa não pode ser vazia");
        }

        // Check for duplicate descriptions
        for (Tarefas tarefa : listaTarefas) {
            if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                throw new IllegalArgumentException("Tarefa com a mesma descrição já existe na lista");
            }
        }

        // If no duplicates found, add the task to the list
        listaTarefas.add(new Tarefas(descricao));
    }


    public void removerTarefa(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição da tarefa não pode ser vazia");
        }

        boolean removed = listaTarefas.removeIf(tarefa -> tarefa.getDescricao().equalsIgnoreCase(descricao));

        if (!removed) {
            throw new IllegalArgumentException("Tarefa com a descrição fornecida não encontrada na lista");
        }
    }


    public int obterNumeroTotalDeTarefas() {
        return listaTarefas.size();
    }

    public void obterDescricaoTarefas() {
        System.out.println(listaTarefas);
    }



    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ListaTarefasTest.class);

        // Print test results summary
        System.out.println("Test Results:");
        System.out.println("Run: " + result.getRunCount());
        System.out.println("Failures: " + result.getFailureCount());
        System.out.println("Ignored: " + result.getIgnoreCount());

        int errors = 0;
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            // Check for errors if needed (based on Failure type)
            if (failure.getException() instanceof Error) {
                errors++;
            }
        }
        System.out.println("Errors (if any): " + errors);
    }

}
