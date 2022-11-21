package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PrincipalTest {
    @Test
    void testMain() throws InterruptedException {
        Color verdeEscuro = new Color(15, 51, 0);
        Principal canva = new Principal();
        Cronometro c = new Cronometro(0, 400, 100, Color.GREEN, verdeEscuro);
        ContadorRegressivo r = new ContadorRegressivo(0, 0, 0, 0, 0, 0, null, null);

        // Teste para verificar se os construtores estão funcionando

        // Verifica se o incremento com o objeto cronometro instanciado é verdadeiro
        assertTrue(c.incrementa(canva.getDesenhoCanva()));

        // verifica se o decremento com o objeto contador instanciado é verdadeiro,
        // mesmo com o objeto com valores nulos
        assertTrue(r.decrementa(canva.getDesenhoCanva()));

    }
}
