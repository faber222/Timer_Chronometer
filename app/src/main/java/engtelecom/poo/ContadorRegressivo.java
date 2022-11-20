package engtelecom.poo;

import java.awt.Color;

import edu.princeton.cs.algs4.Draw;

/**
 * Classe contador Regressivo
 */
public class ContadorRegressivo {
    /**
     * Integer para armazenar as horas
     */
    private int hour;
    /**
     * Integer para armazenar os minutos
     */
    private int min;
    /**
     * Integer para armazenar os segundos
     */
    private int sec;
    /**
     * Double para armazenar a posição X
     */
    private double coordX;
    /**
     * Double para armazenar a posição Y
     */
    private double coordY;
    /**
     * Integer para armazenar o tamanho
     */
    private int size;
    /**
     * Color para armazenar a representação de corLigada
     */
    private Color colorOn;
    /**
     * Color para armazenar a representação de corDesligada
     */
    private Color colorOff;
    /**
     * Atributo do tipo Display para Instanciar um objeto dessa classe
     */
    private Display displayCon;
    /**
     * Boolean usado para definir fim do programa
     */
    private boolean fim;

    /**
     * Construtor da Classe ContadorRefressivo, recebe 3 inteiros, para representar
     * hora, minuto e segundo, 2 double, para representar pos x e y, 1 inteiro para
     * representar o tamanho e 2 Color para representar as cores ligada e desligada
     * 
     * @param hour     Integer que representa as horas
     * @param min      Integer que representa os minutos
     * @param sec      Integer que representa os segundos
     * @param coordX   Double que representa a posição X
     * @param coordY   Double que representa a posição Y
     * @param size     Integer que representa o tamanho
     * @param colorOn  Color que representa a cor do segmento Ligado
     * @param colorOff Color que representa a cor do segmento Desligado
     */
    public ContadorRegressivo(int hour, int min, int sec, double coordX, double coordY, int size, Color colorOn,
            Color colorOff) {
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
     * Método principal da classe ContadorRegressivo.
     * Tal método tem o objetivo de decrementar os valores de hora, minuto e
     * segundo, até que chegue a zero em todos os 3 atributos
     * 
     * @param desenho Draw que representa o canvas para desenho
     * @return retorna true caso seja possivel decrementar todos os valores ou
     *         apresentar na tela todos os atributos zerados, caso possua algum
     *         problema no decremento ou na demonstração dos atributos zerados,
     *         retorna false
     * @throws InterruptedException Não verifica erro
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
     * Método privado que desenha todos os digitos zerados, usado na finalização do
     * contador
     * 
     * @param desenho Draw que representa o canvas para desenho
     * @return retorna true caso seja possivel retornar os valores zerados, caso
     *         algo de errado, retorna false
     */
    private boolean desenhaZero(Draw desenho) {
        this.hour = 0;
        this.min = 0;
        this.sec = 0;
        return this.displayCon.desenhaDigitos(this.hour, this.min, this.sec, desenho);
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
     * Método privado usado para verificar se os valores de hora, min e segundo são
     * validos
     * 
     * @param hour Integer ṕara representar horas
     * @param min  Integer para representar minutos
     * @param sec  Integer para representar segundos
     * @return Retorna true caso hora esteja entre (0-->99), minuto esteja entre
     *         (0-->59) e segundo esteja entre (0-->59), se não, retorna false
     */
    private boolean verificaTempo(int hour, int min, int sec) {
        return (hour <= 99 && hour >= 0 && min <= 59 && min >= 0 && sec <= 59 && sec >= 0);
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
     * Método privado usado para decrementar em ordem, respectivamente, segundos,
     * minutos e horas
     * 
     * @param hour Integer para representar horas
     * @param min  Integer para representar minutos
     * @param sec  Integer para representar segundos
     * @return Retorna true caso não tenha mais valores a decrementar, caso
     *         contrario retorna false
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
     * @return se FIM é true ou false
     */
    public boolean isFim() {
        return fim;
    }

}