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
    public Digito() {
        this.segmentos = new Segmento();
    }

    /**
     * @param posX the posX to set
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * @param posY the posY to set
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    public boolean desenhaDigito(Color colorOn, Color colorOff, int digito) {
        if (digito >= 0 && digito <= 9) {
            this.segmentos.setPosX(this.posX);
            this.segmentos.setPosY(this.posY);
            this.segmentos.setSize(this.size);

            this.segmentos.desenhaSegmentoA(colorOn);
            this.segmentos.desenhaSegmentoB(colorOn);
            this.segmentos.desenhaSegmentoC(colorOn);
            this.segmentos.desenhaSegmentoD(colorOn);
            this.segmentos.desenhaSegmentoE(colorOn);
            this.segmentos.desenhaSegmentoF(colorOn);
            this.segmentos.desenhaSegmentoG(colorOn);

            switch (digito) {
                case 0:
                    this.segmentos.desenhaSegmentoG(colorOff);
                    break;
                case 1:
                    this.segmentos.desenhaSegmentoA(colorOff);
                    this.segmentos.desenhaSegmentoD(colorOff);
                    this.segmentos.desenhaSegmentoE(colorOff);
                    this.segmentos.desenhaSegmentoF(colorOff);
                    this.segmentos.desenhaSegmentoG(colorOff);
                    break;
                case 2:
                    this.segmentos.desenhaSegmentoC(colorOff);
                    this.segmentos.desenhaSegmentoF(colorOff);
                    break;
                case 3:
                    this.segmentos.desenhaSegmentoE(colorOff);
                    this.segmentos.desenhaSegmentoF(colorOff);
                    break;
                case 4:
                    this.segmentos.desenhaSegmentoA(colorOff);
                    this.segmentos.desenhaSegmentoD(colorOff);
                    this.segmentos.desenhaSegmentoE(colorOff);
                    break;
                case 5:
                    this.segmentos.desenhaSegmentoB(colorOff);
                    this.segmentos.desenhaSegmentoE(colorOff);
                    break;
                case 6:
                    this.segmentos.desenhaSegmentoB(colorOff);
                    break;
                case 7:
                    this.segmentos.desenhaSegmentoD(colorOff);
                    this.segmentos.desenhaSegmentoE(colorOff);
                    this.segmentos.desenhaSegmentoF(colorOff);
                    this.segmentos.desenhaSegmentoG(colorOff);
                    break;
                case 9:
                    this.segmentos.desenhaSegmentoE(colorOff);
                    break;
                default:
                    break;
            }
            return true;
        }
        return false;

    }

}