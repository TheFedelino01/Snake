package Snake.game.threads;

import Snake.game.utility.Directions;
import Snake.game.utility.commands;
import Snake.game.gioco;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 @author  Saccani Federico, federico.saccani01@gmail.com
 @version 1.0
 */
/**
 La classe corrisponde al thread incaricato nel far muovere il serpente a seconda dell'ultimo input premuto dall'utente
 */
public class thReader extends Thread{
    /** Attributo che rappresenta l'ultimo input premuto*/
    private Character keyDown;
    /** Attributo che rappresenta la pausa del thread*/
    private int delay;

    /**
     @brief Costruttore della classe con parametro

     @param delay pausa del thread
     */
    public thReader(int delay){
        keyDown=' ';
        this.delay=delay;
    }

    /**
     @brief Metodo run del thread

     Se il serpente e' vivo, viene spostato in base all'ultimo input premuto dall'utente
     */
    @Override
    public void run(){

        while(!isInterrupted()){

            //Se non p morto, lo faccio muovere
            if(gioco.getInstance().isMorto()==false){
                keyDown = commands.getInstance().getKeyDown();//Metto in maiuscolo

                Directions direzione= Directions.NONE;

                switch (keyDown){

                    case 'W':
                        direzione=Directions.SOPRA;
                        break;
                    case 'A':
                        direzione=Directions.SINISTRA;
                        break;
                    case 'D':
                        direzione=Directions.DESTRA;
                        break;
                    case 'S':
                        direzione=Directions.SOTTO;
                        break;

                    default:
                        break;
                }
                //Sposto la vipera
                gioco.getInstance().setDirezioneVipera(direzione);

                gioco.getInstance().sposta(direzione);

            }
            
            //Dorme per il delay anche se e' morto cosi non sovraccarico il sistema
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(thReader.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

}
