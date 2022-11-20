package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

public class Principal {

    private Draw desenhoCanva;

    public Principal() throws InterruptedException {
        // usado para não criar tela fantasma
        this.desenhoCanva = new Draw();
        Thread.sleep(1000);
        this.desenhoCanva.setCanvasSize(800, 800);
        this.desenhoCanva.setXscale(0, 800);
        this.desenhoCanva.setYscale(0, 800);
    }

    public static void main(String[] args) throws InterruptedException {
        Principal projeto = new Principal();
        Cronometro cronometro = new Cronometro(0, 400, 50, Color.BLACK, Color.GREEN);
        Contador contador = new Contador(00, 0, 10, 0, 100, 50, Color.BLACK, Color.GREEN);

        while (!cronometro.isFim() || !contador.isFim()) {
            projeto.desenhoCanva.clear(projeto.desenhoCanva.LIGHT_GRAY);
            projeto.desenhoCanva.enableDoubleBuffering();

            contador.decrementa(projeto.desenhoCanva);
            cronometro.incrementa(projeto.desenhoCanva);

            projeto.desenhoCanva.show();
            // Dormindo por 1 segundo
            Thread.sleep(1000);
        }
    }
}