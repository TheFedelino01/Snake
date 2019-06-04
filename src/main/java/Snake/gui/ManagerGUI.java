package Snake.gui;

import Snake.game.gameManager;
import processing.core.PApplet;

import java.awt.*;

public class ManagerGUI {
    private size dimensioniSchermo;
    private PApplet tavola;

    public ManagerGUI(int dimensioneX, int dimensioneY, PApplet tavola) {
        dimensioniSchermo = new size(dimensioneX, dimensioneY);
        this.tavola = tavola;


    }


    public void draw(){
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
