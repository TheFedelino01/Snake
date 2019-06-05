package Snake.game.threads;

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
    
    public thReader(){
        keyDown=' ';

        
    }

    @Override
    public void run(){
        gameManager gManager;

        while(!isInterrupted()){
            gManager = gameManager.getInstance();

            //TODO
            
            keyDown = commands.getInstance().getKeyDown();//Metto in maiuscolo
            System.out.println("Leggo carattere:"+keyDown);

            String ris="null";
            switch (keyDown){

                case 'W':
                    ris="Sposto TOP";
                    gManager.spostaTop();
                    break;
                case 'A':
                    ris="Sposto SX";
                    gManager.spostaSx();
                    break;
                case 'D':
                    ris="Sposto DX";
                    gManager.spostaDx();
                    break;
                case 'S':
                    ris="Sposto DOWN";
                    gManager.spostaDown();
                    break;

                default:
                    ris="null";
                    break;
            }
            System.out.println(ris);//Dico la mossa che ho fatto
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(thReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
