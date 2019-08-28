package Snake.game.threads;

import Snake.game.gioco;
/**
 @author  Saccani Federico, federico.saccani01@gmail.com
 @version 1.0
 */
/**
 La classe corrisponde al thread incaricato nel controllare se la mela viene catturata
 */
public class thControllaMela extends Thread {

    /**
     @brief Costruttore senza parametri della classe
     */
    public thControllaMela(){

    }

    /**
     @brief Metodo run del thread

     Se il serpente sta cercando la mela, controlla se la posizione della mela e' uguale alla posizione della testa della vipera.
     In tal caso la mela viene considerata come catturata.
     */
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

                //Se la vipera e' sopra la mela
                if(isViperaOverMela(xVipera,yVipera,xMela,yMela)){
                    //Mela presa
                    gioco.getInstance().melaPresa();
                    gioco.getInstance().setFindingMela(false);
                }
            }
        }
    }
    /**
     @brief Il metodo controlla se le due X e le due Y passate come parametro sono uguali
     */
    private boolean isViperaOverMela(int xV,int yV,int xM,int yM){
        if(xV==xM && yV == yM){
            return true;
        }
        return false;

    }
}
