package Snake.gui;

public class size {

    private int dimensioneX;
    private int dimensioneY;

    public size(int x, int y){
        dimensioneX = x;
        dimensioneY = y;
    }
    public size(){
        dimensioneX=500;
        dimensioneY=500;
    }

    public int getDimensioneX(){
        return dimensioneX;
    }

    public int getDimensioneY(){
        return dimensioneY;
    }
}
