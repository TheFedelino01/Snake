package Snake.game.utility;


import java.io.IOException;
import java.util.concurrent.Semaphore;
/**
 @author  Saccani Federico, federico.saccani01@gmail.com
 @version 1.0
 */
/**
 Classe che premette la sincronizzazione tra i vari threads
 */
public class syncTh {
    /** Attributo che rappresenta il semaforo per prendere la mela*/
    private Semaphore prendo;
    /** Attributo che rappresenta il semaforo per generare la mela*/
    private Semaphore genera;

    /**
     @brief Costruttore senza parametri della classe

     Inizializza i semafori della classe
     */
    public syncTh(){
        prendo = new Semaphore(1);
        genera = new Semaphore(0);
    }

    /**
     @brief Il metodo permette di aspettare che la mela venga presa
     */
    public void aspettoChePrende(){
        try {
            System.out.println("ASPETTO CHE PRENDE LA MELA");
            prendo.acquire();
        }catch(InterruptedException e){System.out.println(e.toString());}
    }

    /**
     @brief Il metodo permette di segnalare che la mela e' stata presa
     */
    public void dicoCheHoPreso(){
        System.out.println("DICO CHE HO PRESO LA MELA");
        prendo.release();
    }
    /**
     @brief Il metodo permette di aspettare che la mela venga generata
     */
    public void aspettoCheGenera(){
        try{
            System.out.println("ASPETTO CHE GENERI LA MELA");
            genera.acquire();
        }catch(InterruptedException e){System.out.println(e.toString());}
    }

    /**
     @brief Il metodo permette di segnalare che la mela e' stata generata
     */
    public void dicoCheHoGenerato(){
        System.out.println("DICO CHE HO GENERATO LA MELA");
        genera.release();
    }
}
