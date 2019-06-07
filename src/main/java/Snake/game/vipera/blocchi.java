package Snake.game.vipera;

import Snake.game.Directions;
import Snake.game.gameManager;

import java.awt.*;
import java.util.List;
import java.util.Vector;

public class blocchi {

    private Vector<blocco> blocchi = new Vector<blocco>();

    public blocchi(int startX, int startY){
        //creo la testa, la testa ha sempre il colore rosso!
        blocchi.add(new blocco(startX,startY,true, Color.red));
    }

    public void setDirezioneVipera(Directions dir) {
        prendiTesta().setSguardoRivolto(dir);
        //Se si sovrappone, faccio morire il serpente
        if(controllaSeTestaColpisceCoda()==true){
            gameManager.getInstance().setMorto(true);
        }
    }

    private boolean controllaSeTestaColpisceCoda(){
        blocco testa = prendiTesta();
        int xtesta = testa.getX();
        int ytesta = testa.getY();

        blocco checkBlocco;

        for(int i=1; i< blocchi.size();i++){
            checkBlocco = blocchi.get(i);
            if(checkBlocco.getX()==xtesta && checkBlocco.getY()==ytesta){

                //Evito che il primo blocco che spawna in corrispondenza della testa, venga
                //considerato come collisione
                if(testa.getHoDistaccato()==true && blocchi.size()!=2) {
                    return true;//Dico che la testa ha colpito un pezzo della coda
                }
            }

        }
        return false;
    }


    private blocco prendiTesta(){
        return blocchi.get(0);
    }
    private blocco prendiUltimoBlocco(){
        return blocchi.get(blocchi.size()-1);
    }

    public void addBlocco(Color coloreBlocco){
        //Il blocco prende la posizione dell'ultimo blocco
        int xNuovo = dimmiXdelNuovoBlocco();
        int yNuovo = dimmiYdelNuovoBlocco();

        prendiUltimoBlocco().dicoCheHoUnFiglio();//Ora ha un figlio

        //aggiungo un blocco che non e' una testa
        blocchi.add(new blocco(xNuovo,yNuovo,false,coloreBlocco));


    }

    private boolean collideConQualcheAltroBloccoX(blocco daCheck){

        for(int i=0 ;i < blocchi.size();i++){
            if(blocchi.get(i).getX()==daCheck.getX()){
                return true;
            }
        }

        return false;
    }

    private int dimmiXdelNuovoBlocco(){
        blocco ultimo = prendiUltimoBlocco();
        return ultimo.getX();
    }
    private int dimmiYdelNuovoBlocco(){
        blocco ultimo = prendiUltimoBlocco();
        return ultimo.getY();
    }

    public void setPosTestaX(int actPosx) {
        prendiTesta().setX(actPosx);
    }

    public void setPosTestaY(int actPosY) {
        prendiTesta().setY(actPosY);
    }

    public void posizionaIBlocchi() {
        blocco stoConsiderando;
        blocco bloccoDavanti;


        for(int i=1; i<blocchi.size();i++){
            stoConsiderando = blocchi.get(i);
            bloccoDavanti = blocchi.get(i-1);

            stoConsiderando.segui(bloccoDavanti.getLastMossa());
        }
    }

    public int getXblocco(int i) {
        return blocchi.get(i).getX();
    }

    public int getYblocco(int i) {
        return blocchi.get(i).getY();
    }


    public Color getColoreBlocco(int i) {
        return blocchi.get(i).getColore();
    }

    public boolean ePresenteUnBlocco(int x, int y) {
        int xBlocco,yBlocco;
        int fggg=0;

        //Se trovo un blocco con x e y == a quelli passati da parametro, ritorno true
        for(int i=0; i<blocchi.size();i++){
            xBlocco=blocchi.get(i).getX();
            yBlocco=blocchi.get(i).getY();
            if(xBlocco==x && yBlocco==y){
                return true;
            }
        }
        return false;
    }
}
