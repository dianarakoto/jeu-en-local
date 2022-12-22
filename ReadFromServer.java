package network;

import game.*;

import java.io.*;
import java.util.Vector;

public class ReadFromServer{
    Vector<Boutons> b;
    public Vector<Boutons> getb() {
        return b;
    }

    public void setb(Vector<Boutons> b) {
        this.b = b;
    }

    public ReadFromServer(ObjectInputStream in) {
        try{
            b=(Vector<Boutons>) in.readObject();
            setb(b);
        }
        catch(IOException e){ e.printStackTrace(); }
        catch(ClassNotFoundException c){ c.printStackTrace(); }
    }

}
