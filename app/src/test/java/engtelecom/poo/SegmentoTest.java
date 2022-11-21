package engtelecom.poo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

public class SegmentoTest {
    @Test
    void testDesenhaSegmento() throws InterruptedException {
        Principal canva = new Principal();
        Color verdeEscuro = new Color(15, 51, 0);
        Cronometro c = new Cronometro(10, 10, 100, Color.GREEN, verdeEscuro);
        c.incrementa(canva.getDesenhoCanva());
        
        Segmento[] d = c.getDisplayCro().getDigitos().get(0).getSegmentos();

        // retorna verdadeiro devido a posição de x e y estarem entre (0 --> 800)
        assertTrue(d[0].desenhaSegmento(10, 10, verdeEscuro, canva.getDesenhoCanva(), 10, false));

        // retorna falso devido o valor de x ser maior que 800
        assertFalse(d[0].desenhaSegmento(1000, 10, verdeEscuro, canva.getDesenhoCanva(), 10, false));

        // retorna falso devido o valor de y ser maior que 800
        assertFalse(d[0].desenhaSegmento(100, 1000, verdeEscuro, canva.getDesenhoCanva(), 10, false));

        // retorna falso devido o valor de x e y serem maior que 800
        assertFalse(d[0].desenhaSegmento(1000, 1000, verdeEscuro, canva.getDesenhoCanva(), 10, false));

        // retorna falso devido o valor de x ser menor que 0
        assertFalse(d[0].desenhaSegmento(-10, 100, verdeEscuro, canva.getDesenhoCanva(), 10, false));

        // retorna falso devido o valor de y ser menor que 0
        assertFalse(d[0].desenhaSegmento(100, -10, verdeEscuro, canva.getDesenhoCanva(), 10, false));

        // retorna falso devido o valor de x e y ser menor que 0
        assertFalse(d[0].desenhaSegmento(-10, -10, verdeEscuro, canva.getDesenhoCanva(), 10, false));
    }

}
