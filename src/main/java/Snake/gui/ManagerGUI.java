package Snake.gui;

import Snake.game.gameManager;
import processing.core.PApplet;

import javax.swing.*;
import java.awt.*;

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
        drawUtilities();

    }

    private void disegnaMela() {
        int posMelaX = gameManager.getInstance().getPosMelaX();

        int posMelaY = gameManager.getInstance().getPosMelaY();

        int r = gameManager.getInstance().getDimensione();

        Color coloreMela = gameManager.getInstance().getColoreMela();
        tavola.fill(coloreMela.getRGB());
        tavola.ellipse(posMelaX, posMelaY,r , r);
    }

    private void visualizzaSchermataMorte(){
        JOptionPane.showMessageDialog(null, "SEI MORTO!");
        gameManager.getInstance().respawn();
    }

    private void disegnaVipera(){
        tavola.background(255, 255, 255);
        int r = gameManager.getInstance().getDimensione();
        int posX,posY;
        Color coloreBlocco;

        //disegno ogni blocco
        for(int i=0; i<= gameManager.getInstance().getNumMelePrese();i++){
            posX = gameManager.getInstance().posXblocco(i);
            posY = gameManager.getInstance().posYblocco(i);


            //Il serpente se deve essere colorato, si colora tutta la coda a seconda del colore dell'ultima mela catturata
            //la testa rimane peró sempre di colore rosso
            if(gameManager.getInstance().getSerpenteColorato()==true && i!=0){
                coloreBlocco = gameManager.getInstance().getColoreUltimoBlocco();
            }else{
                //Non voglio il serpente colorato, quindi la testa la disegno di rosso mentre il corpo tutto di nero
                if(i==0)
                    coloreBlocco=Color.red;
                else
                    coloreBlocco=Color.black;
            }


            tavola.fill(coloreBlocco.getRGB());
            tavola.ellipseMode(CENTER);
            tavola.rect(posX, posY,r , r);
        }
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

        tavola.fill(0);
        tavola.textSize(size);

        tavola.text("Punteggio: "+gameManager.getInstance().getNumMelePrese(), margine, dimensioniSchermo.getDimensioneY()+size+margine);
    }

    private void drawUtilities(){
        //TODO AGGIUNGERE BOTTONI E SLIDERS... COME SI FA??
        tavola.fill(10);
        Scrollbar slider = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 100);
        slider.setVisible(true);
        slider.setValues(50,100,0,100);

    }

    public int getDimensioneX(){
        return dimensioniSchermo.getDimensioneX();
    }
    public int getDimensioneY(){
        return dimensioniSchermo.getDimensioneY();
    }

}
