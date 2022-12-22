package game;

import javax.swing.*;
import java.io.Serializable;

public class Boutons extends JButton implements Serializable{
    Boolean open=false;
    int Xplace, Yplace;


    public int getXplace() {
        return Xplace;
    }

    public void setXplace(int xplace) {
        Xplace = xplace;
    }

    public int getYplace() {
        return Yplace;
    }

    public void setYplace(int yplace) {
        Yplace = yplace;
    }

    public Boolean isOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}
