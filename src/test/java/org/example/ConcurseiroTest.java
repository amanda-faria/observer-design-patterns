package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcurseiroTest {
    @Test
    void deveNotificarUmConcurseiro() {
        Concurso concurso = new Concurso(2021, 1, "Cesgranrio", "Analista");
        Concurseiro concurseiro = new Concurseiro("Concurseiro 1");
        concurseiro.prestar(concurso);
        concurso.lancarNotas();
        assertEquals("Concurseiro 1, nota lançada no Concurso{ano=2021, semestre=1, nomeBanca='Cesgranrio', nomeConcurso='Analista'}", concurseiro.getUltimaNotificacao());
    }

    @Test
    void deveNotificarConcurseiros() {
        Concurso concurso = new Concurso(2021, 1, "Cesgranrio", "Analista");
        Concurseiro concurseiro1 = new Concurseiro("Concurseiro 1");
        Concurseiro concurseiro2 = new Concurseiro("Concurseiro 2");
        concurseiro1.prestar(concurso);
        concurseiro2.prestar(concurso);
        concurso.lancarNotas();
        assertEquals("Concurseiro 1, nota lançada no Concurso{ano=2021, semestre=1, nomeBanca='Cesgranrio', nomeConcurso='Analista'}", concurseiro1.getUltimaNotificacao());
        assertEquals("Concurseiro 2, nota lançada no Concurso{ano=2021, semestre=1, nomeBanca='Cesgranrio', nomeConcurso='Analista'}", concurseiro2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarConcurseiro() {
        Concurso concurso = new Concurso(2021, 1, "Cesgranrio", "Analista de testes");
        Concurseiro concurseiro = new Concurseiro("Concurseiro 1");
        concurso.lancarNotas();
        assertEquals(null, concurseiro.getUltimaNotificacao());
    }

    @Test
    void deveNotificarConcurseiroDoConcursoAnalista() {
        Concurso concursoA = new Concurso(2021, 1, "Cesgranrio", "Analista");
        Concurso concursoB = new Concurso(2021, 1, "Cesgranrio2", "Bancario");
        Concurseiro concurseiro1 = new Concurseiro("Concurseiro 1");
        Concurseiro concurseiro2 = new Concurseiro("Concurseiro 2");
        concurseiro1.prestar(concursoA);
        concurseiro2.prestar(concursoB);
        concursoA.lancarNotas();
        assertEquals("Concurseiro 1, nota lançada no Concurso{ano=2021, semestre=1, nomeBanca='Cesgranrio', nomeConcurso='Analista'}", concurseiro1.getUltimaNotificacao());
        assertEquals(null, concurseiro2.getUltimaNotificacao());
    }
}