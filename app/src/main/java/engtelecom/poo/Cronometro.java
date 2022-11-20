package engtelecom.poo;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

/**
 * Classe cronometro
 */
public class Cronometro {
    /**
     * Variavel que define o valor maximo de hora
     */
    private static final int MAX_HOUR = 99;
    /**
     * Variavel que define o valor maximo de minuto
     */
    private static final int MAX_MIN = 59;
    /**
     * Variavel que define o valor maximo de segundo
     */
    private static final int MAX_SEC = 59;

    /**
     * Integer que representa as horas
     */
    private int hour;
    /**
     * Integer que representa os minutos
     */
    private int min;
    /**
     * Integer que representa os segundos
     */
    private int sec;
    /**
     * Double que representa pos X
     */
    private double coordX;
    /**
     * Double que representa pos Y
     */
    private double coordY;
    /**
     * Integer que representa tamanho
     */
    private int size;
    /**
     * Color que representa a cor do segmento ligado
     */
    private Color colorOn;
    /**
     * Color que representa a cor do segmento desligado
     */
    private Color colorOff;
    /**
     * Atributo do tipo Display para Instanciar um objeto dessa classe
     */
    private Display displayCro;
    /**
     * Boolean usado para definir fim do programa
     */
    private boolean fim;

    /**
     * Construtor da classe Cronometro, que recebe como parametro 2 doubles, para
     * representar pos x e y, 1 int para representar o tamanho e 2 color, para
     * representar o segmento ligado e desligado
     * 
     * @param coordX   Double para representar pos x
     * @param coordY   Double para representar pos y
     * @param size     Integer para representar o tamanho
     * @param colorOn  Color que representa a cor do digito ligado
     * @param colorOff Color que representa a cor do digito desligado
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
     * Método principal da classe Cronometro.
     * Recebe como parametro um desenho do tipo Draw
     * 
     * @param desenho Draw para representar canvas para desenho
     * @return retorna true caso seja possivel incrementar todos os valores ou
     *         apresentar na tela todos os atributos no maximo, caso possua algum
     *         problema no incremento ou na demonstração dos atributos maximos,
     *         retorna false
     * @throws InterruptedException Não verifica erros
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
     * Método privado que desenha todos os digitos maximizados, 99:59:59
     * 
     * @param desenho Draw que representa o canvas para desenho
     * @return retorna true caso seja possivel retornar os valores maximos, caso
     *         algo de errado, retorna false
     */
    private boolean desenhaCheio(Draw desenho) {
        this.hour = MAX_HOUR;
        this.min = MAX_MIN;
        this.sec = MAX_SEC;
        return this.displayCro.desenhaDigitos(this.hour, this.min, this.sec, desenho);
    }

    /**
     * Método privado usado para verificar se as posições de X e Y passadas são
     * validas
     * 
     * @param coordX Double para representar pos X
     * @param coordY Double para representar pos Y
     * @return Retorna true caso X e Y estejam entre (0 --> 800), se não, retorna
     *         false
     */
    private boolean verificaCoord(double coordX, double coordY) {
        return (coordX <= 800 && coordX >= 0 && coordY <= 800 && coordY >= 0);
    }

    /**
     * Método privado usado para verificar se o tamanho é valido
     * 
     * @param size Integer para representar o tamanho
     * @return Retorna true caso o tamanho esteja entre 20 --> 100, se não, retorna
     *         false
     */
    private boolean verificaSize(int size) {
        return (size <= 100 && size >= 20);
    }

    /**
     * Método privado que verifica se Color não é nulo
     * 
     * @param cor Color que representa a cor a ser usada
     * @return Retorna true caso não seja nulo, se não, retorna false
     */
    private boolean verificaCor(Color cor) {
        return (cor != null);
    }

    /**
     * Método privado usado para incrementar em ordem, respectivamente, segundos,
     * minutos e horas
     * 
     * @param hour Integer para representar horas
     * @param min  Integer para representar minutos
     * @param sec  Integer para representar segundos
     * @return Retorna true caso não tenha mais valores a incrementar, caso
     *         contrario retorna false
     */
    private boolean incrementaTempo(int hour, int min, int sec) {
        sec++;
        if (sec > MAX_SEC) {
            this.sec = 0;
            min++;
            if (min > MAX_MIN) {
                this.min = 00;
                hour++;
                if (hour > MAX_HOUR) {
                    this.hour = MAX_HOUR;
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