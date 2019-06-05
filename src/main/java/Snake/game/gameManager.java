package Snake.game;

public class gameManager {

    private viperaManager viperaManager;
    private boolean morto;
    
    private static gameManager ourInstance = new gameManager();
    public static gameManager getInstance() {
        return ourInstance;
    }

    private gameManager(){
        viperaManager = new viperaManager();
        morto=false;
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
    
    

    
}
