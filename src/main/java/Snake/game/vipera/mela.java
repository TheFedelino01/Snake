package Snake.game.vipera;

import java.awt.*;
import java.util.Random;

public class mela {
    private int posMelaX;
    private int posMelaY;

    private Color colori[]= {Color.red, Color.green, Color.BLUE, Color.cyan, Color.magenta, Color.yellow, Color.pink};
    //private Color colori[]= {Color.red,Color.BLUE};
    private Color colore;

    public mela(){
        generateColor();
    }

    public void setPosY(int posMelaY) {
        this.posMelaY=posMelaY;
    }

    public void setPosX(int posMelaX) {
        this.posMelaX=posMelaX;
    }

    public int getPosX() {
        return posMelaX;
    }
    public int getPosY() {
        return posMelaY;
    }


    public void generateColor(){
        Random rn = new Random();

        int colRnd = rn.nextInt(colori.length);

        colore = colori[colRnd];
    }

    public Color getColore(){
        return colore;
    }

    public void cambiaColore() {
        generateColor();
    }
}
