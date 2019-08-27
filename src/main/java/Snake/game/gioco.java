package Snake.game;

import Snake.game.utility.Directions;
import Snake.game.utility.gameManager;
import Snake.game.utility.syncTh;
import Snake.gui.ManagerGUI;
import processing.core.PApplet;

import java.awt.*;

/**
 @author  Saccani Federico, federico.saccani01@gmail.com
 @version 1.0
 */
/**
 Classe che funge da dati condivisi, e' la classe principale l'unica utilizzata per interagire con le altre varie classi
 */
public class gioco {
   // private syncTh syncTh;
    /** Attributo che permette di gestire il gioco*/
    private gameManager gameManager;
    /** Attributo che permette di gestire la grafica*/
    private ManagerGUI managerGui;

    /**
     @brief Instance privata per singleton
     */
    private static gioco ourInstance = new gioco();
    /**
     @brief Instance pubblica per singleton
     */
    public static gioco getInstance() {
        return ourInstance;
    }

    /**
     @brief Costruttore vuoto della classe
     */
    private gioco(){

    }

    /**
     @brief Metodo che permette di impostare alcuni parametri per il gioco

     @param dimensioneX valore dimensione schermo X
     @param dimensioneY valore dimensione schermo Y
     @param tavola oggetto per disegnare
     @param colorato attributo riferito al colore del serpente
     */
    public void setup(int dimensioneX, int dimensioneY, PApplet tavola, boolean colorato){
        //syncTh = new syncTh();
        gameManager = new gameManager(colorato);
        managerGui = new ManagerGUI(dimensioneX,dimensioneY,tavola);
    }


    /**
     @brief Il metodo permette di restituire la dimensione X dello schermo
     */
    public int getDimensioneX(){
        return managerGui.getDimensioneX();
    }
    /**
     @brief Il metodo permette di restituire la dimensione Y dello schermo
     */
    public int getDimensioneY(){
        return managerGui.getDimensioneY();
    }

    /**
     @brief Il metodo disegna tutta la schermata GUI su schermo
     */
    public void draw(){
        managerGui.draw();
    }

    /**
     @brief Il metodo dice se il serpente e' morto oppure no
     */
    public boolean isMorto(){
        return gameManager.isMorto();
    }
    /**
     @brief Il metodo restituisce la dimensione X della mela
     */
    public int getPosMelaX(){
        return gameManager.getPosMelaX();
    }
    /**
     @brief Il metodo restituisce la dimensione Y della mela
     */
    public int getPosMelaY(){
        return gameManager.getPosMelaY();
    }

    /**
     @brief Il metodo restituisce la dimensione del serpente cioe' da quanti blocchi e' composto
     */
    public int getDimensione(){
        return gameManager.getDimensione();
    }
    /**
     @brief Il metodo restituisce il colore della mela attualmente generata
     */
    public Color getColoreMela(){
        return gameManager.getColoreMela();
    }

    /**
     @brief Il metodo fa respawnare il serpente
     */
    public void respawn(){
        gameManager.respawn();
    }

    /**
     @brief Il metodo restituisce il numero di mele prese
     */
    public int getNumMelePrese(){
        return gameManager.getNumMelePrese();
    }

    /**
     @brief Il metodo restituisce la posizione X del blocco in base al parametro

     @param i identificativo del blocco di cui si vuole ottenere informazioni
     */
    public int posXblocco(int i){
        return gameManager.posXblocco(i);
    }
    /**
     @brief Il metodo restituisce la posizione Y del blocco in base al parametro

     @param i identificativo del blocco di cui si vuole ottenere informazioni
     */
    public int posYblocco(int i){
        return gameManager.posYblocco(i);
    }

    /**
     @brief Il metodo dice se il serpente e' colorato oppure no
     */
    public boolean getSerpenteColorato(){
        return gameManager.getSerpenteColorato();
    }

    /**
     @brief Il metodo restituisce il numero di mele prese
     */
    public Color getColoreUltimoBlocco(){
        return gameManager.getColoreUltimoBlocco();
    }
    /**
     @brief Il metodo imposta lo stato di vita del serpente in base al parametro passato

     @param val true significa vivo, false significa morto
     */
    public void setMorto(boolean val){
        gameManager.setMorto(val);
    }
    /**
     @brief Il metodo imposta la direzione del serpente in base al parametro passato

     @param c la direzione del serpente
     */
    public void setDirezioneVipera(Directions c){
        gameManager.setDirezioneVipera(c);
    }
    /**
     @brief Il metodo sposta il serpente in base alla direzione passata come parametro

     @param c la direzione del serpente
     */
    public void sposta(Directions c){
        gameManager.sposta(c);
    }

    /**
     @brief Il metodo restituisce true se nella posizione X e Y, passata come parametro, e' presente un blocco

     @param x posizione X
     @param y posizione Y
     */
    public boolean ePresenteUnBlocco(int x, int y){
        return gameManager.ePresenteUnBlocco(x,y);
    }

    /**
     @brief Il metodo imposta la posizione della mela a seconda dei parametri passati

     @param x posizione X della mela
     @param y posizione Y della mela
     */
    public void setPosMela(int x,int y){
        gameManager.setPosMela(x,y);
    }
    /**
     @brief Il metodo dice se il serpente sta cercando la mela
     */
    public boolean isFindingMela() {
        return gameManager.isFindingMela();
    }
    /**
     @brief Il metodo a seconda del parametro passato, dice al serpente se deve oppure no cercare la mela

     @param v true sta cercando la mela, false non deve cercare la mela
     */
    public void setFindingMela(boolean v){
        gameManager.setFindingMela(v);
    }

    /**
     @brief Il metodo dice al serpente che la mela e' stata presa
     */
    public void melaPresa(){
        gameManager.melaPresa();
    }

    /**
     @brief Il metodo restituisce la posizione X della testa del serpente
     */
    public int getActX(){
        return gameManager.getActX();
    }

    /**
     @brief Il metodo restituisce la posizione Y della testa del serpente
     */
    public int getActY(){
        return gameManager.getActY();
    }
}
