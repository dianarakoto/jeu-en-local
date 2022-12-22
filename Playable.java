package game;

import listener.MineListener;
import network.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Playable extends JPanel {
    PlayField field;
    Boutons[][] buttons;

    public Boutons[][] getButtons() {
        return buttons;
    }

    public Playable(PlayField field) {

        this.field = field;
        setSize(500,500);
        setLayout(new GridLayout(10,10));
        Boutons[][] bouton=new Boutons[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                bouton[i][j]=new Boutons();
                bouton[i][j].setXplace(j);
                bouton[i][j].setYplace(i);
                bouton[i][j].addMouseListener(new MineListener(i,j,field));
                add(bouton[i][j]);
            }
        }
        this.buttons=bouton;
    }
    public void paint(Graphics g){
        super.paint(g);
    }

    public void update(){
        for (int i = 0; i < getButtons().length; i++) {
            for (int j = 0; j < getButtons()[i].length; j++) {
                if (getButtons()[i][j].isOpen() && !getField().checkMine(i,j)){
                    getButtons()[i][j].setText(String.valueOf(getField().countMine(i, j)));
                }
                if (getButtons()[i][j].isOpen() && getField().checkMine(i,j)){
                    getButtons()[i][j].setText("X");
                }
            }
        }
    }

    public void traiterServerInformation(){
        try{
            ObjectInputStream input=new ObjectInputStream(field.getS().getInputStream());
            ReadFromServer read= new ReadFromServer(input);
           for(int i=0; i<read.getb().size(); i++){
                int xFromServer=read.getb().get(i).getXplace();
                int yFromServer=read.getb().get(i).getYplace();
                int xfromClient=this.getButtons()[yFromServer][xFromServer].getXplace();
                int yfromClient=this.getButtons()[yFromServer][xFromServer].getYplace();
                if(xFromServer==xfromClient && yFromServer==yfromClient){
                    this.getButtons()[yFromServer][xFromServer].setOpen(true);
                    this.update();
                }
           }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public PlayField getField() {
        return field;
    }

    public void setField(PlayField field) {
        this.field = field;
    }
}
