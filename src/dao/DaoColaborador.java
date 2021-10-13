package dao;

import infra.Conexao;
import model.Colaborador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoColaborador {

    private Conexao conexao;
    String query = "";

    public DaoColaborador() throws SQLException, ClassNotFoundException {
        conexao = new Conexao();
    }


    public void incluirColaborador(String nomeColaborador) throws SQLException {
        query = "insert into colaborador (nomeColaborador) values (?)";
        try {
            PreparedStatement statement = this.conexao.getConnection().prepareStatement(query);
            statement.setString(1, nomeColaborador);
            statement.execute();
            this.conexao.commit();
            this.conexao.close();
        }catch (SQLException e){
            this.conexao.rollback();
            throw e;
        }
    }

    public void alterarColaborador(int idColaborador, String novoNome) throws SQLException {
        query = "update colaborador set nomeColaborador = ? where idColaborador=?";
        try{
            PreparedStatement statement = this.conexao.getConnection().prepareStatement(query);
            statement.setString(1, novoNome);
            statement.setInt(2, idColaborador);
            statement.execute();
            this.conexao.commit();
            this.conexao.close();
        }catch (SQLException e){
            this.conexao.rollback();
            throw e;
        }
    }

    public void excluirColaborador(int idColaborador) throws SQLException {
        query = "delete from colaborador where idColaborador = ? ";
        try{
            PreparedStatement statement = this.conexao.getConnection().prepareStatement(query);
            statement.setInt(1, idColaborador);
            statement.execute();
            this.conexao.commit();
            this.conexao.close();
        }catch (SQLException e){
            this.conexao.rollback();
            throw e;
        }

    }

    public List<Colaborador> consultarColaboradores() throws SQLException {
        query = "select * from colaborador";
        try{
            PreparedStatement statement = this.conexao.getConnection().prepareStatement(query);
            ResultSet res = statement.executeQuery();
            List<Colaborador> listaColaboradores = new ArrayList<>();
            while(res.next()){
                Colaborador colaborador = new Colaborador(
                        res.getInt("idColaborador"),
                        res.getString("nomeColaborador")
                );
                listaColaboradores.add(colaborador);
            }
            return listaColaboradores;
        }catch (SQLException e){
            throw e;
        }
    }

    public Colaborador consultarColaborador(int idColaborador) throws SQLException {
        query = "select * from colaborador where idColaborador = ?";
        try{
            PreparedStatement statement = this.conexao.getConnection().prepareStatement(query);
            statement.setInt(1, idColaborador);
            ResultSet res = statement.executeQuery();
            Colaborador colaborador = null;
            if(res.next()){
                colaborador = new Colaborador(
                        idColaborador, res.getString("nomeColaborador")
                );
            }
            return colaborador;
        }catch (SQLException e){
            throw e;
        }

    }
}
