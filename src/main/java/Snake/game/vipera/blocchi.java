package Snake.game.vipera;

import Snake.game.utility.Directions;

import java.awt.*;
import java.util.Vector;
import Snake.game.gioco;

/**
 @author  Saccani Federico, federico.saccani01@gmail.com
 @version 1.0
 */
/**
 La classe rappresenta tutti i blocchi che compongono la vipera
 */
public class blocchi {
    /** Attributo che rappresenta tutti i blocchi*/
    private Vector<blocco> blocchi = new Vector<blocco>();

    /**
     @brief Costruttore con parametri della classe

     @param startX posizione X iniziale della testa
     @param startY posizione Y iniziale della testa
     */
    public blocchi(int startX, int startY){
        //creo la testa, la testa ha sempre il colore rosso!
        blocchi.add(new blocco(startX,startY, Color.red));
    }

    /**
     @brief Il metodo imposta la direzione della testa della vipera a seconda del parametro passato

     @param dir direzione testa
     */
    public void setDirezioneVipera(Directions dir) {
        prendiTesta().setSguardoRivolto(dir);
        //Se si sovrappone, faccio morire il serpente
        if(controllaSeTestaColpisceCoda()==true){
            gioco.getInstance().setMorto(true);
        }
    }

    /**
     @brief Il metodo controlla se la testa della vipera colpisce un blocco della sua coda
     */
    private boolean controllaSeTestaColpisceCoda(){
        blocco testa = prendiTesta();
        int xtesta = testa.getX();
        int ytesta = testa.getY();

        blocco checkBlocco;

        for(int i=1; i< blocchi.size();i++){
            checkBlocco = blocchi.get(i);
            if(checkBlocco.getX()==xtesta && checkBlocco.getY()==ytesta){

                //Evito che il primo blocco che spawna in corrispondenza della testa, venga
                //considerato come collisione
                if(testa.getHoDistaccato()==true && blocchi.size()!=2) {
                    return true;//Dico che la testa ha colpito un pezzo della coda
                }
            }

        }
        return false;
    }

    /**
     @brief Il metodo ritorna il blocco che corrisponde alla testa della vipera
     */
    private blocco prendiTesta(){
        return blocchi.get(0);
    }

    /**
     @brief Il metodo ritorna l'ultimo blocco che compone la vipera
     */
    private blocco prendiUltimoBlocco(){
        return blocchi.get(blocchi.size()-1);
    }

    /**
     @brief Il metodo aggiunge un blocco in coda alla vipera

     @param coloreBlocco colore del blocco da aggiungere
     */
    public void addBlocco(Color coloreBlocco){
        //Il blocco prende la posizione dell'ultimo blocco
        int xNuovo = dimmiXdelNuovoBlocco();
        int yNuovo = dimmiYdelNuovoBlocco();

        prendiUltimoBlocco().dicoCheHoUnFiglio();//Ora ha un figlio

        //aggiungo un blocco che non e' una testa
        blocchi.add(new blocco(xNuovo,yNuovo,coloreBlocco));


    }


    /*public boolean CollideTestaConCoda(){
        blocco testa = prendiTesta();
        int xTesta = testa.getX();
        int yTexta = testa.getY();

        //CONTROLLA SE LA TESTA E' SOPRA A UN BLOCCO DELLA CODA
        for(int i=1 ;i < blocchi.size();i++){
            if(blocchi.get(i).getX()==xTesta && blocchi.get(i).getY()==yTexta){
                return true;
            }
        }

        return false;
    }*/

    /**
     @brief Il metodo ritorna la posizione X dell'blocco che compone la vipera
     */
    private int dimmiXdelNuovoBlocco(){
        blocco ultimo = prendiUltimoBlocco();
        return ultimo.getX();
    }
    /**
     @brief Il metodo ritorna la posizione Y dell'blocco che compone la vipera
     */
    private int dimmiYdelNuovoBlocco(){
        blocco ultimo = prendiUltimoBlocco();
        return ultimo.getY();
    }

    /**
     @brief Il metodo imposta la posizione X della testa della vipera a seconda del parametro passato

     @param actPosx posizione X
     */
    public void setPosTestaX(int actPosx) {
        prendiTesta().setX(actPosx);
    }

    /**
     @brief Il metodo imposta la posizione Y della testa della vipera a seconda del parametro passato

     @param actPosY posizione Y
     */
    public void setPosTestaY(int actPosY) {
        prendiTesta().setY(actPosY);
    }

    /**
     @brief Il metodo dice ad ogni blocco (ad eccezione della testa) di seguire il blocco davanti

     In questo modo si crea l'effetto snake cioe' che i blocchi della coda seguono il percorso fatto dalla testa
     */
    public void posizionaIBlocchi() {
        blocco stoConsiderando;
        blocco bloccoDavanti;


        for(int i=1; i<blocchi.size();i++){
            stoConsiderando = blocchi.get(i);
            bloccoDavanti = blocchi.get(i-1);

            stoConsiderando.segui(bloccoDavanti.getLastMossa());
        }
    }

    /**
     @brief Il metodo ritorna la posizione X del blocco indicato come parametro

     @param i identificativo del blocco
     */
    public int getXblocco(int i) {
        return blocchi.get(i).getX();
    }

    /**
     @brief Il metodo ritorna la posizione Y del blocco indicato come parametro

     @param i identificativo del blocco
     */
    public int getYblocco(int i) {
        return blocchi.get(i).getY();
    }

    /**
     @brief Il metodo ritorna il colore del blocco indicato come parametro

     @param i identificativo del blocco
     */
    public Color getColoreBlocco(int i) {
        return blocchi.get(i).getColore();
    }

    /**
     @brief Il metodo ritorna true se nella posizione X e Y passata come parametro e' presente un blocco della vipera

     @param x posizione x del blocco
     @param y posizione y del blocco
     */
    public boolean ePresenteUnBlocco(int x, int y) {
        int xBlocco,yBlocco;
        int fggg=0;

        //Se trovo un blocco con x e y == a quelli passati da parametro, ritorno true
        for(int i=0; i<blocchi.size();i++){
            xBlocco=blocchi.get(i).getX();
            yBlocco=blocchi.get(i).getY();
            if(xBlocco==x && yBlocco==y){
                return true;
            }
        }
        return false;
    }

    /**
     @brief Il metodo ritorna il colore dell'ultimo blocco che compone la vipera
     */
    public Color getColoreUltimoBlocco(){
        return prendiUltimoBlocco().getColore();
    }

}
