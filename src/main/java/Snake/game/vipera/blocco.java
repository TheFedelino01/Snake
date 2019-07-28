package Snake.game.vipera;

import Snake.game.Directions;
import Snake.game.gameManager;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class blocco {

    private int actPosX,actPosY;
    private Vector<Directions> tutteMosse = new Vector<Directions>();

    private boolean amiTesta,hoUnFiglio;
    private boolean distaccaFiglio;//Non ho ancora distaccato di 1 unita il figlio



    private Color colore;

    public blocco(){
        actPosX=-1;
        actPosY=-1;
        amiTesta=false;
        hoUnFiglio=false;
        distaccaFiglio=false;
        colore=null;
    }

    public blocco(int startX, int startY,boolean testa, Color colore){
        this.actPosX=startX;
        this.actPosY=startY;
        amiTesta=testa;
        hoUnFiglio=false;
        distaccaFiglio=false;
        this.colore = colore;
    }


    public void setSguardoRivolto(Directions dir) {

        //Controllo se sono ho un figlio
        if(hoUnFiglio==true){
            //Devo distaccare il figlio di 1 unita
            if(distaccaFiglio==false){
                //Mi muovo ma non faccio muovere il figlio
                tutteMosse.add(Directions.NONE);
                tutteMosse.add(dir);
                 //Dico che l'ho "distaccato"
                distaccaFiglio=true;
            }else{
                //L'ho giá distaccato e quindi gli dico che pos ero prima
                tutteMosse.add(dir);
            }

        }
    }



    public int getX(){
        return actPosX;
    }

    public int getY(){
        return actPosY;
    }


    public void setX(int actPosX) {
        this.actPosX=actPosX;
    }

    public void setY(int actPosY) {
        this.actPosY=actPosY;
    }

    public void segui(Directions doveVado){
        int dimVipera = gameManager.getInstance().getDimensione();

        switch(doveVado){
            case DESTRA:
                actPosX+=dimVipera;
                break;
            case SINISTRA:
                actPosX-=dimVipera;
                break;
            case SOPRA:
                actPosY-=dimVipera;
                break;
            case SOTTO:
                actPosY+=dimVipera;
                break;
            default:
                break;
                //RIMANGO FERMO
        }

        setSguardoRivolto(doveVado);

    }

    public void dicoCheHoUnFiglio(){
        //Se non ho ancora un figlio, gli dico che ora ne ha uno
        //e quindi inizia a segnare i vari spostamenti

        if(hoUnFiglio==false){
            hoUnFiglio=true;
        }

    }

    public Directions getLastMossa(){
        Directions ris = tutteMosse.get(0);
        tutteMosse.remove(0);
        return ris;
    }

    public Color getColore(){
        return colore;
    }


    public boolean getHoDistaccato() {
        return distaccaFiglio;
    }
}
