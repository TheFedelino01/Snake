package Snake.game.utility;


import java.io.IOException;
import java.util.concurrent.Semaphore;

public class syncTh {
    private Semaphore prendo;
    private Semaphore genera;


    public syncTh(){
        prendo = new Semaphore(1);
        genera = new Semaphore(0);
    }

    public void aspettoChePrende(){
        try {
            prendo.acquire();
        }catch(InterruptedException e){System.out.println(e.toString());}
    }

    public void dicoCheHoPreso(){
        prendo.release();
    }

    public void aspettoCheGenera(){
        try{
            genera.acquire();
        }catch(InterruptedException e){System.out.println(e.toString());}
    }

    public void dicoCheHoGenerato(){
        genera.release();
    }
}
