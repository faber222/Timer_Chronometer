package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

import org.junit.jupiter.api.Test;

public class ContadorRegressivoTest {
    @Test
    void testDecrementa() throws InterruptedException {
        Principal canva = new Principal();
        ContadorRegressivo r = new ContadorRegressivo(0, 0, 10, 0, 10, 50, null, null);
        
        // verifica se mesmo com o tempo zerado, continua retornando verdadeiro
        for (int i = 0; i < 20; i++) {
            assertTrue(r.decrementa(canva.getDesenhoCanva())); 
        }

    }

}
