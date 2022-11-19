package engtelecom.poo;

import java.awt.Color;
import java.awt.Font;

import edu.princeton.cs.algs4.Draw;

public class Cronometro {

    private int hour;
    private int min;
    private int sec;
    private int coordX;
    private int coordY;
    private int size;
    private Color colorOn;
    private Color colorOff;
    private Display displayCro;
    private boolean fim;

    /**
     * @param coordX
     * @param coordY
     * @param size
     * @param colorOn
     * @param colorOff
     */
    public Cronometro(int coordX, int coordY, int size, Color colorOn, Color colorOff) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.size = size;
        this.colorOn = colorOn;
        this.colorOff = colorOff;
        this.fim = false;
        this.displayCro = new Display(coordX, coordY, size, colorOn, colorOff);
    }

    public void incrementa(Draw desenho) throws InterruptedException {
        if (!incrementaTempo(hour, min, sec)) {
            // Aumentando o tamanho da fonte do texto que será escrito
            this.displayCro.desenhaDigitos(this.hour, this.min, this.sec);

            // Font font = desenho.getFont().deriveFont(16);
            // desenho.setFont(font);
            // // escrevendo o valor de i na coordenada (500,500)
            // desenho.text(this.coordX, this.coordY, "" + this.sec);
        } else {
            this.fim = true;
        }
    }

    private boolean incrementaTempo(int hour, int min, int sec) {
        sec++;
        if (sec > 59) {
            this.sec = 0;
            min++;
            if (min > 59) {
                this.min = 00;
                hour++;
                if (hour > 99) {
                    this.hour = 99;
                    return true;
                } else {
                    this.hour++;
                    return false;
                }
            } else {
                this.min++;
                return false;
            }
        } else {
            this.sec++;
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