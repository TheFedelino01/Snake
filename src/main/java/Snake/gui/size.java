package Snake.gui;
/**
 @author  Saccani Federico, federico.saccani01@gmail.com
 @version 1.0
 */

/**
 Classe che gestisce le dimensioni della finestra di gioco
 */
public class size {

    /** Dimensione relativa asse X*/
    private int dimensioneX;
    /** Dimensione relativa asse Y*/
    private int dimensioneY;

    /**
     @brief Costruttore con parametri della classe

     Imposta gli attributi della classe a seconda dei parametri passati
     @param x valore dimensione schermo X
     @param y valore dimensione schermo Y
     */
    public size(int x, int y){
        dimensioneX = x;
        dimensioneY = y;
    }
    /**
     @brief Costruttore vuoto della classe

     Imposta gli attributi della classe a valori standard
     */
    public size(){
        dimensioneX=500;
        dimensioneY=500;
    }

    /**
     @brief Restituisce valore dell'attributo dimensioneX

     @return dimensioneX attributo
     */
    public int getDimensioneX(){
        return dimensioneX;
    }

    /**
     @brief Restituisce valore dell'attributo dimensioneY

     @return dimensioneY attributo
     */
    public int getDimensioneY(){
        return dimensioneY;
    }
}
