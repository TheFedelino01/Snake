
import Snake.game.commands;
import Snake.game.gameManager;
import Snake.game.threads.thControllaMela;
import Snake.game.threads.thGenera;
import Snake.game.threads.thReader;
import Snake.gui.ManagerGUI;
import javafx.scene.input.KeyCode;
import processing.core.PApplet;

public class main extends PApplet {

    private static int lentezza=100;
    private static int larghezza=1500;
    private static int altezza=900;
    private boolean serpenteColorato=true;

    public static void main (String[] args) {
        PApplet.main(new String[]{"main"});
    }
    
    public main() {
        System.out.println("Starting application...");
        
        ManagerGUI.getInstance().setup(larghezza, altezza, this);
        gameManager.getInstance().setup(serpenteColorato);
        thStarts();
    }

    private static void thStarts(){
        thReader thReader = new thReader(lentezza);
        thGenera thGenera = new thGenera();
        thControllaMela thControlla = new thControllaMela();

        thReader.start();
        thGenera.start();
        thControlla.start();
    }

    public void settings() {
        size(ManagerGUI.getInstance().getDimensioneX(), ManagerGUI.getInstance().getDimensioneY()+100);
    }



    public void setup() {
        noStroke();
        frameRate(200);
        ellipseMode(RADIUS);
    }


    public void draw() {
        ManagerGUI.getInstance().draw();
    }
    
    @Override
    public void keyPressed() {
        Character tasto = key;
        commands.getInstance().setKeyDown(tasto,keyCode);

    }



}
