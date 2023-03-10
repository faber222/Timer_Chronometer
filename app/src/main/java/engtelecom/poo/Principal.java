package engtelecom.poo;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

/**
 * Classe principal
 */
public class Principal {
    /**
     * Objeto Draw para ser a tela de desenho
     */
    private Draw desenhoCanva;

    /**
     * Construtor da classe principal, que define o tamanho do canvas em 800 e
     * instancia um objeto da classe Draw
     * 
     * @throws InterruptedException Não verifica erros
     */
    public Principal() throws InterruptedException {
        // usado para não criar tela fantasma
        this.desenhoCanva = new Draw();
        Thread.sleep(1000);
        this.desenhoCanva.setCanvasSize(800, 800);
        this.desenhoCanva.setXscale(0, 800);
        this.desenhoCanva.setYscale(0, 800);
    }

    /**
     * Classe static void main, onde ocorre a chamada dos métodos de cada objeto
     * cronometro e contador regressivo
     * 
     * @param args Não é passado nada
     * @throws InterruptedException Não é verificado erros
     */
    public static void main(String[] args) throws InterruptedException {
        Color verdeEscuro = new Color(15, 51, 0);
        Color vermelhoVinho = new Color(51, 0, 0);

        Principal projeto = new Principal();

        Cronometro cronometro = new Cronometro(0, 400, 20, Color.GREEN, verdeEscuro);
        ContadorRegressivo contador = new ContadorRegressivo(10, 40, 10, 0, 100, 40, Color.RED, vermelhoVinho);
        while (!cronometro.isFim() || !contador.isFim()) {
            projeto.getDesenhoCanva().clear(Draw.BLACK);
            projeto.getDesenhoCanva().enableDoubleBuffering();

            contador.decrementa(projeto.getDesenhoCanva());
            cronometro.incrementa(projeto.getDesenhoCanva());

            projeto.getDesenhoCanva().show();
            // Dormindo por 1 segundo
            Thread.sleep(1000);
        }
    }

    /**
     * @return the desenhoCanva
     */
    public Draw getDesenhoCanva() {
        return desenhoCanva;
    }
}