package Snake.game.vipera;

import Snake.game.utility.Directions;
import Snake.game.gioco;

import java.awt.*;
import java.util.Vector;
/**
 @author  Saccani Federico, federico.saccani01@gmail.com
 @version 1.0
 */
/**
 La classe corrisponde ad un blocco che compone la struttura della vipera
 */
public class blocco {
    /** Attributo che rappresenta la posizione X del blocco*/
    private int actPosX;
    /** Attributo che rappresenta la posizione Y del blocco*/
    private int actPosY;

    /** Attributo che corrisponde alle mosse effettuate dal blocco*/
    private Vector<Directions> tutteMosse = new Vector<Directions>();

    /** Attributo che se true significa che un altro blocco e' stato generato in corrispondenza di questo blocco*/
    private boolean hoUnFiglio;

    /** Attributo che afferma se si e' distaccato il blocco in corrispondenza di almeno un unita'*/
    private boolean distaccaFiglio;//Non ho ancora distaccato di 1 unita il figlio

    /** Attributo che rappresenta il colore del blocco*/
    private Color colore;

    /**
     @brief Costruttore senza parametri della classe

     Quando chiamato, imposta gli attributi della classi a valori di default
     */
    public blocco(){
        actPosX=-1;
        actPosY=-1;
        hoUnFiglio=false;
        distaccaFiglio=false;
        colore=null;
    }

    /**
     @brief Costruttore con parametri della classe

     Imposta gli attributi della classe a seconda dei parametri passati

     @param startX posizione dell'asse X iniziale
     @param startY posizione dell'asse Y iniziale
     @param colore colore del blocco
     */
    public blocco(int startX, int startY, Color colore){
        this.actPosX=startX;
        this.actPosY=startY;
        hoUnFiglio=false;
        distaccaFiglio=false;
        this.colore = colore;
    }


    /**
     @brief Il metodo permette di aggiornare l'attributo tutteMosse a seconda della direzione passata come parametro

     Il metodo aggiorna l'attributo tutteMosse in modo tale da consentire ai blocchi adiacenti di far seguire la strada
     che questo blocco ha effettuato (effetto snake).
     Si preoccupa inoltre della gestione di un altro blocco generato in sua corrispondenza per
     evitare che venga segnalato come morte (serpente che si mangia la coda)
     */
    public void setSguardoRivolto(Directions dir) {

        //Controllo se sono ho un figlio
        if(hoUnFiglio==true){
            //Devo distaccare il figlio di 1 unita
            if(distaccaFiglio==false){
                //Mi muovo ma non faccio muovere il figlio
                tutteMosse.add(Directions.NONE);
                tutteMosse.add(dir);
                //Dico che l'ho "distaccato"
                distaccaFiglio=true;
            }else{
                //L'ho giá distaccato e quindi gli dico che pos ero prima
                tutteMosse.add(dir);
            }

        }
    }


    /**
     @brief Ritorna la posizione X del blocco
     */
    public int getX(){
        return actPosX;
    }
    /**
     @brief Ritorna la posizione Y del blocco
     */
    public int getY(){
        return actPosY;
    }

    /**
     @brief Imposta la posizione X del blocco a seconda del parametro

     @param actPosX posizioneX
     */
    public void setX(int actPosX) {
        this.actPosX=actPosX;
    }
    /**
     @brief Imposta la posizione Y del blocco a seconda del parametro

     @param actPosY posizioneY
     */
    public void setY(int actPosY) {
        this.actPosY=actPosY;
    }


    /**
     @brief Il metodo permette di far muovere il blocco a seconda della direzione passata come parametro

     In base alla dimensione dei blocchi che compongono la vipera viene mosso questo blocco.
     */
    public void segui(Directions doveVado){
        int dimVipera = gioco.getInstance().getDimensione();

        switch(doveVado){
            case DESTRA:
                actPosX+=dimVipera;
                break;
            case SINISTRA:
                actPosX-=dimVipera;
                break;
            case SOPRA:
                actPosY-=dimVipera;
                break;
            case SOTTO:
                actPosY+=dimVipera;
                break;
            default:
                break;
                //RIMANGO FERMO
        }

        setSguardoRivolto(doveVado);

    }

    /**
     @brief Il metodo quando richiamato permette di far sapere al blocco attuale che e' stato generato un blocco in sua corrispondenza
     */
    public void dicoCheHoUnFiglio(){
        //Se non ho ancora un figlio, gli dico che ora ne ha uno
        //e quindi inizia a segnare i vari spostamenti

        if(hoUnFiglio==false){
            hoUnFiglio=true;
        }

    }

    /**
     @brief Il metodo ritorna l'ultima mossa effettuata dal blocco attraverso una pop
     */
    public Directions getLastMossa(){
        Directions ris = tutteMosse.get(0);
        tutteMosse.remove(0);
        return ris;
    }

    /**
     @brief Il metodo ritorna il colore del blocco
     */
    public Color getColore(){
        return colore;
    }

    /**
     @brief Il metodo ritorna l'attributo distaccaFiglio
     */
    public boolean getHoDistaccato() {
        return distaccaFiglio;
    }
}
