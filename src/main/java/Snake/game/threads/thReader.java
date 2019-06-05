package Snake.game.threads;

import Snake.game.Directions;
import Snake.game.commands;
import Snake.game.gameManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.Scanner;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.PApplet;

public class thReader extends Thread{

    private Character keyDown;
    private int delay=100;
    
    public thReader(){
        keyDown=' ';
    }

    @Override
    public void run(){
        gameManager gManager;

        while(!isInterrupted()){

            //Se non p morto, lo faccio muovere
            if(gameManager.getInstance().isMorto()==false){
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
                gameManager.getInstance().sposta(direzione);

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
