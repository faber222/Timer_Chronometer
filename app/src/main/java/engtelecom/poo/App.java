package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

public class App {

    // Não iremos tratar as possíveis exceções de execução
    public static void main(String[] args) throws Exception {
        Draw desenho = new Draw();
        // dimensão da área de desenho (canvas)
        int dimensao = 800;
        desenho.setXscale(0, 800);
        desenho.setYscale(0, 800);
        // Toda ação de desenho acontecerá em um buffer secundário e este só será visto
        // depois que for invocado o método show()
        desenho.enableDoubleBuffering();

        // determina a proporção que será usada para desenhar todos os elementos
        double galo = 200;

        double fator = 300;

        desenho.clear();
        desenhaGrade(galo, desenho, dimensao);
        double xInicial = 100;
        double yInicial = 100;
        desenhaSegHorizontal(fator, desenho, xInicial, yInicial, Color.BLUE);

        yInicial += 0.05 * fator;

        desenhaSegVertical(fator, desenho, xInicial, yInicial, Color.BLUE);

        // Trocando o buffer para exibir o que foi desenhado
        desenho.show();

    

    } // fim do main

    public static void desenhaSegmentoE(double[] xVertical, double[] yVertical, Color cor, Draw desenho) {
        desenho.setPenColor(cor);
        desenho.filledPolygon(xVertical, yVertical);
    }

    public static void desenhaSegmentoF(double[] xVertical, double[] yVertical, Color cor, Draw desenho, double fator) {
        // desenha seg F
        for (int i = 0; i < xVertical.length; i++) {
            yVertical[i] += fator;
        }
        desenho.setPenColor(cor);
        desenho.filledPolygon(xVertical, yVertical);
    }

    public static void desenhaSegmentoC(double[] xVertical, double[] yVertical, Color cor, Draw desenho, double fator) {
        // desenha seg C
        // Desenhando outro segmento vertical com um espaço de 200 pixels em X
        for (int i = 0; i < xVertical.length; i++) {
            xVertical[i] += fator;
            yVertical[i] -= fator;
        }

        desenho.setPenColor(cor);
        desenho.filledPolygon(xVertical, yVertical);
    }

    public static void desenhaSegmentoB(double[] xVertical, double[] yVertical, Color cor, Draw desenho, double fator) {
        // desenha seg F
        for (int i = 0; i < xVertical.length; i++) {
            yVertical[i] += fator;
        }
        desenho.setPenColor(cor);
        desenho.filledPolygon(xVertical, yVertical);
    }

    public static void desenhaSegVertical(double fator, Draw desenho, double xInicial, double yInicial, Color cor) {
        // ---------------------------------------- //
        // Montando vetores com os pontos em X e em Y para desenhar um segmento vertical

        double[] xVertical = { 0.1 * fator + xInicial, 0.2 * fator + xInicial, 0.2 * fator + xInicial,
                0.1 * fator + xInicial, 0 * fator + xInicial, 0 * fator + xInicial };
        double[] yVertical = { 0.2 * fator + yInicial, 0.3 * fator + yInicial, 1.0 * fator + yInicial,
                1.1 * fator + yInicial, 1.0 * fator + yInicial, 0.3 * fator + yInicial };

        desenhaSegmentoE(xVertical, yVertical, cor, desenho);

        desenhaSegmentoF(xVertical, yVertical, cor, desenho, fator);
        desenhaSegmentoC(xVertical, yVertical, cor, desenho, fator);
        desenhaSegmentoB(xVertical, yVertical, cor, desenho, fator);
    }

    public static void desenhaSegHorizontal(double fator, Draw desenho, double xInicial, double yInicial, Color cor) {

        double[] xHorizontal = { 0.1 * fator + xInicial, 0.2 * fator + xInicial, 1.0 * fator + xInicial,
                1.1 * fator + xInicial, 1.0 * fator + xInicial, 0.2 * fator + xInicial };

        double[] yHorizontal = { 0.2 * fator + yInicial, 0.3 * fator + yInicial, 0.3 * fator + yInicial,
                0.2 * fator + yInicial, 0.1 * fator + yInicial, 0.1 * fator + yInicial };

        desenhaSegmentoD(xHorizontal, yHorizontal, cor, desenho);

        desenhaSegmentoG(xHorizontal, yHorizontal, cor, desenho, fator);
        desenhaSegmentoA(xHorizontal, yHorizontal, cor, desenho, fator);

    }

    public static void desenhaSegmentoD(double[] xHorizontal, double[] yHorizontal, Color cor, Draw desenho) {
        // desenha seg D
        desenho.setPenColor(cor);
        desenho.filledPolygon(xHorizontal, yHorizontal);
    }

    public static void desenhaSegmentoG(double[] xHorizontal, double[] yHorizontal, Color cor, Draw desenho,
            double fator) {
        // desenha seg G
        for (int i = 0; i < xHorizontal.length; i++) {
            yHorizontal[i] += fator;
        }

        desenho.setPenColor(desenho.BLUE);
        desenho.filledPolygon(xHorizontal, yHorizontal);
    }

    public static void desenhaSegmentoA(double[] xHorizontal, double[] yHorizontal, Color cor, Draw desenho,
            double fator) {
        // desenha seg A
        for (int i = 0; i < xHorizontal.length; i++) {
            yHorizontal[i] += fator;
        }

        desenho.setPenColor(desenho.BLUE);
        desenho.filledPolygon(xHorizontal, yHorizontal);
    }

    private static void desenhaGrade(double fator, Draw desenho, int dimensao) {
        // Desenhando grade quadriculada
        int grade = (int) fator / 10;
        desenho.setPenColor(desenho.DARK_GRAY);
        for (int i = 0; i <= dimensao; i += grade)
            desenho.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j += grade)
            desenho.line(0, j, dimensao, j);
    }
}// fim da classe