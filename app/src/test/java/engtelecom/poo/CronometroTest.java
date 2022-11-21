package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CronometroTest {
    @Test
    void testIncrementa() throws InterruptedException {
        Principal canva = new Principal();
        Cronometro c = new Cronometro(0, 0, 0, null, null);

        // para esse test, foi criado 3 métodos set, para hora, min e segundo
        c.setHour(99);
        c.setMin(59);
        c.setSec(50);

        // verifica se mesmo com o tempo cheio, continua retornando verdadeiro
        for (int i = 0; i < 20; i++) {
            assertTrue(c.incrementa(canva.getDesenhoCanva()));
        }
    }

}
