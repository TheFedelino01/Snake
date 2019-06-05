package Snake.game;

import Snake.game.vipera.viperaManager;
import com.sun.javafx.scene.traversal.Direction;

public class gameManager {

    private Snake.game.vipera.viperaManager viperaManager;
    private boolean morto;
    private mela actualMela;

    private static gameManager ourInstance = new gameManager();
    public static gameManager getInstance() {
        return ourInstance;
    }

    private int meleRaccolte=0;

    private gameManager(){
        viperaManager = new viperaManager();
        morto=false;
        actualMela=new mela();

    }



    public synchronized void setMorto(boolean v){
        morto=v;
    }

    public synchronized int getActX(){
        return viperaManager.getActX();
    }
    public synchronized int getActY(){
        return viperaManager.getActY();
    }
    public synchronized int getDimensione(){
        return viperaManager.getDimensione();
    }
    
    public synchronized void sposta(Directions direzione){
        switch(direzione){
            case SOPRA:
                viperaManager.spostaTop();
                break;
                
            case SOTTO:
                viperaManager.spostaDown();
                break;
                
            case DESTRA:
                viperaManager.spostaDx();
                break;
                
            case SINISTRA:
                viperaManager.spostaSx();
                break;
                
            default:
                break;
        }
    }

    public synchronized boolean isMorto() {
        return morto;
    }

    public synchronized void respawn() {
        morto=false;
        viperaManager.respawn();
        commands.getInstance().clearKeyDown();
        meleRaccolte=0;
    }

    public synchronized boolean isFindingMela(){
        return viperaManager.isFindingMela();
    }


    public synchronized void setPosMela(int posMelaX, int posMelaY) {
        actualMela.setPosX(posMelaX);
        actualMela.setPosY(posMelaY);
    }

    public synchronized void melaPresa(){
        meleRaccolte++;
        viperaManager.addBlocco();
    }

    public synchronized int getNumMelePrese(){
        return meleRaccolte;
    }

    public synchronized void setDirezioneVipera(Directions dir){
        viperaManager.setDirezioneVipera(dir);
    }

    public synchronized int getPosMelaX(){
        return actualMela.getPosX();
    }

    public synchronized int getPosMelaY(){
        return actualMela.getPosY();
    }

    public synchronized void setFindingMela(boolean b) {
        viperaManager.setFindindMela(b);
    }


    public synchronized int posXblocco(int i){
        return viperaManager.getXblocco(i);
    }

    public synchronized int posYblocco(int i){
        return viperaManager.getYblocco(i);
    }
}
