package network;

import game.Joueur;
import game.Mines;
import game.PlayField;

import java.io.*;
import java.net.Socket;

public class Client{
    Socket s;

    public Socket getS() {
        return s;
    }

    public Client(Socket s){
        this.s=s;
    }

    public static void main(String[] args)  {
        try {
            Socket s=new Socket("localhost",6666);
            ObjectInputStream objet=new ObjectInputStream(s.getInputStream());
            Mines mines= (Mines) objet.readObject();
            PlayField playYard=new PlayField(mines,s);
            playYard.setVisible(true);
            while(true){
                playYard.run();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
