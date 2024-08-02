package org.example;

import java.util.Observable;

public class Concurso extends Observable {

    private Integer ano;
    private Integer semestre;
    private String nomeBanca;
    private String nomeConcurso;

    public Concurso(Integer ano, Integer semestre, String nomeBanca, String nomeConcurso) {
        this.ano = ano;
        this.semestre = semestre;
        this.nomeBanca = nomeBanca;
        this.nomeConcurso = nomeConcurso;
    }

    public void lancarNotas() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Concurso{" +
                "ano=" + ano +
                ", semestre=" + semestre +
                ", nomeBanca='" + nomeBanca + '\'' +
                ", nomeConcurso='" + nomeConcurso + '\'' +
                '}';
    }
}