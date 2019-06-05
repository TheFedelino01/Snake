package Snake.gui;

import Snake.game.gameManager;
import processing.core.PApplet;

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
            disegnaVipera();
            disegnaMela();
        }else{
            visualizzaSchermataMorte();
        }       
    }

    private void disegnaMela() {
        int posMelaX = gameManager.getInstance().getPosMelaX();

        int posMelaY = gameManager.getInstance().getPosMelaY();

        tavola.fill(10);
        tavola.ellipse(posMelaX, posMelaY,10 , 10);
    }

    private void visualizzaSchermataMorte(){
        JOptionPane.showMessageDialog(null, "SEI MORTO!");
        gameManager.getInstance().respawn();
    }

    private void disegnaVipera(){
        tavola.background(255, 255, 255);
        int posXvipera = gameManager.getInstance().getActX();
        int posYvipera = gameManager.getInstance().getActY();
        int r = gameManager.getInstance().getDimensione();

        tavola.fill(10);
        tavola.ellipse(posXvipera, posYvipera,r , r);
    }

    public int getDimensioneX(){
        return dimensioniSchermo.getDimensioneX();
    }
    public int getDimensioneY(){
        return dimensioniSchermo.getDimensioneY();
    }

}
