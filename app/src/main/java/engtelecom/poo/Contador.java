package engtelecom.poo;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

public class Contador {
    private int hour;
    private int min;
    private int sec;
    private double coordX;
    private double coordY;
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
    public Contador(int hour, int min, int sec, double coordX, double coordY, int size, Color colorOn, Color colorOff) {
        if (verificaTempo(hour, min, sec)) {
            this.hour = hour;
            this.min = min;
            this.sec = sec;
        } else {
            this.hour = 12;
            this.min = 0;
            this.sec = 0;
        }

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
        this.displayCon = new Display(this.coordX, this.coordY, this.size, this.colorOn, this.colorOff);
    }

    /**
     * 
     * @param desenho
     * @return
     * @throws InterruptedException
     */
    public boolean decrementa(Draw desenho) throws InterruptedException {
        if (!isFim()) {
            if (!decrementaTempo(this.hour, this.min, this.sec)) {
                return this.displayCon.desenhaDigitos(this.hour, this.min, this.sec, desenho);
            } else {
                this.fim = true;
            }
        }
        return desenhaZero(desenho);

    }

    /**
     * 
     * @param desenho
     * @return
     */
    private boolean desenhaZero(Draw desenho) {
        this.hour = 0;
        this.min = 0;
        this.sec = 0;
        return this.displayCon.desenhaDigitos(this.hour, this.min, this.sec, desenho);
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
     * @param hour
     * @param min
     * @param sec
     * @return
     */
    private boolean verificaTempo(int hour, int min, int sec) {
        return (hour <= 99 && hour >= 0 && min <= 59 && min >= 0 && sec <= 59 && sec >= 0);
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