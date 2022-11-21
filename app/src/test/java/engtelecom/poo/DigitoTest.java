package engtelecom.poo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

public class DigitoTest {
    // verificar se o digito passado é valido para desenhar as posições
    @Test
    void testDesenhaDigito() throws InterruptedException {
        Principal canva = new Principal();
        Color verdeEscuro = new Color(15, 51, 0);
        Cronometro c = new Cronometro(0, 0, 100, Color.GREEN, verdeEscuro);

        // para esse test, foi necessário criar um get no valor de digitos da
        // classe Display, devido ao fato que a passagem de numeros invalidos não chegar
        // até o digito, mas é necessário testar o método

        // retorna verdadeiro devido ao digito ser valido, entre 0 --> 9 
        assertTrue(c.getDisplayCro().getDigitos().get(0).desenhaDigito(verdeEscuro, verdeEscuro, 7,
                canva.getDesenhoCanva()));

        // retorna falso devido ao digito ser invalido, entre 0 --> 9
        assertFalse(c.getDisplayCro().getDigitos().get(0).desenhaDigito(verdeEscuro, verdeEscuro, 10,
                canva.getDesenhoCanva()));

                // retorna falso devido ao digito ser invalido, entre 0 --> 9
        assertFalse(c.getDisplayCro().getDigitos().get(0).desenhaDigito(verdeEscuro, verdeEscuro, -1,
                canva.getDesenhoCanva()));

    }

}
