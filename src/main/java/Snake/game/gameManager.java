package Snake.game;

public class gameManager {

    private viperaManager viperaManager;

    private static gameManager ourInstance = new gameManager();
    public static gameManager getInstance() {
        return ourInstance;
    }

    private gameManager(){
        viperaManager = new viperaManager(500,500);
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

    public void spostaDx(){
        viperaManager.spostaDx();
    }

    public void spostaSx(){
        viperaManager.spostaSx();
    }

    public void spostaTop(){
        viperaManager.spostaTop();
    }

    public void spostaDown(){
        viperaManager.spostaDown();
    }
}
