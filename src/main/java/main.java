import Snake.game.commands;
import Snake.game.gameManager;
import Snake.game.threads.thReader;
import Snake.gui.ManagerGUI;
import processing.core.PApplet;

public class main extends PApplet {

    private ManagerGUI managerGUI = new ManagerGUI(1000,1000,this);

    public static void main (String[] args) {
        PApplet.main(new String[]{"main"});
        System.out.println("Starting application...");

        thStarts();

    }

    private static void thStarts(){
        thReader thReader = new thReader();
        thReader.start();
    }

    public void settings() {
        size(managerGUI.getDimensioneX(), managerGUI.getDimensioneY());
    }



    public void setup() {
        noStroke();
        frameRate(100);
        ellipseMode(RADIUS);
    }


    public void draw() {
        managerGUI.draw();
    }
    
    @Override
    public void keyPressed() {
        Character tasto = key;
        commands.getInstance().setKeyDown(tasto);
    }

}
