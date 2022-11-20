package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;

import java.awt.Color;

/**
 * Classe segmento
 */
public class Segmento {
    /**
     * Atributo vetorial que representa todas as posições do segmento em X
     */
    private double[] posX;
    /**
     * Atributo vetorial que representa todas as posições do segmento em Y
     */
    private double[] posY;

    /**
     * Método privado, usado para calcular a posição do segmento na horizontal.
     * Receve como parametro 3 doubles, um que representa o tamanho a ser desenhado
     * o segmento, um para representar o segmento em X e outro em Y
     * 
     * @param fator    Double para representar o tamanho
     * @param xInicial Double para representar a posição X
     * @param yInicial Double para representar a posição Y
     * @return Retorna true caso seja possivel calcular os valores dos vetores X e
     *         Y, caso contrario retorna false
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
     * Método privado, usado para calcular a posição do segmento na vertical.
     * Receve como parametro 3 doubles, um que representa o tamanho a ser desenhado
     * o segmento, um para representar o segmento em X e outro em Y
     * 
     * @param fator    Double para representar o tamanho
     * @param xInicial Double para representar a posição X
     * @param yInicial Double para representar a posição Y
     * @return Retorna true caso seja possivel calcular os valores dos vetores X e
     *         Y, caso contrario retorna false
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
     * Método principal da classe Segmento.
     * Tal método desenha no canvas um poligono de 6 lados, baseado em 3 parametros,
     * posição X, posição Y e tamanho.
     * Com esses 3 valores, consegue calcular a posição do desenho.
     * Com o atributo Color, Draw e Boolean, é possivel definir, respectivamente, a
     * cor do segmento, o canvas a ser desenhado, e um boolean para definir se é
     * horizontal ou vertical.
     * 
     * @param x          Double para representar a posição X
     * @param y          Double para representar a posição Y
     * @param cor        Color para representar a cor do segmento
     * @param desenho    Draw para representar o canvas a ser desenhado
     * @param fator      Double para representar o tamanho do segmento
     * @param horizontal Boolean para verificar se vai ser segmento horizontal ou
     *                   vertical
     * @return Retorna true caso pos X e Y estejam entre (0 --> 800), se não,
     *         retorna false
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