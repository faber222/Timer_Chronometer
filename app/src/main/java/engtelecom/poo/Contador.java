package engtelecom.poo;

import java.awt.Color;

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
        this.displayCon = new Display(coordX, coordY, size, colorOn, colorOff, hour, min, size);
    }

    public void Decrementa() {
        // TODO implement here
    }

}