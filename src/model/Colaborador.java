package model;

/**
 * Modela a classe Colaborador, traz um construtor e os gets e sets e o toString()
 */
public class Colaborador {

    public int idColaborador;
    public String nomeColaborador;

    public Colaborador(int idColaborador, String nomeColaborador) {
        this.idColaborador = idColaborador;
        this.nomeColaborador = nomeColaborador;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    @Override
    public String toString() {
        return  "id = " + idColaborador + '\n' +
                "nome" + nomeColaborador + '\n' ;
    }
}