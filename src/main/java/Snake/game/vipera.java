package Snake.game;

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
        vivo=true;
        actPosX=500;
        actPosY=500;
        dimensione=20;
    }

    public void incX(int quant){
        actPosX+=quant;
    }
    public void incY(int quant){
        actPosY+=quant;
    }



    public int getX() {
        return actPosX;
    }
    public int getY() {
        return actPosY;
    }

    public int getDimensione(){return dimensione;}

}
