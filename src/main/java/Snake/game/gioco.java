package Snake.game;

import Snake.game.utility.Directions;
import Snake.game.utility.gameManager;
import Snake.game.utility.syncTh;
import Snake.gui.ManagerGUI;
import processing.core.PApplet;

import java.awt.*;

public class gioco {
    private syncTh syncTh;
    private gameManager gameManager;
    private ManagerGUI managerGui;

    private static gioco ourInstance = new gioco();
    public static gioco getInstance() {
        return ourInstance;
    }

    private gioco(){

    }

    public void setup(int dimensioneX, int dimensioneY, PApplet tavola, boolean colorato){
        syncTh = new syncTh();
        gameManager = new gameManager(colorato);
        managerGui = new ManagerGUI(dimensioneX,dimensioneY,tavola);
    }


    public int getDimensioneX(){
        return managerGui.getDimensioneX();
    }

    public int getDimensioneY(){
        return managerGui.getDimensioneY();
    }

    public void draw(){
        managerGui.draw();
    }

    public boolean isMorto(){
        return gameManager.isMorto();
    }

    public int getPosMelaX(){
        return gameManager.getPosMelaX();
    }
    public int getPosMelaY(){
        return gameManager.getPosMelaY();
    }

    public int getDimensione(){
        return gameManager.getDimensione();
    }
    public Color getColoreMela(){
        return gameManager.getColoreMela();
    }

    public void respawn(){
        gameManager.respawn();
    }

    public int getNumMelePrese(){
        return gameManager.getNumMelePrese();
    }

    public int posXblocco(int i){
        return gameManager.posXblocco(i);
    }
    public int posYblocco(int i){
        return gameManager.posYblocco(i);
    }

    public boolean getSerpenteColorato(){
        return gameManager.getSerpenteColorato();
    }

    public Color getColoreUltimoBlocco(){
        return gameManager.getColoreUltimoBlocco();
    }
    public void setMorto(boolean val){
        gameManager.setMorto(val);
    }
    public void setDirezioneVipera(Directions c){
        gameManager.setDirezioneVipera(c);
    }
    public void sposta(Directions c){
        gameManager.sposta(c);
    }

    public boolean ePresenteUnBlocco(int x, int y){
        return gameManager.ePresenteUnBlocco(x,y);
    }
    public void setPosMela(int x,int y){
        gameManager.setPosMela(x,y);
    }
    public boolean isFindingMela() {
        return gameManager.isFindingMela();
    }
    public void setFindingMela(boolean v){
        gameManager.setFindingMela(v);
    }

    public void melaPresa(){
        gameManager.melaPresa();
    }
    public int getActX(){
        return gameManager.getActX();
    }
    public int getActY(){
        return gameManager.getActY();
    }
}
