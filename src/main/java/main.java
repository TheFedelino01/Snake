
import Snake.game.utility.commands;
import Snake.game.gioco;
import Snake.game.threads.thControllaMela;
import Snake.game.threads.thGenera;
import Snake.game.threads.thReader;
import processing.core.PApplet;
/**
 @author  Saccani Federico, federico.saccani01@gmail.com
 @version 1.0
 */

/**
Main del progetto relativo al gioco Snake
 */
public class main extends PApplet {

    /** Attributo che indentifica la lentezza di movimento del serpente in millisecondi */
    private static int lentezza=100;
    /** Larghezza dello schermo */
    private static int larghezza=1500;
    /** Altezza dello schermo*/
    private static int altezza=1000;
    /** Attributo che permette se true di far assumere al serpente colori differenti a seconda del colore dell'ultima mela presa*/
    private boolean serpenteColorato=false;

    /**
     @brief Il metodo inizializza il PApplet
     */
    public static void main (String[] args) {
        PApplet.main(new String[]{"main"});
    }

    /**
     @brief Il metodo imposta le classi Manager a seconda dei valori degli attributi, di seguito avvia tutti i threads
     */
    public main() {
        System.out.println("Starting application...");
        gioco.getInstance().setup(larghezza, altezza, this,serpenteColorato);

        thStarts();
    }

    /**
     @brief Metodo che permette di avviare tutti i threads necessari per il funzionamento dell'applicazione

     I threads avviati sono: thReader, thGenera e thControlla
     */
    private static void thStarts(){
        thReader thReader = new thReader(lentezza);
        thGenera thGenera = new thGenera();
        thControllaMela thControlla = new thControllaMela();

        thReader.start();
        thGenera.start();
        thControlla.start();
    }

    /**
     @brief Il metodo imposta la dimensione della finestra di gioco
     */
    public void settings() {
        size(gioco.getInstance().getDimensioneX(), gioco.getInstance().getDimensioneY()+100);
    }


    /**
     @brief Metodo che imposta il framaRate e la sagoma delle figure
     */
    public void setup() {
        noStroke();
        frameRate(1000);
        ellipseMode(RADIUS);
    }

    /**
     @brief Il metodo permette di disegnare tutti gli elementi del gioco
     */
    public void draw() {
        gioco.getInstance().draw();
    }

    /**
     @brief Il metodo, alla pressione di un tasto, salva il carattere premuto nella classe commands
     */
    @Override
    public void keyPressed() {
        Character tasto = key;
        commands.getInstance().setKeyDown(tasto,keyCode);

    }



}
