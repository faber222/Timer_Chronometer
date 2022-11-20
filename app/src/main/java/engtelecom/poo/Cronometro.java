package engtelecom.poo;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Cronometro {

    private int hour;
    private int min;
    private int sec;
    private double coordX;
    private double coordY;
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
    public Cronometro(double coordX, double coordY, int size, Color colorOn, Color colorOff) {
        if (verificaCoord(coordX, coordY)) {
            this.coordX = coordX;
            this.coordY = coordY;
        } else {
            this.coordX = 0;
            this.coordY = 400;
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
        this.fim = false;
        this.displayCro = new Display(this.coordX, this.coordY, this.size, this.colorOn, this.colorOff);
    }

    /**
     * 
     * @param desenho
     * @return
     * @throws InterruptedException
     */
    public boolean incrementa(Draw desenho) throws InterruptedException {
        if (!isFim()) {
            if (!incrementaTempo(hour, min, sec)) {
                return this.displayCro.desenhaDigitos(this.hour, this.min, this.sec, desenho);
            } else {
                this.fim = true;
            }
        }
        return desenhaCheio(desenho);
    }

    /**
     * 
     * @param desenho
     * @return
     */
    private boolean desenhaCheio(Draw desenho) {
        this.hour = 99;
        this.min = 59;
        this.sec = 59;
        return this.displayCro.desenhaDigitos(this.hour, this.min, this.sec, desenho);
    }

    /**
     * 
     * @param coordX
     * @param coordY
     * @return
     */
    private boolean verificaCoord(double coordX, double coordY) {
        return (coordX <= 800 && coordX >= 0 && coordY <= 800 && coordY >= 0);
    }

    /**
     * 
     * @param size
     * @return
     */
    private boolean verificaSize(int size) {
        return (size <= 100 && size >= 20);
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
     * @param hour
     * @param min
     * @param sec
     * @return
     */
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