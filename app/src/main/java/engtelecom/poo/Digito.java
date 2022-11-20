package engtelecom.poo;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

/**
 * Classe digito
 */
public class Digito {
    /**
     * Apelido para segmento A = 6
     */
    private static final int A = 6;
    /**
     * Apelido para segmento B = 3
     */
    private static final int B = 3;
    /**
     * Apelido para segmento C = 2
     */
    private static final int C = 2;
    /**
     * Apelido para segmento D = 2
     */
    private static final int D = 4;
    /**
     * Apelido para segmento E = 0
     */
    private static final int E = 0;
    /**
     * Apelido para segmento F = 1
     */
    private static final int F = 1;
    /**
     * Apelido para segmento G = 5
     */
    private static final int G = 5;

    /**
     * Atributo vetoral para segmentos
     */
    private Segmento[] segmentos;
    /**
     * Atributo que representa pos x
     */
    private double posX;
    /**
     * Atributo que representa pos y
     */
    private double posY;
    /**
     * Atributo que representa tamanho
     */
    private int size;

    /**
     * Construtor principal, que recebe como parametro pos x, pos y e tamanho
     * 
     * @param posX Double para representar pos x
     * @param posY Double para representar pos y
     * @param size Integer para representar tamanho
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
     * Método privado usado para verificar se as posições de X e Y passadas são
     * validas
     * 
     * @param x Double para representar pos X
     * @param y Double para representar pos Y
     * @return Retorna true caso X e Y estejam entre (0 --> 800), se não, retorna
     *         false
     */
    private boolean verificaCoord(double x, double y) {
        return (x <= 800 && x >= 0 && y <= 800 && y >= 0);
    }

    /**
     * Método privado usado para verificar se o tamanho é valido
     * 
     * @param size Integer para representar o tamanho
     * @return Retorna true caso o tamanho esteja entre 20 --> 100, se não, retorna
     *         false
     */
    private boolean verificaSize(double size) {
        return size >= 20 && size <= 100;
    }

    /**
     * Método principal da classe digito.
     * Recebe como parametro 2 Color, um para cor ligada e outro para cor desligada.
     * Recebe um inteiro para representar o digito a ser desenhado e um Draw para
     * ser o canvas a ser preenchido.
     *
     * @param colorOn  Color que representa a cor do segmento ligado
     * @param colorOff Color que representa a cor do segmento desligado
     * @param digito   Integer que representa o digito a ser desenhado
     * @param desenho  Draw que representa o canvas que vai ser preenchido
     * @return Retorna true caso o valor de digito esteja entre 0 --> 9, se não,
     *         retorna false
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