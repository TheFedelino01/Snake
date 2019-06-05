package Snake.game.threads;

import Snake.game.gameManager;
import Snake.gui.ManagerGUI;

import java.util.Random;

public class thGenera extends Thread {


    public thGenera(){

    }

    @Override
    public void run(){
        while(!isInterrupted()){
            if(gameManager.getInstance().isFindingMela()==false){
                //Ha preso la mela e quindi ora la rigenero
                generaPosizione();
                gameManager.getInstance().setFindingMela(true);
            }

            //else sta ancora cercando la mela
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void generaPosizione(){
        int xMax = ManagerGUI.getInstance().getDimensioneX();
        int yMax = ManagerGUI.getInstance().getDimensioneY();

        //Utilizzati per controlli spawn
        int dimVipera = gameManager.getInstance().getDimensione();
        int dimSchermoX = ManagerGUI.getInstance().getDimensioneX();
        int dimSchermoY = ManagerGUI.getInstance().getDimensioneY();


        Random rn = new Random();
        int posMelaX = rn.nextInt(xMax);

        rn = new Random();
        int posMelaY = rn.nextInt(yMax);

        System.out.println(posMelaX+" "+posMelaY);

        posMelaX = posMelaX-(posMelaX%dimVipera);
        if(posMelaX==0){ posMelaX+=dimVipera; }else if(posMelaX==dimSchermoX){posMelaX-=dimVipera;}//Evito che finisca con un pezzo fuori dello schermo

        posMelaY = posMelaY-(posMelaY%dimVipera);
        if(posMelaY==0){ posMelaY+=dimVipera; }else if(posMelaY==dimSchermoY){posMelaY-=dimVipera;}//Evito che finisca con un pezzo fuori dello schermo

        System.out.println(posMelaX+" "+posMelaY);
        gameManager.getInstance().setPosMela(posMelaX, posMelaY);

    }
}
