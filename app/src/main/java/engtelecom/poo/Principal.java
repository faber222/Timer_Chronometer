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
        Cronometro cronometro = new Cronometro(100, 100, 20, Color.BLUE, Color.CYAN);
        Contador contador = new Contador(10, 0, 0, 100, 200, 20, Color.BLUE, Color.CYAN);

        while (!cronometro.isFim() && !contador.isFim()) {
            projeto.desenhoCanva.clear();
            projeto.desenhoCanva.enableDoubleBuffering();
            contador.decrementa(projeto.desenhoCanva);
            cronometro.incrementa(projeto.desenhoCanva);
            projeto.desenhoCanva.show();
            // Dormindo por 1 segundo
            Thread.sleep(1000);
        }
    }
}