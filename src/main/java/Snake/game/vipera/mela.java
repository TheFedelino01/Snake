package Snake.game.vipera;

import java.awt.*;
import java.util.Random;
/**
 @author  Saccani Federico, federico.saccani01@gmail.com
 @version 1.0
 */
/**
 La classe rappresenta una mela
 */
public class mela {
    /** Attributo che rappresenta la posizione X della mela*/
    private int posMelaX;
    /** Attributo che rappresenta la posizione Y della mela*/
    private int posMelaY;

    /** Attributo che rappresenta i possibili colori che la mela puo' assumere*/
    private Color colori[]= {Color.red, Color.green, Color.BLUE, Color.cyan, Color.magenta, Color.yellow, Color.pink};
    //private Color colori[]= {Color.red,Color.BLUE};
    /** Attributo che rappresenta il colore attuale della mela*/
    private Color colore;

    /**
     @brief Costruttore senza parametri della classe

     Quando chiamato, richiama il metodo per la scelta del colore in modo Random
     */
    public mela(){
        generateColor();
    }

    /**
     @brief Metodo che imposta la posizione Y della mela in base al parametro passato

     @param posMelaY posizione che dovra' assumere la mela sull'asse Y
     */
    public void setPosY(int posMelaY) {
        this.posMelaY=posMelaY;
    }
    /**
     @brief Metodo che imposta la posizione X della mela in base al parametro passato

     @param posMelaX posizione che dovra' assumere la mela sull'asse X
     */
    public void setPosX(int posMelaX) {
        this.posMelaX=posMelaX;
    }

    /**
     @brief Ritorna la posizione della mela in base all'asse X
     */
    public int getPosX() {
        return posMelaX;
    }
    /**
     @brief Ritorna la posizione della mela in base all'asse Y
     */
    public int getPosY() {
        return posMelaY;
    }

    /**
     @brief Il metodo sceglie in modo random un colore per la mela

     Viene generato un numero casuale a seconda dell'attributo vettore colori, successivamente
     viene impostato l'attributo colore
     */
    public void generateColor(){
        Random rn = new Random();

        int colRnd = rn.nextInt(colori.length);

        colore = colori[colRnd];
    }

    /**
     @brief Ritorna il colore attuale della mela
     */
    public Color getColore(){
        return colore;
    }

    /**
     @brief Genera un colore random 
     */
    public void cambiaColore() {
        generateColor();
    }
}
