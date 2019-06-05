package Snake.game;

import Snake.game.vipera.viperaManager;

public class gameManager {

    private Snake.game.vipera.viperaManager viperaManager;
    private boolean morto;
    private mela actualMela;

    private static gameManager ourInstance = new gameManager();
    public static gameManager getInstance() {
        return ourInstance;
    }

    private gameManager(){
        viperaManager = new viperaManager();
        morto=false;
        actualMela=new mela();

    }



    public void setMorto(boolean v){
        morto=v;
    }

    public int getActX(){
        return viperaManager.getActX();
    }
    public int getActY(){
        return viperaManager.getActY();
    }
    public int getDimensione(){
        return viperaManager.getDimensione();
    }
    
    public void sposta(Directions direzione){
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

    public boolean isMorto() {
        return morto;
    }

    public void respawn() {
        morto=false;
        viperaManager.respawn();
        commands.getInstance().clearKeyDown();
    }

    public boolean isFindingMela(){
        return viperaManager.isFindingMela();
    }


    public void setPosMela(int posMelaX, int posMelaY) {
        actualMela.setPosX(posMelaX);
        actualMela.setPosY(posMelaY);
    }

    public int getPosMelaX(){
        return actualMela.getPosX();
    }

    public int getPosMelaY(){
        return actualMela.getPosY();
    }

    public void setFindingMela(boolean b) {
        viperaManager.setFindindMela(b);
    }
}
