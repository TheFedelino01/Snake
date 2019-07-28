package Snake.game.threads;

import Snake.game.gioco;

public class thControllaMela extends Thread {

    public thControllaMela(){

    }

    @Override
    public void run(){
        while(!isInterrupted()){
            int xVipera,yVipera;
            int xMela, yMela;

            //Se cerca la mela, controllo se l'ha colliso
            if(gioco.getInstance().isFindingMela()==true){
                xVipera = gioco.getInstance().getActX();
                yVipera = gioco.getInstance().getActY();

                xMela = gioco.getInstance().getPosMelaX();
                yMela = gioco.getInstance().getPosMelaY();
//txt
                //Se la vipera e' sopra la mela
                if(isViperaOverMela(xVipera,yVipera,xMela,yMela)){
                    //Mela presa
                    gioco.getInstance().melaPresa();
                    gioco.getInstance().setFindingMela(false);
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
