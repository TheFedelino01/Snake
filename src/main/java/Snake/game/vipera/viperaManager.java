package Snake.game.vipera;

import Snake.game.Directions;
import Snake.game.vipera.vipera;

public class viperaManager {

    private int dimensione;

    public viperaManager(){
        dimensione = vipera.getInstance().getDimensione();
    }


    public boolean isFindingMela(){
        return vipera.getInstance().isFindingMela();
    }

    public void spostaDx(){
        vipera.getInstance().incX(dimensione);
    }

    public void spostaSx(){
        vipera.getInstance().incX(-dimensione);
    }

    public void spostaTop(){
        vipera.getInstance().incY(-dimensione);
    }

    public void spostaDown(){
        vipera.getInstance().incY(dimensione);
    }

    public int getActX() {
        return vipera.getInstance().getX();
    }
    public int getActY() {
        return vipera.getInstance().getY();
    }
    public int getDimensione(){return vipera.getInstance().getDimensione();}
    
    public void respawn(){
        vipera.getInstance().respawn();
    }

    public void setFindindMela(boolean b) {
        vipera.getInstance().setFindingMela(b);
    }

    public void setDirezioneVipera(Directions dir) {
        vipera.getInstance().setDirezioneVipera(dir);
    }

    public void addBlocco() {
        vipera.getInstance().addBlocco();
    }

    public int getXblocco(int i) {
        return vipera.getInstance().getXblocco(i);
    }

    public int getYblocco(int i) {
        return vipera.getInstance().getYblocco(i);
    }
}
