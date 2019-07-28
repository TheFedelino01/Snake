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

    public void setKeyDown(Character car, int keyCode){
        car = Character.toUpperCase(car);

        Character carTmp = convertToWASD(keyCode);
        if(carTmp!=null){
            car = carTmp;//Se e' un arrow, faccio assumere il valore altrimenti non faccio ninete
        }

        //Deve essere una lettera
        if (car == 'A' || car == 'W' || car == 'S' || car == 'D') {
            //Se vuole tornare indietro, blocco la mossa
            if(isDoingAMossaProibita(car)==false) {
                this.keyDown = car;
            }
        }
    }

    public Character getKeyDown() {
        return keyDown;
    }
    
    public void clearKeyDown(){
        keyDown=' ';
    }

    private Character convertToWASD(int keyCode){
        Character ris=null;

        switch(keyCode){
            case 38:
                ris='W';
                break;
            case 40:
                ris='S';
                break;
            case 37:
                ris='A';
                break;
            case 39:
                ris='D';
                break;

            default:
                ris=null;
                break;//Non e' un Arrow e non lo converto a WASD
        }

        return ris;
    }

    private boolean isDoingAMossaProibita(Character car){
        //Inversione orizzontale
        if((keyDown=='A' && car=='D')||(keyDown=='D' && car=='A')){
            return true;
        }else if((keyDown=='W' && car=='S')||(keyDown=='S' && car=='W')){//Inversione verticale
            return true;
        }

        return false;

    }

}
