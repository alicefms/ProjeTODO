create database todo;
use todo;

CREATE TABLE Colaborador (
    idcolaborador   int auto_increment NOT NULL,
    nomeColaborador Varchar(30) NOT NULL,
    PRIMARY KEY (idcolaborador)
);

CREATE TABLE Tarefa (
    idTarefa         int auto_increment NOT NULL,
    idColaborador    integer NOT NULL,
    descrTarefa      Varchar(50),
    dataHoraInicio   Timestamp NOT NULL,
    dataHoraFim      Timestamp ,
    statusTarefa     Varchar(15),
    prioridadeTarefa Varchar(15),
    PRIMARY KEY (idTarefa, idColaborador)
);

ALTER TABLE Tarefa ADD FOREIGN KEY (idColaborador) REFERENCES Colaborador(idcolaborador);


insert into tarefa (idColaborador, descrTarefa, dataHoraInicio, dataHoraFim, statusTarefa, prioridadeTarefa) values(3, "teste","2021-10-13",  "2021-10-13 13:45:44", "F", "K");