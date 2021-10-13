package model;

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
        return "Colaborador{" +
                "idColaborador=" + idColaborador +
                ", nomeColaborador='" + nomeColaborador + '\'' +
                '}';
    }
}