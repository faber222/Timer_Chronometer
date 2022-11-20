package engtelecom.poo;

import java.awt.Color;
import java.util.ArrayList;

import edu.princeton.cs.algs4.Draw;

public class Display {
    private ArrayList<Digito> digitos;
    private double posX;
    private double posY;
    private int size;
    private Color colorOn;
    private Color colorOff;
    private int dezena;
    private int unidade;

    /**
     * @param posX
     * @param posY
     * @param size
     * @param colorOn
     * @param colorOff
     */
    public Display(double posX, double posY, int size, Color colorOn, Color colorOff) {
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

        if (verificaCor(colorOn) && verificaCor(colorOff)) {
            this.colorOn = colorOn;
            this.colorOff = colorOff;
        } else {
            this.colorOn = Color.BLACK;
            this.colorOff = Color.GRAY;
        }

        this.digitos = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            Digito dig = new Digito(this.posX, this.posY, this.size);
            this.digitos.add(dig);
            this.posX += this.size * 1.3;
            if (i == 1 || i == 3) {
                this.posX += this.size * 0.9;

            }
        }
    }

    /**
     * 
     * @param h
     * @param m
     * @param s
     * @param desenho
     * @return
     */
    public boolean desenhaDigitos(int h, int m, int s, Draw desenho) {
        if (verificaTempo(h, m, s)) {
            separaDezenaUnidade(h);
            this.digitos.get(0).desenhaDigito(this.colorOn, this.colorOff, this.dezena, desenho);
            this.digitos.get(1).desenhaDigito(this.colorOn, this.colorOff, this.unidade, desenho);

            desenhaQuadrado(this.digitos.get(1).getPosX() + (this.size * 1.7), this.posY + (this.size * 1.7), this.size,
                    desenho);
            desenhaQuadrado(this.digitos.get(1).getPosX() + (this.size * 1.7), this.posY + (this.size * 0.65),
                    this.size,
                    desenho);

            separaDezenaUnidade(m);
            this.digitos.get(2).desenhaDigito(this.colorOn, this.colorOff, this.dezena, desenho);
            this.digitos.get(3).desenhaDigito(this.colorOn, this.colorOff, this.unidade, desenho);

            desenhaQuadrado(this.digitos.get(3).getPosX() + (this.size * 1.7), this.posY + (this.size * 1.7), this.size,
                    desenho);
            desenhaQuadrado(this.digitos.get(3).getPosX() + (this.size * 1.7), this.posY + (this.size * 0.65),
                    this.size,
                    desenho);

            separaDezenaUnidade(s);
            this.digitos.get(4).desenhaDigito(this.colorOn, this.colorOff, this.dezena, desenho);
            this.digitos.get(5).desenhaDigito(this.colorOn, this.colorOff, this.unidade, desenho);
            return true;
        }
        return false;
    }

    /**
     * 
     * @param posX
     * @param posY
     * @param size
     * @param desenho
     * @return
     */
    private boolean desenhaQuadrado(double posX, double posY, double size, Draw desenho) {
        if (verificaCoord(posX, posY) && verificaSize(size)) {
            desenho.filledSquare(posX, posY, size / 4);
            return true;
        }
        return false;
    }

    /**
     * 
     * @param h
     * @param m
     * @param s
     * @return
     */
    private boolean verificaTempo(int h, int m, int s) {
        return (h <= 99 && h >= 0 && m <= 59 && m >= 0 && s <= 59 && s >= 0);
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
     * 
     * @param cor
     * @return
     */
    private boolean verificaCor(Color cor) {
        return (cor != null);
    }

    /**
     * 
     * @param valor
     * @return
     */
    private boolean separaDezenaUnidade(int valor) {
        if (valor < 10 && valor > 0) {
            this.dezena = 0;
            this.unidade = valor;
            return true;
        }
        if (valor == 0) {
            this.dezena = 0;
            this.unidade = 0;
            return true;
        }
        if (valor > 9) {
            this.dezena = valor / 10;
            this.unidade = valor % 10;
            return true;
        }
        return false;
    }
}