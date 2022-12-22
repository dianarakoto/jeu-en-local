package game;

import java.io.Serializable;

public class Mines implements Serializable{
    int[] Xbombes;
    int[] Ybombes;

    public int[] getXbombes() {
        return Xbombes;
    }

    public void setXbombes(int[] xbombes) {
        Xbombes = xbombes;
    }

    public int[] getYbombes() {
        return Ybombes;
    }

    public void setYbombes(int[] ybombes) {
        Ybombes = ybombes;
    }

    public Mines(){
        int[] x=new int[10];
        for (int i = 0; i < 10; i++) {
            x[i]= (int) (Math.random()*9)+1;
//            x[i]=i;
        }
        this.Xbombes=x;
        int[] y=new int[10];
        for (int i = 0; i < 10; i++) {
            y[i]= (int) (Math.random()*9)+1;
//            y[i]=i;
        }
        this.Ybombes=y;
    }
}
