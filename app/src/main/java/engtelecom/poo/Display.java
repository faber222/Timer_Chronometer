package engtelecom.poo;

import java.awt.Color;
import java.util.ArrayList;

import edu.princeton.cs.algs4.Draw;

/**
 * Classe Display
 */
public class Display {
    /**
     * variavel que desloca quadrado no eixo x
     */
    private static final double X_SQUARE = 1.30;
    /**
     * variavel que desloca quadrado alto no eixo y
     */
    private static final double Y_SQUARE_UP = 1.7;
    /**
     * variavel que desloca quadrado baixo no eixo y
     */
    private static final double Y_SQUARE_DOWN = 0.65;
    /**
     * variavel que define o tamanho do quadrado
     */
    private static final double SQUARE_SIZE = 0.8;

    /**
     * arrayList de digitos, que armazena todas as chamadas de digitos
     */
    private ArrayList<Digito> digitos;
    /**
     * double para armazenar posX
     */
    private double posX;
    /**
     * double para armazenar posY
     */
    private double posY;
    /**
     * int para armazenar tamanho
     */
    private int size;
    /**
     * representa a cor do segmento ligado
     */
    private Color colorOn;
    /**
     * representa a cor do segmento desliga
     */
    private Color colorOff;
    /**
     * armazena a dezena de um numero de dois digitos
     */
    private int dezena;
    /**
     * armazena a unidade de um numero de dois digitos
     */
    private int unidade;

    /**
     * Classe display, instancia 6 digitos, onde é necessário passar a posição no
     * eixo X e Y, cor do segmento ligado e desligado e o tamanho que deverá ter
     * esses digitos
     * 
     * @param posX     Double que representa posição Eixo X
     * @param posY     Double que representa posição Eixo Y
     * @param size     Integer que reseprenta o tamanho
     * @param colorOn  Color que representa a cor do digito ligado
     * @param colorOff Color que representa a cor do digito desligado
     */
    public Display(double posX, double posY, int size, Color colorOn, Color colorOff) {
        if (verificaCoord(posX, posY)) {
            this.posX = posX;
            this.posY = posY;
        } else {
            this.posX = 0;
            this.posY = 400;
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

        this.digitos = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            Digito dig = new Digito(this.posX, this.posY, this.size);
            this.digitos.add(dig);
            this.posX += this.size * 1.1;
            if (i == 1 || i == 3) {
                this.posX += this.size * 0.5;

            }
        }
    }

    /**
     * Metodo da classe Display, que vai desenhar todos os 6 Digitos no quadro Canva
     * Sendo necessário passar como parametro, numero que representa hora, minuto e
     * segundo, e um quadro de desenho do tipo Draw
     * 
     * @param h       Integer para representar o digito das Horas
     * @param m       Integer para representar o digito dos Minutos
     * @param s       Integer para representar o digito dos Segundos
     * @param desenho Draw para representar o quadro de desenho Canva
     * @return True caso hora, min e segundos sejam validos, se não retorna
     *         false
     */
    public boolean desenhaDigitos(int h, int m, int s, Draw desenho) {
        if (verificaTempo(h, m, s)) {
            separaDezenaUnidade(h);
            this.digitos.get(0).desenhaDigito(this.colorOn, this.colorOff, this.dezena, desenho);
            this.digitos.get(1).desenhaDigito(this.colorOn, this.colorOff, this.unidade, desenho);

            desenhaQuadrado(this.digitos.get(1).getPosX() + (this.size * X_SQUARE),
                    this.posY + (this.size * Y_SQUARE_UP), this.size * SQUARE_SIZE, desenho);
            desenhaQuadrado(this.digitos.get(1).getPosX() + (this.size * X_SQUARE),
                    this.posY + (this.size * Y_SQUARE_DOWN), this.size * SQUARE_SIZE, desenho);

            separaDezenaUnidade(m);
            this.digitos.get(2).desenhaDigito(this.colorOn, this.colorOff, this.dezena, desenho);
            this.digitos.get(3).desenhaDigito(this.colorOn, this.colorOff, this.unidade, desenho);

            desenhaQuadrado(this.digitos.get(3).getPosX() + (this.size * X_SQUARE),
                    this.posY + (this.size * Y_SQUARE_UP), this.size * SQUARE_SIZE, desenho);
            desenhaQuadrado(this.digitos.get(3).getPosX() + (this.size * X_SQUARE),
                    this.posY + (this.size * Y_SQUARE_DOWN), this.size * SQUARE_SIZE, desenho);

            separaDezenaUnidade(s);
            this.digitos.get(4).desenhaDigito(this.colorOn, this.colorOff, this.dezena, desenho);
            this.digitos.get(5).desenhaDigito(this.colorOn, this.colorOff, this.unidade, desenho);
            return true;
        }
        return false;
    }

    /**
     * Método privado da classe Display, que vai desenhar os quadrados entre cada
     * conjunto de 2 digitos, recebe 3 doubles e 1 Draw
     * 
     * @param posX    Double para representar a posição do quadrado no Eixo X
     * @param posY    Double para representar a posição do quadrado no Eixo Y
     * @param size    Double para representar o tamanho do quadrado
     * @param desenho Draw para reprenseta o quadro de desenho Canva
     * @return True caso o desenho de quadrado tenha sido feito com sucesso, casos
     *         contrario retorna false
     */
    private boolean desenhaQuadrado(double posX, double posY, double size, Draw desenho) {
        if (verificaCoord(posX, posY) && verificaSize(size)) {
            desenho.setPenColor(this.colorOn);
            desenho.filledSquare(posX, posY, size / 4);
            return true;
        }
        return false;
    }

    /**
     * Metodo privado de verificação dos valores de tempo passados
     * 
     * @param h Integer para representar as horas, max = 99, min = 0
     * @param m Integer para representar os minutos, max = 59, min = 0
     * @param s Integer para representar os segundos, max = 59, min = 0
     * @return Retorna true caso os tempos passados sejam validos, caso contrario
     *         retorna false
     */
    private boolean verificaTempo(int h, int m, int s) {
        return (h <= 99 && h >= 0 && m <= 59 && m >= 0 && s <= 59 && s >= 0);
    }

    /**
     * Metodo privado de verificação dos valores de coordenadas
     * 
     * @param x Double para representar a coordenada X, max = 800, min = 0
     * @param y Double para reprensetar a coordenada Y, max = 800, min = 0
     * @return Retorna true caso os valores de coordenada estejam validos, caso
     *         contrario retorna false
     */
    private boolean verificaCoord(double x, double y) {
        return (x <= 800 && x >= 0 && y <= 800 && y >= 0);
    }

    /**
     * Metodo privado de verificação do tamanho
     * 
     * @param size Double para representar o tamanho, max = 100, min = 20
     * @return Retorna true caso o valor de tamanho esteja dentro max e min, caso
     *         contrario, retorna false
     */
    private boolean verificaSize(double size) {
        return size >= 20 && size <= 100;
    }

    /**
     * Metodo privado de verificação do objeto Color
     * 
     * @param cor Color para representar as cores, deve ser != null
     * @return Retorna true caso cor passada seja valida, caso contrario retorna
     *         false
     */
    private boolean verificaCor(Color cor) {
        return (cor != null);
    }

    /**
     * usado no javatest de digito
     * 
     * @return the digitos
     */
    public ArrayList<Digito> getDigitos() {
        return digitos;
    }

    /**
     * Método privado utilizado para separar as dezenas das unidades de um numero
     * inteiro
     * 
     * @param valor Integer que representa o numero de dois digitos ou um
     * @return Retorna true caso tenha conseguido separa os numeros corretamente,
     *         caso seja passado numero de mais de dois digitos, retorna false
     */
    private boolean separaDezenaUnidade(int valor) {
        if (valor >= 0 && valor < 100) {
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
            this.dezena = valor / 10;
            this.unidade = valor % 10;
            return true;
        }
        return false;
    }
}