/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake.game.utility;

/**
 @author  Saccani Federico, federico.saccani01@gmail.com
 @version 1.0
 */
/**
 La classe gestisce i comandi inviati da tastiera
 */
public class commands {
    /** Attributo che rappresenta l'ultimo comando inviato*/
    private Character keyDown;

    /** Attributo che rappresenta l'instance privata per singleton*/
    private static commands ourInstance = new commands();
    /** Attributo che rappresenta l'instance pubblica per singleton*/
    public static commands getInstance() {
        return ourInstance;
    }

    /**
     @brief Costruttore privato senza parametri della classe
     */
    private commands(){
        keyDown=' ';
    }

    /**
     @brief Il metodo permette di impostare l'attributo keyDown in base ai parametri passati

     Il metodo converte l'input delle frecce della tastiera nei rispettivi comandi WASD
     @param car carattere premuto su tastiera
     @param keyCode codice del carattere premuto su tastiera
     */
    public void setKeyDown(Character car, int keyCode){
        car = Character.toUpperCase(car);

        Character carTmp = convertToWASD(keyCode);
        if(carTmp!=null){
            car = carTmp;//Se e' un arrow, faccio assumere il valore altrimenti non faccio ninete
        }

        //Deve essere una lettera
        if (car == 'A' || car == 'W' || car == 'S' || car == 'D') {
            //Se vuole tornare indietro, blocco la mossa
            if(isDoingAMossaProibita(car)==false) {
                this.keyDown = car;
            }
        }
    }

    /**
     @brief Ritorna l'ultimo comando inviato (keyDown)
     */
    public Character getKeyDown() {
        return keyDown;
    }

    /**
     @brief Resetta l'attributo keyDown
     */
    public void clearKeyDown(){
        keyDown=' ';
    }

    /**
     @brief Il metodo converte il parametro passato nella sequenza di tasti WASD

     @param keyCode codice del tasto riferito alle frecce della tastiera che deve essere trasformato in WASD
     */
    private Character convertToWASD(int keyCode){
        Character ris=null;

        switch(keyCode){
            case 38:
                ris='W';
                break;
            case 40:
                ris='S';
                break;
            case 37:
                ris='A';
                break;
            case 39:
                ris='D';
                break;

            default:
                ris=null;
                break;//Non e' un Arrow e non lo converto a WASD
        }

        return ris;
    }

    /**
     @brief Metodo che ritorna true quando vogliamo tornare indietro sullo stesso asse

     Evita che vengano eseguiti comandi di cambio direzione sullo stesso asse.
     Esempio: mi sto muovendo a DX, non posso dire di muovermi a SX perche' altrimenti andrei a sovrappormi con la testa sulla coda
     */
    private boolean isDoingAMossaProibita(Character car){
        //Inversione orizzontale
        if((keyDown=='A' && car=='D')||(keyDown=='D' && car=='A')){
            return true;
        }else if((keyDown=='W' && car=='S')||(keyDown=='S' && car=='W')){//Inversione verticale
            return true;
        }

        return false;

    }

}
