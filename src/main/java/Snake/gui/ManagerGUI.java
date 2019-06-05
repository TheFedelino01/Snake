package Snake.gui;

import Snake.game.gameManager;
import processing.core.PApplet;

import javax.swing.JOptionPane;

import static javax.swing.SwingConstants.CENTER;

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
        drawGrids();
        drawPunteggio();

    }

    private void disegnaMela() {
        int posMelaX = gameManager.getInstance().getPosMelaX();

        int posMelaY = gameManager.getInstance().getPosMelaY();

        int r = gameManager.getInstance().getDimensione();

        tavola.fill(255,0,0);
        tavola.ellipse(posMelaX, posMelaY,r , r);
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
        tavola.ellipseMode(CENTER);
        tavola.rect(posXvipera, posYvipera,r , r);
    }


    private void drawGrids() {
        int dimVipera = gameManager.getInstance().getDimensione();


        int cols = dimensioniSchermo.getDimensioneX() / dimVipera;
        int rows = dimensioniSchermo.getDimensioneY() / dimVipera;



        // Begin loop for columns
        for (int i = 0; i < cols; i++) {
            // Begin loop for rows
            for (int j = 0; j < rows; j++) {

                // Scaling up to draw a rectangle at (x,y)
                int x = i * dimVipera;
                int y = j * dimVipera;

                tavola.fill(255,0);//Solo il contorno nero
                tavola.stroke(0);

                // For every column and row, a rectangle is drawn at an (x,y) location scaled and sized by videoScale.
                tavola.rect(x, y, dimVipera, dimVipera);
            }
        }
    }

    private void drawPunteggio(){
        int size =30;
        int margine=25;

        tavola.fill(0,255,0);
        tavola.textSize(size);

        tavola.text("Punteggio: "+gameManager.getInstance().getNumMelePrese(), margine, dimensioniSchermo.getDimensioneY()+size+margine);
    }

    public int getDimensioneX(){
        return dimensioniSchermo.getDimensioneX();
    }
    public int getDimensioneY(){
        return dimensioniSchermo.getDimensioneY();
    }

}
