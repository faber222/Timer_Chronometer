package engtelecom.poo;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Digito {
    private static final int A = 6;
    private static final int B = 3;
    private static final int C = 2;
    private static final int D = 4;
    private static final int E = 0;
    private static final int F = 1;
    private static final int G = 5;

    private Segmento[] segmentos;
    private double posX;
    private double posY;
    private int size;

    /**
     * 
     * @param posX
     * @param posY
     * @param size
     */
    public Digito(double posX, double posY, int size) {
        this.segmentos = new Segmento[7];
        if (verificaCoord(posX, posY)) {
            this.posX = posX;
            this.posY = posY;
        } else {
            this.posX = 0;
            this.posY = 400;
        }
        if (verificaSize(size)) {
            this.size = size;
        } else {
            this.size = 40;
        }
        for (int i = 0; i < 7; i++) {
            Segmento seg = new Segmento();
            this.segmentos[i] = seg;
        }
    }

    /**
     * @return the posX
     */
    public double getPosX() {
        return posX;
    }

    /**
     * 
     * @param x
     * @param y
     * @return
     */
    private boolean verificaCoord(double x, double y) {
        return (x <= 800 && x >= 0 && y <= 800 && y >= 0);
    }

    /**
     * 
     * @param size
     * @return
     */
    private boolean verificaSize(double size) {
        return size >= 20 && size <= 100;
    }

    /**
     * /*
     * 0 = E
     * 1 = F
     * 2 = C
     * 3 = B
     * 4 = D
     * 5 = G
     * 6 = A
     *
     * @param colorOn
     * @param colorOff
     * @param digito
     * @param desenho
     * @return
     */
    public boolean desenhaDigito(Color colorOn, Color colorOff, int digito, Draw desenho) {
        if (digito >= 0 && digito <= 9) {
            double xPosVertE = this.posX;
            double yPosVertE = this.posY;

            double xPosVertF = this.posX;
            double yPosVertF = this.posY + this.size;

            double xPosVertC = xPosVertF + (this.size * 0.8);
            double yPosVertC = yPosVertF - this.size;

            double xPosVertB = xPosVertC;
            double yPosVertB = yPosVertC + this.size;

            // -------------------------------------------------------------------------------------------------
            // desenha segmentos Verticais
            // -------------------------------------------------------------------------------------------------
            this.segmentos[E].desenhaSegmento(xPosVertE, yPosVertE, colorOn, desenho, this.size, false);
            this.segmentos[F].desenhaSegmento(xPosVertF, yPosVertF, colorOn, desenho, this.size, false);
            this.segmentos[C].desenhaSegmento(xPosVertC, yPosVertC, colorOn, desenho, this.size, false);
            this.segmentos[B].desenhaSegmento(xPosVertB, yPosVertB, colorOn, desenho, this.size, false);

            double xPosHoriD = this.posX;
            double yPosHoriD = this.posY + (-0.05 * this.size);

            double xPosHoriG = this.posX;
            double yPosHoriG = yPosHoriD + this.size;

            double xPosHoriA = this.posX;
            double yPosHoriA = yPosHoriG + this.size;
            // -------------------------------------------------------------------------------------------------
            // desenha segmentos Horizontais
            // -------------------------------------------------------------------------------------------------
            this.segmentos[D].desenhaSegmento(xPosHoriD, yPosHoriD, colorOn, desenho, this.size, true);
            this.segmentos[G].desenhaSegmento(xPosHoriG, yPosHoriG, colorOn, desenho, this.size, true);
            this.segmentos[A].desenhaSegmento(xPosHoriA, yPosHoriA, colorOn, desenho, this.size, true);

            switch (digito) {
                case 0:
                    this.segmentos[G].desenhaSegmento(xPosHoriG, yPosHoriG, colorOff, desenho, this.size, true);
                    break;
                case 1:
                    this.segmentos[D].desenhaSegmento(xPosHoriD, yPosHoriD, colorOff, desenho, this.size, true);
                    this.segmentos[G].desenhaSegmento(xPosHoriG, yPosHoriG, colorOff, desenho, this.size, true);
                    this.segmentos[A].desenhaSegmento(xPosHoriA, yPosHoriA, colorOff, desenho, this.size, true);
                    this.segmentos[E].desenhaSegmento(xPosVertE, yPosVertE, colorOff, desenho, this.size, false);
                    this.segmentos[F].desenhaSegmento(xPosVertF, yPosVertF, colorOff, desenho, this.size, false);
                    break;
                case 2:
                    this.segmentos[C].desenhaSegmento(xPosVertC, yPosVertC, colorOff, desenho, this.size, false);
                    this.segmentos[F].desenhaSegmento(xPosVertF, yPosVertF, colorOff, desenho, this.size, false);
                    break;
                case 3:
                    this.segmentos[E].desenhaSegmento(xPosVertE, yPosVertE, colorOff, desenho, this.size, false);
                    this.segmentos[F].desenhaSegmento(xPosVertF, yPosVertF, colorOff, desenho, this.size, false);
                    break;
                case 4:
                    this.segmentos[A].desenhaSegmento(xPosHoriA, yPosHoriA, colorOff, desenho, this.size, true);
                    this.segmentos[D].desenhaSegmento(xPosHoriD, yPosHoriD, colorOff, desenho, this.size, true);
                    this.segmentos[E].desenhaSegmento(xPosVertE, yPosVertE, colorOff, desenho, this.size, false);
                    break;
                case 5:
                    this.segmentos[B].desenhaSegmento(xPosVertB, yPosVertB, colorOff, desenho, this.size, false);
                    this.segmentos[E].desenhaSegmento(xPosVertE, yPosVertE, colorOff, desenho, this.size, false);
                    break;
                case 6:
                    this.segmentos[B].desenhaSegmento(xPosVertB, yPosVertB, colorOff, desenho, this.size, false);
                    break;
                case 7:
                    this.segmentos[D].desenhaSegmento(xPosHoriD, yPosHoriD, colorOff, desenho, this.size, true);
                    this.segmentos[E].desenhaSegmento(xPosVertE, yPosVertE, colorOff, desenho, this.size, false);
                    this.segmentos[F].desenhaSegmento(xPosVertF, yPosVertF, colorOff, desenho, this.size, false);
                    this.segmentos[G].desenhaSegmento(xPosHoriG, yPosHoriG, colorOff, desenho, this.size, true);
                    break;
                case 9:
                    this.segmentos[E].desenhaSegmento(xPosVertE, yPosVertE, colorOff, desenho, this.size, false);
                    break;
                default:
                    break;
            }
            return true;
        }
        return false;

    }

}