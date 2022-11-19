package engtelecom.poo;

import java.awt.Color;
import java.awt.Font;

import edu.princeton.cs.algs4.Draw;

public class Contador {
    private int hour;
    private int min;
    private int sec;
    private int coordX;
    private int coordY;
    private int size;
    private Color colorOn;
    private Color colorOff;
    private Display displayCon;
    private boolean fim;

    /**
     * @param hour
     * @param min
     * @param sec
     * @param coordX
     * @param coordY
     * @param size
     * @param colorOn
     * @param colorOff
     */
    public Contador(int hour, int min, int sec, int coordX, int coordY, int size, Color colorOn, Color colorOff) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
        this.coordX = coordX;
        this.coordY = coordY;
        this.size = size;
        this.colorOn = colorOn;
        this.colorOff = colorOff;
        this.fim = false;
        this.displayCon = new Display(coordX, coordY, size, colorOn, colorOff);
    }

    public void decrementa(Draw desenho) throws InterruptedException {
        if (!decrementaTempo(this.hour, this.min, this.sec)) {
            this.displayCon.desenhaDigitos(this.hour, this.min, this.sec);
            // // Aumentando o tamanho da fonte do texto que será escrito
            // Font font = desenho.getFont().deriveFont(16);
            // desenho.setFont(font);
            // // escrevendo o valor de i na coordenada (500,500)
            // desenho.text(this.coordX, this.coordY, "" + this.sec);
            // // Trocando o buffer para exibir o que foi escrito
        } else {
            this.fim = true;
        }
    }

    private boolean decrementaTempo(int hour, int min, int sec) {
        sec--;
        if (sec < 0) {
            this.sec = 59;
            min--;
            if (min < 0) {
                this.min = 59;
                hour--;
                if (hour < 0) {
                    this.hour = 0;
                    return true;
                } else {
                    this.hour--;
                    return false;
                }
            } else {
                this.min--;
                return false;
            }
        } else {
            this.sec--;
            return false;
        }
    }

    /**
     * @return the fim
     */
    public boolean isFim() {
        return fim;
    }

}