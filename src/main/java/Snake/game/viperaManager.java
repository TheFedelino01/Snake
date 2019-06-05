package Snake.game;

public class viperaManager {

    private int dimensione;

    public viperaManager(){
        dimensione = vipera.getInstance().getDimensione();
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
}
