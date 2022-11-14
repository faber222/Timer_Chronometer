package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;

public class Principal {

    private Draw desenhoCanva;

    public Principal() {
        this.desenhoCanva = new Draw();
        this.desenhoCanva.setCanvasSize(800, 800);
        this.desenhoCanva.setXscale(0, 800);
        this.desenhoCanva.setYscale(0, 800);
    }
    
    public static void main(String[] args) {
        Cronometro cronometro = new Cronometro(0, 0, 0, null, null);
        Contador contador = new Contador(0, 0, 0, 0, 0, 0, null, null);

        contador.Decrementa();
        cronometro.incrementa();
    }
}