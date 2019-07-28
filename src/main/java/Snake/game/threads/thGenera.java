package Snake.game.threads;

import Snake.game.gioco;

import java.util.Random;

public class thGenera extends Thread {


    public thGenera(){

    }

    @Override
    public void run(){
        while(!isInterrupted()){

            //if(gioco.getInstance().isFindingMela()==false){
                //Ha preso la mela e quindi ora la rigenero
            gioco.getInstance().aspettoChePrende();
                generaPosizione();
            gioco.getInstance().dicoCheHoGenerato();
                //gioco.getInstance().setFindingMela(true);

                //gioco.getInstance().dicoCheHoGenerato();
            //}

            //else sta ancora cercando la mela
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void generaPosizione(){
        int xMax = gioco.getInstance().getDimensioneX();
        int yMax = gioco.getInstance().getDimensioneY();

        //Utilizzati per controlli spawn
        int dimVipera = gioco.getInstance().getDimensione();
        int dimSchermoX = gioco.getInstance().getDimensioneX();
        int dimSchermoY = gioco.getInstance().getDimensioneY();

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

        }while(gioco.getInstance().ePresenteUnBlocco(posMelaX,posMelaY)==true);//Se ho spawnato la mela in corrispondenza di un blocco, lo rispawno



        System.out.println("Genero mela: "+"X:"+posMelaX+" Y:"+posMelaY);
        gioco.getInstance().setPosMela(posMelaX, posMelaY);
    }


}
