package engtelecom.poo;

import java.awt.Color;

public class Display {

    private Digito[] digitos;
    private int posX;
    private int posY;
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
    public Display(int posX, int posY, int size, Color colorOn, Color colorOff) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.colorOn = colorOn;
        this.colorOff = colorOff;
        this.digitos = new Digito[6];
    }

    public void desenhaDigitos(int h, int m, int s) {
        for (Digito digito : this.digitos) {
            digito.setPosX(this.posX);
            digito.setPosY(this.posY);
            digito.setSize(this.size);
        }

        separaDezenaUnidade(h);
        this.digitos[0].desenhaDigito(this.colorOn, this.colorOff, this.unidade);
        this.digitos[1].desenhaDigito(this.colorOn, this.colorOff, this.dezena);

        separaDezenaUnidade(m);
        this.digitos[2].desenhaDigito(this.colorOn, this.colorOff, this.unidade);
        this.digitos[3].desenhaDigito(this.colorOn, this.colorOff, this.dezena);

        separaDezenaUnidade(h);
        this.digitos[4].desenhaDigito(this.colorOn, this.colorOff, this.unidade);
        this.digitos[5].desenhaDigito(this.colorOn, this.colorOff, this.dezena);
    }

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