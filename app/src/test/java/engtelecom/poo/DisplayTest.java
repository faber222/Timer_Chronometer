package engtelecom.poo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;

public class DisplayTest {
    // verifica se é possivel desenhar quando se tem valores de hora, minutos e
    // segundos dentro do esperado
    @Test
    void testDesenhaDigitos() throws InterruptedException {
        Principal canva = new Principal();
        Color verdeEscuro = new Color(15, 51, 0);
        Cronometro c = new Cronometro(0, 0, 100, Color.GREEN, verdeEscuro);
        ContadorRegressivo r = new ContadorRegressivo(10, 10, 10, 0, 300, 100, Color.GREEN, verdeEscuro);

        // para esses testes, foi necessário criar getter para ContadorRegressivo e
        // Cronometro, devido ao fato que o construtor ja verifica horários com valores
        // errados. Para que seja verdadeiro, o valor de hora deve ser (0 --> 99), min e
        // segundo (0 --> 59)

        // deve retornar true, devido aos tempos passados estarem corretos

        assertTrue(c.getDisplayCro().desenhaDigitos(10, 10, 10, canva.getDesenhoCanva()));
        assertTrue(r.getDisplayCon().desenhaDigitos(10, 10, 10, canva.getDesenhoCanva()));

        // deve retornar false, devido a alteração dos valores de hora, min e segundos,
        // serem feitas nos métodos incrementa e decrementa, onde a partir do max dos
        // valores, todos vão para 99:59:59, e no decrementa, vão para 00:00:00
        // e caso estejam fora do range de incremento ou decremento, retorna false,
        // exemplo de incrementa em -10, valor invalido, retorna false, caso decrementa
        // seja de 100, valor invalido, retorna false também
        //
        // para o teste, não se faz necessario testar em Contador, devido ambos
        // instanciarem a mesma classe

        // verifica se retorna false caso hora, min ou segundo sejam acima de 99
        assertFalse(c.getDisplayCro().desenhaDigitos(100, 10, 10, canva.getDesenhoCanva()));
        assertFalse(c.getDisplayCro().desenhaDigitos(10, 60, 10, canva.getDesenhoCanva()));
        assertFalse(c.getDisplayCro().desenhaDigitos(10, 10, 60, canva.getDesenhoCanva()));

        // verifica se retorna false caso hora, min ou segundo sejam menores que 0
        assertFalse(c.getDisplayCro().desenhaDigitos(-10, 10, 10, canva.getDesenhoCanva()));
        assertFalse(c.getDisplayCro().desenhaDigitos(10, -10, 10, canva.getDesenhoCanva()));
        assertFalse(c.getDisplayCro().desenhaDigitos(10, 10, -10, canva.getDesenhoCanva()));

        // verifica se retorna false caso hora, min ou segundo sejam maior que 100 e
        // menor que 0 ao mesmo tempo
        assertFalse(c.getDisplayCro().desenhaDigitos(100, -10, -10, canva.getDesenhoCanva()));
        assertFalse(c.getDisplayCro().desenhaDigitos(100, 100, -10, canva.getDesenhoCanva()));
        assertFalse(c.getDisplayCro().desenhaDigitos(100, 100, 100, canva.getDesenhoCanva()));

        // verifica se retorna false caso hora, min e segundo sejam menores que 0 em
        // mais de um atributo
        assertFalse(c.getDisplayCro().desenhaDigitos(-10, -10, -10, canva.getDesenhoCanva()));
        assertFalse(c.getDisplayCro().desenhaDigitos(10, -10, -10, canva.getDesenhoCanva()));
        assertFalse(c.getDisplayCro().desenhaDigitos(-10, 10, -10, canva.getDesenhoCanva()));
        assertFalse(c.getDisplayCro().desenhaDigitos(-10, -10, 10, canva.getDesenhoCanva()));

    }

}
