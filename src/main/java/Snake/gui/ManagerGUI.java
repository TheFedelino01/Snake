package Snake.gui;

import Snake.game.gameManager;
import Snake.game.viperaManager;
import processing.core.PApplet;

import java.awt.*;
import javax.swing.JOptionPane;

public class ManagerGUI {
    private size dimensioniSchermo;
    private PApplet tavola;

    private static ManagerGUI ourInstance = new ManagerGUI();
    public static ManagerGUI getInstance() {
        return ourInstance;
    }

    private ManagerGUI(){
    }
    
    public void setup(int dimensioneX, int dimensioneY, PApplet tavola) {
        dimensioniSchermo = new size(dimensioneX, dimensioneY);
        this.tavola = tavola;
        
    }


    public void draw(){
        if(gameManager.getInstance().isMorto()==false){
            tavola.background(255, 255, 255);
            int posXvipera = gameManager.getInstance().getActX();
            int posYvipera = gameManager.getInstance().getActY();
            int r = gameManager.getInstance().getDimensione();

            tavola.fill(10);
            tavola.ellipse(posXvipera, posYvipera,r , r);
        }else{
            visualizzaSchermataMorte();
        }       
    }
    
    private void visualizzaSchermataMorte(){
        JOptionPane.showMessageDialog(null, "SEI MORTO!");
        gameManager.getInstance().respawn();
    }


    public int getDimensioneX(){
        return dimensioniSchermo.getDimensioneX();
    }
    public int getDimensioneY(){
        return dimensioniSchermo.getDimensioneY();
    }

}
