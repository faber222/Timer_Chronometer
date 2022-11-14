package engtelecom.poo;

import java.awt.Color;

public class Display {

    private Digito[] digitos;
    private int posX;
    private int posY;
    private int size;
    private Color colorOn;
    private Color colorOff;
    private int h;
    private int m;
    private int s;

    /**
     * @param posX
     * @param posY
     * @param size
     * @param colorOn
     * @param colorOff
     * @param h
     * @param m
     * @param s
     */
    public Display(int posX, int posY, int size, Color colorOn, Color colorOff, int h, int m, int s) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.colorOn = colorOn;
        this.colorOff = colorOff;
        this.h = h;
        this.m = m;
        this.s = s;
        this.digitos = new Digito[6];
    }

    /**
     * @param posX
     * @param posY
     * @param size
     * @param colorOn
     * @param colorOff
     */
    public Display(int posX, int posY, int size, Color colorOn, Color colorOff) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.colorOn = colorOn;
        this.colorOff = colorOff;
        this.digitos = new Digito[6];
    }

    public void desenhaDigitos() {
        // TODO implement here
    }

}