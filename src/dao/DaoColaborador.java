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


    /**
     * Adiciona um novo colaborador no banco de dados, passando apenas o nome do colaborador como parâmetro
     * já que o id é autoincrementado no banco.
     * @param nomeColaborador
     * @throws SQLException
     */
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

    /**
     * Altera o nome colaborador no banco de dados
     * @param idColaborador
     * @param novoNome
     * @throws SQLException
     */
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

    /**
     * Exclui do banco o colaborador que tem a id passada como parâmetro
     * @param idColaborador
     * @throws SQLException
     */
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

    /**
     * Consulta todos os colaboradores cadastrados no banco de dados
     * @return - retorna uma lista de objetos do tipo colaborador - para exibir no console, usar o alguma funçao que printe.
     * @throws SQLException
     */
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

    /**
     * Consulta um colaborador pelo ia
     * @param idColaborador
     * @return - retorna um objeto do tipo colaborador
     * @throws SQLException
     */
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
