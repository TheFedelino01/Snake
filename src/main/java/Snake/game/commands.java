/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snake.game;

/**
 *
 * @author Federico Saccani
 */
public class commands {
    private Character keyDown;
    
    private static commands ourInstance = new commands();
    public static commands getInstance() {
        return ourInstance;
    }

    private commands(){
        keyDown=' ';
    }
    
    public void setKeyDown(Character car){
        this.keyDown=car;
        keyDown = Character.toUpperCase(keyDown);//Metto in maiuscolo
    }

    public Character getKeyDown() {
        return keyDown;
    }
}
