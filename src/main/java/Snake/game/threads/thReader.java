package Snake.game.threads;

import Snake.game.gameManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.Scanner;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class thReader extends Thread implements KeyListener{

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

            keyDown = Character.toUpperCase(keyDown);//Metto in maiuscolo
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

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyDown = e.getKeyChar();
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }



}
