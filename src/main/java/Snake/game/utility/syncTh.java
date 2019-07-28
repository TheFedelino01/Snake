package Snake.game.utility;


import java.io.IOException;
import java.util.concurrent.Semaphore;

public class syncTh {
    private Semaphore prendo;
    private Semaphore genero;

    public syncTh(){
        restart();
    }

    public void aspettoChePrende(){
        try {

            prendo.acquire();

            msg();
        }catch(InterruptedException e){System.out.println(e.toString());}
    }

    public void dicoCheHoPreso(){

        prendo.release();
        msg();
    }

    public void aspettoCheGenera(){
        try {

            genero.acquire();
            msg();
        }catch(InterruptedException e){System.out.println(e.toString());}
    }

    public void dicoCheHoGenerato(){

        genero.release();
        msg();
    }

    public void msg(){
        System.out.println("PRENDO: "+prendo.toString()+"\n GENERO: "+genero.toString());
    }

    public void restart() {
        prendo = new Semaphore(1);
        genero = new Semaphore(0);
    }
}
