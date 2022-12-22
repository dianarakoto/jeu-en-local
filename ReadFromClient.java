package network;

import game.*;

import java.io.*;

public class ReadFromClient{
    InputStream input;
    Boutons b;

    public InputStream getInput() {
        return input;
    }

    public void setInput(InputStream input) {
        this.input = input;
    }

    public Boutons getb() {
        return b;
    }

    public void setb(Boutons b) {
        this.b = b;
    }

    public ReadFromClient(InputStream in) {
        setInput(in);
        try{
            ObjectInputStream inputS=new ObjectInputStream(getInput());
            b=(Boutons) inputS.readObject();
            setb(b);
            System.out.println(getb().getXplace());
        }
        catch(IOException e){ e.printStackTrace(); }
        catch(ClassNotFoundException c){ c.printStackTrace(); }
    }

}
