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
        if(controllaSePossibile(car)==true) {
            this.keyDown = car;
            keyDown = Character.toUpperCase(keyDown);//Metto in maiuscolo
        }
        //else il tasto che ha premuto non è corretto
        //quindi non modifico il tasto attuale
    }

    private boolean controllaSePossibile(Character c){
        c = Character.toUpperCase(c);
        if(c=='A' || c=='W'|| c=='S'|| c=='D'){
            return true;
        }
        return false;
    }

    public Character getKeyDown() {
        return keyDown;
    }
    
    public void clearKeyDown(){
        keyDown=' ';
    }
}
