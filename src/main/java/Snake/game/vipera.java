package Snake.game;

import Snake.gui.ManagerGUI;

public class vipera {
    private int lunghezza;
    private boolean vivo;

    private int actPosX, actPosY;
    private int dimensione;

    private static vipera ourInstance = new vipera();

    public static vipera getInstance() {
        return ourInstance;
    }

    private vipera() {
        lunghezza=1;
        actPosX=500;
        actPosY=500;
        dimensione=20;
    }

    public void incX(int quant){
        int tmp = actPosX+quant;
        
        if(tmp>0 && tmp<ManagerGUI.getInstance().getDimensioneX()){
            actPosX= tmp;
        }else{
            gameManager.getInstance().setMorto(true);
            System.out.println("USCITO LATO SX o DX");
        }
    }
    public void incY(int quant){
        int tmp = actPosY+quant;
        
        if(tmp>0 && tmp<ManagerGUI.getInstance().getDimensioneY()){
            actPosY= tmp;
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
        actPosX=500;
        actPosY=500;
    }

}
