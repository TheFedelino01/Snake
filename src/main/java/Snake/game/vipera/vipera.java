package Snake.game.vipera;

import Snake.game.Directions;
import Snake.game.gameManager;
import Snake.gui.ManagerGUI;

import java.awt.*;

public class vipera {
    private boolean vivo;

    private int actPosX, actPosY;
    private int dimensione;

    private boolean findingMela;

    private blocchi blocchi;


    private static vipera ourInstance = new vipera();
    public static vipera getInstance() {
        return ourInstance;
    }

    private vipera() {
        reset();
    }

    private void reset(){
        actPosX=50;
        actPosY=50;
        dimensione=50;
        findingMela=false;
        blocchi = new blocchi(actPosX,actPosY);//Creo una nuova lista
    }


    public void incX(int quant){
        int tmp = actPosX+quant;
        
        if(tmp>=0 && tmp<ManagerGUI.getInstance().getDimensioneX()){
            actPosX= tmp;
            blocchi.setPosTestaX(actPosX);
            blocchi.posizionaIBlocchi();
        }else{
            gameManager.getInstance().setMorto(true);
            System.out.println("USCITO LATO SX o DX");
        }
    }
    public void incY(int quant){
        int tmp = actPosY+quant;
        
        if(tmp>=0 && tmp<ManagerGUI.getInstance().getDimensioneY()){
            actPosY= tmp;
            blocchi.setPosTestaY(actPosY);
            blocchi.posizionaIBlocchi();
        }else{
            gameManager.getInstance().setMorto(true);
            System.out.println("USCITO LATO SOPRA o SOTTO");
        }
    }



    public int getX() {
        return actPosX;
    }
    public int getY() {
        return actPosY;
    }

    public int getDimensione(){return dimensione;}

    void respawn() {
        reset();
    }

    public boolean isFindingMela(){
        return findingMela;
    }

    public void setFindingMela(boolean b) {
        findingMela=b;
    }

    public void setDirezioneVipera(Directions dir) {
        blocchi.setDirezioneVipera(dir);
    }

    public void addBlocco(Color coloreBlocco) {
        blocchi.addBlocco(coloreBlocco);

    }

    public int getXblocco(int i) {
        return blocchi.getXblocco(i);
    }

    public int getYblocco(int i) {
        return blocchi.getYblocco(i);
    }

    public Color getColoreBlocco(int i) {
        return blocchi.getColoreBlocco(i);
    }

    public boolean ePresenteUnBlocco(int x, int y) {
        return blocchi.ePresenteUnBlocco(x,y);
    }
}
