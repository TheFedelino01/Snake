package Snake.game.utility;

import Snake.game.vipera.mela;
import Snake.game.vipera.vipera;

import java.awt.*;

/**
 @author  Saccani Federico, federico.saccani01@gmail.com
 @version 1.0
 */
/**
 La classe viene utilizzata per gestire tutto il serpente e le relative mele
 */
public class gameManager {
    /** Attributo che rappresenta la vipera*/
    private vipera viperaManager;
    /** Attributo che rappresenta lo sttao di vita della vipera*/
    private boolean morto;
    /** Attributo che rappresenta la mela in gioco*/
    private mela actualMela;

    /** Attributo che rappresenta il numero di mele raccolte dalla vipera*/
    private int meleRaccolte=0;

    /** Attributo che rappresenta il colore del serpente*/
    private boolean serpenteColorato;

    /**
     @brief Costruttore con parametri della classe

     @param serpenteColorato se il serpente deve colorarsi in base all'ultima mela presa
     */
    public gameManager(boolean serpenteColorato){
        viperaManager = new vipera();
        morto=false;
        actualMela=new mela();
        this.serpenteColorato=serpenteColorato;
    }

    /**
     @brief Metodo che imposta l'attributo morto a seconda del parametro passato

     @param v stato
     */
    public synchronized void setMorto(boolean v){
        morto=v;
    }
    /**
     @brief Ritorna la posizione X della vipera
     */
    public synchronized int getActX(){
        return viperaManager.getX();
    }
    /**
     @brief Ritorna la posizione X della vipera
     */
    public synchronized int getActY(){
        return viperaManager.getY();
    }
    /**
     @brief Ritorna la dimensione della vipera
     */
    public synchronized int getDimensione(){
        return viperaManager.getDimensione();
    }

    /**
     @brief Sposta la vipera a seconda della direzione passata come parametro

     @param direzione direzione della vipera
     */
    public synchronized void sposta(Directions direzione){
        switch(direzione){
            case SOPRA:
                viperaManager.spostaTop();
                break;

            case SOTTO:
                viperaManager.spostaDown();
                break;

            case DESTRA:
                viperaManager.spostaDx();
                break;

            case SINISTRA:
                viperaManager.spostaSx();
                break;

            default:
                break;
        }
    }

    /**
     @brief Ritorna l'attributo morto della classe
     */
    public synchronized boolean isMorto() {
        return morto;
    }

    /**
     @brief Permette di restartare il gioco
     */
    public synchronized void respawn() {
        morto=false;
        viperaManager.respawn();
        commands.getInstance().clearKeyDown();
        meleRaccolte=0;
    }

    /**
     @brief Dice se la vipera sta cercando la mela
     */
    public synchronized boolean isFindingMela(){
        return viperaManager.isFindingMela();
    }

    /**
     @brief Imposta la posizione della mela a seconda dei parametri passati

     @param posMelaX posizione X
     @param posMelaY posizione Y
     */
    public synchronized void setPosMela(int posMelaX, int posMelaY) {
        actualMela.setPosX(posMelaX);
        actualMela.setPosY(posMelaY);
    }

    /**
     @brief Quando richiamato dice che la mela e' stata catturata quindi viene aggiunto un blocco alla vipera
     */
    public synchronized void melaPresa(){
        meleRaccolte++;
        //Creo il blocco e gli faccio assumero il colore della mela presa se vuole che il serpente si colori
        //NO: altrimenti tutti i blocchi del serpente saranno neri

        Color coloreBlocco = actualMela.getColore();
        viperaManager.addBlocco(coloreBlocco);
        actualMela.cambiaColore();
    }

    /**
     @brief Ritorna il numero di mele raccolte dalla vipera
     */
    public synchronized int getNumMelePrese(){
        return meleRaccolte;
    }

    /**
     @brief Imposta la direzione della vipera in base al parametro passato

     @param dir direzione vipera
     */
    public synchronized void setDirezioneVipera(Directions dir){
        viperaManager.setDirezioneVipera(dir);
    }

    /**
     @brief Ritorna la posizione X della mela
     */
    public synchronized int getPosMelaX(){
        return actualMela.getPosX();
    }
    /**
     @brief Ritorna la posizione Y della mela
     */
    public synchronized int getPosMelaY(){
        return actualMela.getPosY();
    }

    /**
     @brief Permette di dire al serpente se deve trovare oppure no la mela

     @param b booleana
     */
    public synchronized void setFindingMela(boolean b) {
        viperaManager.setFindingMela(b);
    }

    /**
     @brief Ritorna la posizione X del blocco identificato da parametro

     @param i identificativo del blocco
     */
    public synchronized int posXblocco(int i){
        return viperaManager.getXblocco(i);
    }
    /**
     @brief Ritorna la posizione Y del blocco identificato da parametro

     @param i identificativo del blocco
     */
    public synchronized int posYblocco(int i){
        return viperaManager.getYblocco(i);
    }

    /**
     @brief Ritorna il colore della mela
     */
    public Color getColoreMela() {
        return actualMela.getColore();
    }

    /**
     @brief Dice se e' presente un blocco nella posizione X e Y dello schermo

     @param x posizione X dello schermo
     @param y posizione Y dello schermo
     */
    public boolean ePresenteUnBlocco(int x, int y){
        return viperaManager.ePresenteUnBlocco(x,y);
    }

    /**
     @brief Restituisce il colore dell'ultimo blocco in coda alla vipera
     */
    public Color getColoreUltimoBlocco(){
        return viperaManager.getColoreUltimoBlocco();
    }
    /**
     @brief Dice se il serpente e' colorato oppure no
     */
    public Boolean getSerpenteColorato(){
        return serpenteColorato;
    }
}
