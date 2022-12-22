package network;

import game.Boutons;
import game.PlayField;

import java.io.*;
import java.util.Vector;

public class WriteToClient{
    Vector<Boutons> button;

    public Vector<Boutons> getButton() {
        return button;
    }

    public void setButton(Vector<Boutons> button) {
        this.button = button;
    }

    public WriteToClient(ObjectOutputStream out, Vector<Boutons> button) {
        this.button = button;
        try{
            out.writeObject(getButton());
            out.flush();
            for(int i=0; i<button.size(); i++){
                System.out.println("x:"+getButton().get(i).getXplace()+"y:"+getButton().get(i).getYplace());
            }
            // getOutput().reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
