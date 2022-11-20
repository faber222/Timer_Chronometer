package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;

import java.awt.Color;

public class Segmento {
    private double[] posX;
    private double[] posY;

    /**
     * 
     * @param fator
     * @param xInicial
     * @param yInicial
     * @return
     */
    private boolean segHorizontal(double fator, double xInicial, double yInicial) {
        if (fator <= 100 && fator >= 20) {
            double[] xHorizontal = { 0.1 * fator + xInicial, 0.2 * fator + xInicial, 0.8 * fator + xInicial,
                    0.9 * fator + xInicial, 0.8 * fator + xInicial, 0.2 * fator + xInicial };

            double[] yHorizontal = { 0.2 * fator + yInicial, 0.3 * fator + yInicial, 0.3 * fator + yInicial,
                    0.2 * fator + yInicial, 0.1 * fator + yInicial, 0.1 * fator + yInicial };
            this.posX = xHorizontal;
            this.posY = yHorizontal;

            return true;
        }
        return false;
    }

    /**
     * 
     * @param fator
     * @param xInicial
     * @param yInicial
     * @return
     */
    private boolean segVertical(double fator, double xInicial, double yInicial) {
        if (fator <= 100 && fator >= 20) {
            double[] xVertical = { 0.1 * fator + xInicial, 0.2 * fator + xInicial, 0.2 * fator + xInicial,
                    0.1 * fator + xInicial, 0 * fator + xInicial, 0 * fator + xInicial };
            double[] yVertical = { 0.2 * fator + yInicial, 0.3 * fator + yInicial, 1.0 * fator + yInicial,
                    1.1 * fator + yInicial, 1.0 * fator + yInicial, 0.3 * fator + yInicial };
            this.posX = xVertical;
            this.posY = yVertical;

            return true;
        }
        return false;
    }

    /**
     * 
     * @param x
     * @param y
     * @param cor
     * @param desenho
     * @param fator
     * @param horizontal
     * @return
     */
    public boolean desenhaSegmento(double x, double y, Color cor, Draw desenho, double fator, boolean horizontal) {
        if (x <= 800 && x >= 0 && y <= 800 && y >= 0) {
            if (horizontal) {
                segHorizontal(fator, x, y);
            } else {
                segVertical(fator, x, y);
            }
            desenho.setPenColor(cor);
            desenho.filledPolygon(this.posX, this.posY);
            return true;
        }
        return false;
    }

}