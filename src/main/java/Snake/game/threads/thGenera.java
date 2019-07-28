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

        int posMelaX,posMelaY;
        int checkRespawn=0;

        do {
            //Se e' diverso da 0 significa che ho richiamato il do while()
            if(checkRespawn!=0){System.out.println("Mela spawnata in corrispondenza di un blocco... Respawning!");}

            Random rn = new Random();
            posMelaX = rn.nextInt(xMax);

            rn = new Random();
            posMelaY = rn.nextInt(yMax);

            posMelaX = posMelaX-(posMelaX%dimVipera);
            if(posMelaX==0){ posMelaX+=dimVipera; }else if(posMelaX==dimSchermoX){posMelaX-=dimVipera;}//Evito che finisca con un pezzo fuori dello schermo

            posMelaY = posMelaY-(posMelaY%dimVipera);
            if(posMelaY==0){ posMelaY+=dimVipera; }else if(posMelaY==dimSchermoY){posMelaY-=dimVipera;}//Evito che finisca con un pezzo fuori dello schermo



            checkRespawn++;


            //Se non riesco a spawnare la mela per 1000 tentativi, il gioco é finito
            if(checkRespawn==1000){System.out.println(">>>>>>>>GIOCO FINITO!"); return;}

        }while(gameManager.getInstance().ePresenteUnBlocco(posMelaX,posMelaY)==true);//Se ho spawnato la mela in corrispondenza di un blocco, lo rispawno



        System.out.println("Genero mela: "+"X:"+posMelaX+" Y:"+posMelaY);
        gameManager.getInstance().setPosMela(posMelaX, posMelaY);
    }


}
