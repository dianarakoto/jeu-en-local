package network;

import game.Boutons;
import game.PlayField;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteToServer{
    ObjectOutputStream output;
    PlayField field;
    Boutons button;

    public Boutons getButton() {
        return button;
    }

    public void setButton(Boutons button) {
        this.button = button;
    }

    public PlayField getField() {
        return field;
    }

    public void setField(PlayField field) {
        this.field = field;
    }

    public ObjectOutputStream getOutput() {
        return output;
    }

    public void setOutput(ObjectOutputStream output) {
        this.output = output;
    }

    public WriteToServer(PlayField field, Boutons button) {
        this.field = field;
        this.button = button;
        try{
            ObjectOutputStream ob=new ObjectOutputStream(getField().getS().getOutputStream());
            setOutput(ob);
            ob.writeObject(getButton());
            ob.flush();
            // getOutput().reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(getButton().getXplace());
    }
}
