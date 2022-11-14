package engtelecom.poo;

import java.awt.Color;

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
        this.displayCro = new Display(coordX, coordY, size, colorOn, colorOff);
    }

    public void incrementa() {
        // TODO implement here
    }

}