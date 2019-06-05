
import Snake.game.commands;
import Snake.game.gameManager;
import Snake.game.threads.thReader;
import Snake.gui.ManagerGUI;
import processing.core.PApplet;

public class main extends PApplet {


    public static void main (String[] args) {
        PApplet.main(new String[]{"main"});
    }
    
    public main() {
        System.out.println("Starting application...");
        
        ManagerGUI.getInstance().setup(1000, 1000, this);
        thStarts();
    }

    private static void thStarts(){
        thReader thReader = new thReader();
        thReader.start();
    }

    public void settings() {
        size(ManagerGUI.getInstance().getDimensioneX(), ManagerGUI.getInstance().getDimensioneY());
    }



    public void setup() {
        noStroke();
        frameRate(100);
        ellipseMode(RADIUS);
    }


    public void draw() {
        ManagerGUI.getInstance().draw();
    }
    
    @Override
    public void keyPressed() {
        Character tasto = key;
        commands.getInstance().setKeyDown(tasto);
    }

}
