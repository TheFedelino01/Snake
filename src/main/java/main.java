
import Snake.game.commands;
import Snake.game.gameManager;
import Snake.game.threads.thControllaMela;
import Snake.game.threads.thGenera;
import Snake.game.threads.thReader;
import Snake.gui.ManagerGUI;
import javafx.scene.input.KeyCode;
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
    private static int larghezza=2000;
    /** Altezza dello schermo*/
    private static int altezza=1500;
    /** Attributo che permette se true di far assumere al serpente colori differenti a seconda del colore dell'ultima mela presa*/
    private boolean serpenteColorato=false;

    /**
     @brief Il metodo inizializza il PApplet
     */
    public static void main (String[] args) {
        PApplet.main(new String[]{"main"});
    }
//txt
    /**
     @brief Il metodo imposta le classi Manager a seconda dei valori degli attributi, di seguito avvia tutti i threads
     */
    public main() {
        System.out.println("Starting application...");
        
        ManagerGUI.getInstance().setup(larghezza, altezza, this);
        gameManager.getInstance().setup(serpenteColorato);
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

        thControlla.start();
        thReader.start();
        thGenera.start();

    }

    /**
     @brief Il metodo imposta la dimensione della finestra di gioco
     */
    public void settings() {
        size(ManagerGUI.getInstance().getDimensioneX(), ManagerGUI.getInstance().getDimensioneY()+100);
    }


    /**
     @brief Metodo che imposta il framaRate e la sagoma delle figure
     */
    public void setup() {
        noStroke();
        frameRate(200);
        ellipseMode(RADIUS);
    }

    /**
     @brief Il metodo permette di disegnare tutti gli elementi del gioco
     */
    public void draw() {
        ManagerGUI.getInstance().draw();
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
