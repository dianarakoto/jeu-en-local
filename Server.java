package network;

import game.*;
import game.PlayField;

import java.util.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static ArrayList<Client> allCLients;

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            allCLients=new ArrayList<Client>();
            Mines mine = new Mines();
            int player=0;
            while (player<2) {
                Socket s = ss.accept();
                allCLients.add(new Client(s));
                ObjectOutputStream objet = new ObjectOutputStream(new PrintStream(s.getOutputStream()));
                objet.writeObject(mine);
                objet.flush();
                DataOutputStream output = new DataOutputStream(s.getOutputStream());
                output.writeInt(player);
                output.flush();
                System.out.println("The player "+player+" has connected");
                player++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        System.out.println("No longer accepting players");
        Vector<Boutons> allBoutons=new Vector<>();
        while(true){
            System.out.println("In game");
            try{
                for (int i=0; i<allCLients.size(); i++){
                    ReadFromClient read=new ReadFromClient(allCLients.get(i).getS().getInputStream());
                    allBoutons.add(read.getb());
                    ObjectOutputStream ob=new ObjectOutputStream(allCLients.get(i).getS().getOutputStream());
                    new WriteToClient(ob, allBoutons);
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            } 
        }
        
    }
}
