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

        Random rn = new Random();
        int posMelaX = rn.nextInt(xMax);
        int posMelaY = rn.nextInt(yMax);

        gameManager.getInstance().setPosMela(posMelaX, posMelaY);

    }
}
