package game;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;

public class PlayField extends JFrame implements Runnable{
    Mines mine;
    Playable play;
    Joueur player;
    Socket s;

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }

    public Joueur getPlayer() {
        return player;
    }

    public void setPlayer(Joueur player) {
        this.player = player;
    }

    public Playable getPlay() {
        return play;
    }

    public void setPlay(Playable play) {
        this.play = play;
    }

    public Mines getMine() {
        return mine;
    }

    public void setMine(Mines mine) {
        this.mine = mine;
    }

    public PlayField(Mines mine, Socket s) {
        this.setS(s);
        this.mine = mine;

        setTitle("MineSweeper");
        
        try{
            DataInputStream in=new DataInputStream(getS().getInputStream());
            Joueur player=new Joueur(in.readInt());
            this.setPlayer(player);
        } catch (IOException ex){
            ex.printStackTrace();
        }

        setSize(1000,500);
        setDefaultCloseOperation(3);
        setLayout(new GridLayout(0,2));
        setResizable(false);
        Playable playing=new Playable(this);
        this.setPlay(playing);
        add(playing);
        setDefaultCloseOperation(3);
        // setVisible(true);
    }

    @Override
    public void run(){
    
        getPlay().traiterServerInformation();
    } 

    public boolean hasNeighbourMine(int x, int y){
        if(countMine(x,y)==0) return !true;
        return !false;
    }

    public Boolean checkMine(int x, int y){    ///Coordonnes
        for (int i = 0; i < getMine().getYbombes().length; i++) {
            if(getMine().getXbombes()[i]==x && getMine().getYbombes()[i]==y){
                return true;
            }
        }
        return false;
    }

    public Boolean checkMineRight(int x, int y){
        x++;
        if(checkMine(x, y) && x<=9){
            return true;
        }
        return false;
    }

    public Boolean checkMineLeft(int x, int y){
        x--;
        if(checkMine(x, y) && x>0){
            return true;
        }
        return false;
    }

    public Boolean checkMineDown(int x, int y){
        y++;
        if(checkMine(x, y) && y<=9){
            return true;
        }
        return false;
    }

    public Boolean checkMineUp(int x, int y){
        y--;
        if(checkMine(x, y) && y>0){
            return true;
        }
        return false;
    }

    public Boolean checkMineDiagDR(int x, int y){
        x++;
        y++;
        if(checkMine(x, y) && x<=9 && y<=9){
            return true;
        }
        return false;
    }

    public Boolean checkMineDiagUR(int x, int y){
        x++;
        y--;
        if(checkMine(x, y) && x<=9 && y>0){
            return true;
        }
        return false;
    }

    public Boolean checkMineDiagUL(int x, int y){
        x--;
        y--;
        if(checkMine(x, y) && x>0 && y>0){
            return true;
        }
        return false;
    }

    public Boolean checkMineDiagDL(int x, int y){
        x--;
        y++;
        if(checkMine(x, y) && x>0 && y<=9){
            return true;
        }
        return false;
    }

    public int countMine(int x, int y){
        int mine=0;
        if(checkMineRight(x,y)) mine++;
        if(checkMineLeft(x,y)) mine++;
        if(checkMineDown(x,y)) mine++;
        if(checkMineUp(x, y)) mine++;
        if(checkMineDiagDR(x,y)) mine++;
        if(checkMineDiagUR(x,y)) mine++;
        if(checkMineDiagUL(x,y)) mine++;
        if(checkMineDiagDL(x,y)) mine++;
        return mine;
    }
}
