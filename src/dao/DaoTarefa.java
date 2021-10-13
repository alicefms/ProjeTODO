package dao;

import infra.Conexao;
import model.Tarefa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DaoTarefa {
    private Conexao conexao;
    String query = "";

    public DaoTarefa() throws SQLException, ClassNotFoundException {
        conexao = new Conexao();
    }

    public void incluirTarefa(Tarefa tarefa) throws SQLException {
        query = "insert into tarefa (idColaborador, descrTarefa, dataHoraInicio, dataHoraFim, " +
                "statusTarefa, prioridadeTarefa) values(?,?,?,?,?,?)";
        try{
            PreparedStatement statement = this.conexao.getConnection().prepareStatement(query);
            statement.setInt(1, tarefa.getIdColaborador());
            statement.setString(2, tarefa.getDescrTarefa());
            statement.setTimestamp(3, tarefa.getDataHoraInicio());
            statement.setTimestamp(4, tarefa.getDataHoraFim());
            statement.setString(5, tarefa.getStatusTarefa());
            statement.setString(6, tarefa.getPrioridadeTarefa());

            statement.execute();
            this.conexao.commit();
            this.conexao.close();

        }catch (SQLException e){
            this.conexao.rollback();
            throw e;
        }

    }

    public void alterarTarefa(int idTarefa, int novoColaborador, String novaDescricao, Timestamp novoFim,
                              String novoStatus, String novaPrioridade) throws SQLException {
        query = "update tarefa set idColaborador = ? , descrTarefa =? , dataHoraFim =?, " +
                "statusTarefa=?, prioridadeTarefa=? where idTarefa =? ";
        try {
            PreparedStatement statement = this.conexao.getConnection().prepareStatement(query);
            statement.setInt(1, novoColaborador);
            statement.setString(2, novaDescricao);
            statement.setTimestamp(3, novoFim);
            statement.setString(4, novoStatus);
            statement.setString(5, novaPrioridade);
            statement.setInt(6, idTarefa);

            statement.execute();
            this.conexao.commit();
            this.conexao.close();
        }catch (SQLException e){
            this.conexao.rollback();
            throw e;
        }
    }

    public void excluirTarefa(int idTarefa) throws SQLException {
        query = "delete from tarefa where idTarefa =?";
        try{
            PreparedStatement statement = this.conexao.getConnection().prepareStatement(query);
            statement.setInt(1,idTarefa);
            statement.execute();
            this.conexao.commit();
            this.conexao.close();
        }catch (SQLException e){
            this.conexao.rollback();
            throw e;
        }
    }

    public List<Tarefa> consultarTarefas() throws SQLException {
        query = "select * from tarefa";
        try{
            PreparedStatement statement = this.conexao.getConnection().prepareStatement(query);
            ResultSet res = statement.executeQuery();
            List<Tarefa> listaTarefas = new ArrayList<>();
            while (res.next()){
                Tarefa tarefa = new Tarefa(
                        res.getInt("idTarefa"),
                        res.getInt("idColaborador"),
                        res.getString("descrTarefa"),
                        res.getTimestamp("dataHoraInicio"),
                        res.getTimestamp("dataHoraFim"),
                        res.getString("statusTarefa"),
                        res.getString("prioridadeTarefa")

                );
                listaTarefas.add(tarefa);
            }
            return listaTarefas;

        }catch (SQLException e){
            throw e;
        }
    }

    public Tarefa consultarTarefa(int idTarefa) throws SQLException {
        query= "select * from tarefa where idTarefa=?";
       try{
           PreparedStatement statement = this.conexao.getConnection().prepareStatement(query);

        statement.setInt(1, idTarefa);
        ResultSet res = statement.executeQuery();
        Tarefa tarefa = null;
        if(res.next()){
            tarefa = new Tarefa(
                    res.getInt("idTarefa"),
                    res.getInt("idColaborador"),
                    res.getString("descrTarefa"),
                    res.getTimestamp("dataHoraInicio"),
                    res.getTimestamp("dataHoraFim"),
                    res.getString("statusTarefa"),
                    res.getString("prioridadeTarefa") );
        }
        return tarefa;
    }catch (SQLException e){
           throw e;
       }
    }
}
