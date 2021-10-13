package server;

import dao.DaoTarefa;
import model.Tarefa;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.time.Instant;

public class ControleDeTarefasBack {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DaoTarefa daoTarefa = new DaoTarefa();

        /* //INCLUIR TAREFA
        Tarefa tarefa = new Tarefa(1, "Terminar os métodos", new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()), "I", "A" );
        daoTarefa.incluirTarefa(tarefa);
        */

        /*  //CONSULTAR TAREFAS
        System.out.println(daoTarefa.consultarTarefas());
        */

        /* // CONSULTA UMA TAREFA PELO ID
        System.out.println(daoTarefa.consultarTarefa(1));
        */

        /*//EXCLUI UMA TAREFA
        daoTarefa.excluirTarefa(1);
        */

       /* // ALTERA TAREFA
        daoTarefa.alterarTarefa(3, 1, "Fazer métodos de colaborador", new Timestamp(System.currentTimeMillis()), "C", "U");
        */
    }
}
