package Snake.game.vipera;

import Snake.game.utility.Directions;
import Snake.game.gioco;
import java.awt.*;

/**
 @author  Saccani Federico, federico.saccani01@gmail.com
 @version 1.0
 */
/**
 La classe rappresenta la vipera
 */
public class vipera {
    /** Attributo che rappresenta la posizione X della vipera*/
    private int actPosX;
    /** Attributo che rappresenta la posizione Y della vipera*/
    private int actPosY;
    /** Attributo che rappresenta la grandezza del singolo blocco che compone la vipera*/
    private int dimensione;

    /** Attributo che dice se la vipera sta cercando la mela*/
    private boolean findingMela;

    /** Attributo che rappresenta i blocchi che compongono il corpo della vipera*/
    private blocchi blocchi;

    /**
     @brief Costruttore senza parametri della classe

     Quando chiamato, richiama il metodo per impostare gli attributi della classe a valori di default
     */
    public vipera() {
        reset();
    }

    /**
     @brief Quando chiamato imposta gli attributi della classe a valori di default
     */
    private void reset(){
        actPosX=50;
        actPosY=50;
        dimensione=50;
        findingMela=false;
        blocchi = new blocchi(actPosX,actPosY);//Creo una nuova lista
    }

    /**
     @brief Sposta la vipera sull'asse X in base alla quantita passata come parametro

     @param quant direzione verticale di spostamento
     */
    public void incX(int quant){
        int tmp = actPosX+quant;

        if(tmp>=0 && tmp<gioco.getInstance().getDimensioneX()){
            actPosX= tmp;
            blocchi.setPosTestaX(actPosX);
            blocchi.posizionaIBlocchi();
        }else{
            gioco.getInstance().setMorto(true);
            System.out.println("USCITO LATO SX o DX");
        }
    }

    /**
     @brief Sposta la vipera sull'asse Y in base alla quantita passata come parametro

     @param quant direzione verticale di spostamento
     */
    public void incY(int quant){
        int tmp = actPosY+quant;

        if(tmp>=0 && tmp<gioco.getInstance().getDimensioneY()){
            actPosY= tmp;
            blocchi.setPosTestaY(actPosY);
            blocchi.posizionaIBlocchi();
        }else{
            gioco.getInstance().setMorto(true);
            System.out.println("USCITO LATO SOPRA o SOTTO");
        }
    }


    /**
     @brief Restituisce il valore dell'attributo actPosX
     */
    public int getX() {
        return actPosX;
    }
    /**
     @brief Restituisce il valore dell'attributo actPosY
     */
    public int getY() {
        return actPosY;
    }

    /**
     @brief Restituisce la dimensione della vipera
     */
    public int getDimensione(){return dimensione;}

    /**
     @brief Respawna la vipera reimpostando gli attributi
     */
    public void respawn() {
        reset();
    }

    /**
     @brief Restituisce il valore dell'attributo findingMela
     */
    public boolean isFindingMela(){
        return findingMela;
    }

    /**
     @brief Permette di impostare il valore dell'attributo findingMela in base al parametro passato

     @param b boolean
     */
    public void setFindingMela(boolean b) {
        findingMela=b;
    }

    /**
     @brief Imposta la direzione della vipera a seconda della direzione passata come parametro

     @param dir direzione della vipera
     */
    public void setDirezioneVipera(Directions dir) {
        blocchi.setDirezioneVipera(dir);
    }

    /**
     @brief Aggiunge un blocco in coda alla vipera

     @param coloreBlocco colore del blocco da aggiungere in coda
     */
    public void addBlocco(Color coloreBlocco) {
        blocchi.addBlocco(coloreBlocco);
    }

    /**
     @brief Sposta di un blocco a DX la vipera
     */
    public void spostaDx(){
        incX(dimensione);
    }
    /**
     @brief Sposta di un blocco a SX la vipera
     */
    public void spostaSx(){
        incX(-dimensione);
    }
    /**
     @brief Sposta di un blocco SOPRA la vipera
     */
    public void spostaTop(){
        incY(-dimensione);
    }
    /**
     @brief Sposta di un blocco SOTTO la vipera
     */
    public void spostaDown(){
        incY(dimensione);
    }

    /**
     @brief Restituisce la posizione X del blocco in base all'identificativo passato come parametro

     @param i identificativo del blocco
     */
    public int getXblocco(int i) {
        return blocchi.getXblocco(i);
    }

    /**
     @brief Restituisce la posizione Y del blocco in base all'identificativo passato come parametro

     @param i identificativo del blocco
     */
    public int getYblocco(int i) {
        return blocchi.getYblocco(i);
    }

    /**
     @brief Restituisce il colore del blocco in base all'identificativo passato come parametro

     @param i identificativo del blocco
     */
    public Color getColoreBlocco(int i) {
        return blocchi.getColoreBlocco(i);
    }

    /**
     @brief Dice se e' presente un blocco nella posizione X e Y dello schermo

     @param x posizione X dello schermo
     @param y posizione Y dello schermo
     */
    public boolean ePresenteUnBlocco(int x, int y) {
        return blocchi.ePresenteUnBlocco(x,y);
    }

    /**
     @brief Restituisce il colore dell'ultimo blocco in coda alla vipera
     */
    public Color getColoreUltimoBlocco() {
        return blocchi.getColoreUltimoBlocco();
    }
}
