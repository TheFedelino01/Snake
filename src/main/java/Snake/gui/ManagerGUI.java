package Snake.gui;

import Snake.game.gioco;
import processing.core.PApplet;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.CENTER;
/**
 @author  Saccani Federico, federico.saccani01@gmail.com
 @version 1.0
 */

/**
 Classe che gestisce il rendering video
 */
public class ManagerGUI {
    /** Attributo che rappresenta la dimensione della finestra di giocoX*/
    private size dimensioniSchermo;
    /** Attributo relativo al PApplet per il disegno grafico*/
    private PApplet tavola;

    /**
     @brief Costruttore vuoto della classe

     Imposta gli attributi della classe a valore standard
     */
    public ManagerGUI(int dimensioneX, int dimensioneY, PApplet tavola){
        dimensioniSchermo = new size(dimensioneX, dimensioneY);
        this.tavola = tavola;
    }

    /**
     @brief Il metodo quando richiamato permette di impostare gli attributi della classe in base ai parametri passati

     @param dimensioneX dimensione X dello schermo
     @param dimensioneY dimensione Y dello schermo
     @param tavola oggetto riferito al disegno grafico
     */
    public void setup(int dimensioneX, int dimensioneY, PApplet tavola) {

        
    }

    /**
     @brief Il metodo permette di disegnare tutti gli oggetti grafici del gioco

     Il metodo richiama i metodi di draw relativi alle classi Vipera e Mela; inoltre disegna le griglie, il punteggio e l'utilities
     */
    public void draw(){

        if(gioco.getInstance().isMorto()==false){
            disegnaVipera();
            disegnaMela();
        }else{
            visualizzaSchermataMorte();
        }
        drawGrids();
        drawPunteggio();
        drawUtilities();

    }

    /**
     @brief Il metodo genera la posizione della mela all'interno eello schermo, di seguito disegna l'ellisse colorato
     */
    private void disegnaMela() {
        int posMelaX = gioco.getInstance().getPosMelaX();

        int posMelaY = gioco.getInstance().getPosMelaY();

        int r = gioco.getInstance().getDimensione();

        Color coloreMela = gioco.getInstance().getColoreMela();
        tavola.fill(coloreMela.getRGB());
        tavola.ellipse(posMelaX, posMelaY,r , r);
    }

    /**
     @brief Il metodo mostra il messaggio di restart
     */
    private void visualizzaSchermataMorte(){
        JOptionPane.showMessageDialog(null, "SEI MORTO!");
        gioco.getInstance().respawn();
    }

    /**
     @brief Il metodo disegna ogni blocco che compone la vipera

     Se si vuole il serpente colorato, la testa rimane di colore rosso mentre il corpo prende il colore dell'ultima mela catturata.
     Se invece il serpente non deve essere colorato, la testa sara' sempre rossa mentre il corpo tutto nero.
     */
    private void disegnaVipera(){
        tavola.background(255, 255, 255);
        int r = gioco.getInstance().getDimensione();
        int posX,posY;
        Color coloreBlocco;

        //disegno ogni blocco
        for(int i=0; i<= gioco.getInstance().getNumMelePrese();i++){
            posX = gioco.getInstance().posXblocco(i);
            posY = gioco.getInstance().posYblocco(i);


            //Il serpente se deve essere colorato, si colora tutta la coda a seconda del colore dell'ultima mela catturata
            //la testa rimane peró sempre di colore rosso
            if(gioco.getInstance().getSerpenteColorato()==true && i!=0){
                coloreBlocco = gioco.getInstance().getColoreUltimoBlocco();
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

    /**
     @brief Il metodo disegna, a seconda della dimensione del serpente, le griglie per le righe e per le colonne

     Per disegnare le righe e le colonne vengono disegnate piu' quadrati attaccati l'uno all'altro
     */
    private void drawGrids() {
        int dimVipera = gioco.getInstance().getDimensione();
//txt

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

    /**
     @brief Il metodo disegna il punteggio della partita su schermo
     */
    private void drawPunteggio(){
        int size =30;
        int margine=25;

        tavola.fill(0);
        tavola.textSize(size);

        tavola.text("Punteggio: "+gioco.getInstance().getNumMelePrese(), margine, dimensioniSchermo.getDimensioneY()+size+margine);
    }

    /**
     @brief Il metodo disegna le utilities su schermo
     */
    private void drawUtilities(){
        //TODO AGGIUNGERE BOTTONI E SLIDERS... COME SI FA??
        tavola.fill(10);
        Scrollbar slider = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 100);
        slider.setVisible(true);
        slider.setValues(50,100,0,100);

    }

    /**
     @brief Il metodo restituisce la dimensione X dello schermo

     @return dimensione X dello schermo
     */
    public int getDimensioneX(){
        return dimensioniSchermo.getDimensioneX();
    }

    /**
     @brief Il metodo restituisce la dimensione Y dello schermo

     @return dimensione Y dello schermo
     */
    public int getDimensioneY(){
        return dimensioniSchermo.getDimensioneY();
    }

}
