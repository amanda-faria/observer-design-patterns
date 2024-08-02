package org.example;

import java.util.Observable;
import java.util.Observer;

public class Concurseiro implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Concurseiro(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void prestar(Concurso concurso) {
        concurso.addObserver(this);
    }

    public void update(Observable concurso, Object arg1) {
        this.ultimaNotificacao = this.nome + ", nota lançada no " + concurso.toString();
        // System.out.println(this.ultimaNotificacao);
    }
}
