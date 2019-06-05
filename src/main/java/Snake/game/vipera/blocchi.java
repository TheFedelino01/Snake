package Snake.game.vipera;

import Snake.game.Directions;
import Snake.game.gameManager;

import java.util.List;
import java.util.Vector;

public class blocchi {

    private Vector<blocco> blocchi = new Vector<blocco>();

    public blocchi(int startX, int startY){
        //creo la testa
        blocchi.add(new blocco(startX,startY,true));
    }

    public void setDirezioneVipera(Directions dir) {
        prendiTesta().setSguardoRivolto(dir);
    }

    private blocco prendiTesta(){
        return blocchi.get(0);
    }
    private blocco prendiUltimoBlocco(){
        return blocchi.get(blocchi.size()-1);
    }

    public void addBlocco(){
        //Il blocco prende la posizione dell'ultimo blocco
        int xNuovo = dimmiXdelNuovoBlocco();
        int yNuovo = dimmiYdelNuovoBlocco();

        prendiUltimoBlocco().dicoCheHoUnFiglio();//Ora ha un figlio

        //aggiungo un blocco che non e' una testa
        blocchi.add(new blocco(xNuovo,yNuovo,false));


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



}
