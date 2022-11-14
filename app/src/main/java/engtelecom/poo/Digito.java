package engtelecom.poo;

import java.awt.Color;

public class Digito {

    private Segmento segmentos;
    private int posX;
    private int posY;
    private int size;
    private Color colorOn;
    private Color colorOff;
    private int digito;

    /**
     * @param posX
     * @param posY
     * @param size
     * @param colorOn
     * @param colorOff
     */
    public Digito(int posX, int posY, int size, Color colorOn, Color colorOff) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.colorOn = colorOn;
        this.colorOff = colorOff;
    }

    public void desenhaDigito(int x, int y, int size, Color colorOn, Color colorOff) {
        // TODO implement here
    }

}