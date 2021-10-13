package model;

import java.sql.Timestamp;

/**
 * Modela a classe Tarefa,
 * Traz 2 construtores (um com id de tarefa e outro sem o id de tarefa)
 * Traz os gets e sets
 * Traz o ToString()
 */
public class Tarefa {

    public int idTarefa;
    public int idColaborador;
    public String descrTarefa;
    public Timestamp dataHoraInicio;
    public Timestamp dataHoraFim;
    public String statusTarefa;
    public String prioridadeTarefa;


    public Tarefa(int idTarefa, int idColaborador, String descrTarefa, Timestamp dataHoraInicio, Timestamp dataHoraFim, String statusTarefa, String prioridadeTarefa) {
        this.idTarefa = idTarefa;
        this.idColaborador = idColaborador;
        this.descrTarefa = descrTarefa;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.statusTarefa = statusTarefa;
        this.prioridadeTarefa = prioridadeTarefa;
    }



    public Tarefa(int idColaborador, String descrTarefa, Timestamp dataHoraInicio, Timestamp dataHoraFim, String statusTarefa, String prioridadeTarefa) {
        this.idColaborador = idColaborador;
        this.descrTarefa = descrTarefa;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.statusTarefa = statusTarefa;
        this.prioridadeTarefa = prioridadeTarefa;
    }



    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getDescrTarefa() {
        return descrTarefa;
    }

    public void setDescrTarefa(String descrTarefa) {
        this.descrTarefa = descrTarefa;
    }

    public Timestamp getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Timestamp dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Timestamp getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Timestamp dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getStatusTarefa() {
        return statusTarefa;
    }

    public void setStatusTarefa(String statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    public String getPrioridadeTarefa() {
        return prioridadeTarefa;
    }

    public void setPrioridadeTarefa(String prioridadeTarefa) {
        this.prioridadeTarefa = prioridadeTarefa;
    }

    @Override
    public String toString() {
        return  "id = " + idTarefa + '\n'+
                "idColaborador = " + idColaborador + '\n' +
                "descrição = " + descrTarefa + '\n' +
                "Inicio = " + dataHoraInicio + '\n' +
                "Fim = " + dataHoraFim + '\n' +
                "status = " + statusTarefa + '\n' +
                "prioridade = " + prioridadeTarefa + '\n' ;
    }
}