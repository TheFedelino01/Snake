package Snake.game.threads;

import Snake.game.utility.Directions;
import Snake.game.utility.commands;
import Snake.game.gioco;

import java.util.logging.Level;
import java.util.logging.Logger;


public class thReader extends Thread{

    private Character keyDown;
    private int delay;
    
    public thReader(int delay){
        keyDown=' ';
        this.delay=delay;
    }

    @Override
    public void run(){

        while(!isInterrupted()){

            //Se non p morto, lo faccio muovere
            if(gioco.getInstance().isMorto()==false){
                keyDown = commands.getInstance().getKeyDown();//Metto in maiuscolo

                String ris="null";
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
                        ris="null";
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
