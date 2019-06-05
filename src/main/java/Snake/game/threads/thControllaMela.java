package Snake.game.threads;

import Snake.game.gameManager;

public class thControllaMela extends Thread {

    public thControllaMela(){

    }

    @Override
    public void run(){
        while(!isInterrupted()){
            int xVipera,yVipera;
            int xMela, yMela;

            //Se cerca la mela, controllo se l'ha colliso
            if(gameManager.getInstance().isFindingMela()==true){
                xVipera = gameManager.getInstance().getActX();
                yVipera = gameManager.getInstance().getActY();

                xMela = gameManager.getInstance().getPosMelaX();
                yMela = gameManager.getInstance().getPosMelaY();

                //Se la vipera e' sopra la mela
                if(isViperaOverMela(xVipera,yVipera,xMela,yMela)){
                    gameManager.getInstance().setFindingMela(false);
                }
            }
        }
    }

    private boolean isViperaOverMela(int xV,int yV,int xM,int yM){
        if(xV==xM && yV == yM){
            return true;
        }
        return false;

    }
}
