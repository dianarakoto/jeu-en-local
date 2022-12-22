package listener;

import game.Boutons;
import game.PlayField;
import game.Traitement;
import network.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MineListener implements MouseListener {
    int x, y;
    PlayField field;

    public MineListener(int x, int y, PlayField field) {
        this.x = x;
        this.y = y;
        this.field = field;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public PlayField getField() {
        return field;
    }

    public void setField(PlayField field) {
        this.field = field;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() instanceof JButton) {
            Boutons bouton = (Boutons) e.getSource();
            new WriteToServer(getField(), bouton);
            // Traitement traiter=new Traitement(bouton, getField());
            // if(SwingUtilities.isRightMouseButton(e)) {
            //     bouton.setBackground(Color.red);
            //     traiter.traitementDroite();
            // }
            // if(SwingUtilities.isLeftMouseButton(e)){
            //     bouton.setBackground(Color.green);
            //     traiter.traitementGauche();
            // }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

//    public void checkBlank(int x, int y){
//        if(!getField().getPlay().getButtons()[y][x].isOpen()){
//            getField().getPlay().getButtons()[y][x].setText(String.valueOf(getField().countMine(x, y)));
//            getField().getPlay().getButtons()[y][x].setOpen(true);
//            if(!getField().hasNeighbourMine(x,y)){
//                if(!getField().hasNeighbourMine(x+1,y)) checkBlank(x+1,y);
//                if(!getField().hasNeighbourMine(x-1,y)) checkBlank(x-1,y);
//                if(!getField().hasNeighbourMine(x,y-1)) checkBlank(x,y-1);
//                if(!getField().hasNeighbourMine(x, y+1)) checkBlank(x,y+1);
//                if(!getField().hasNeighbourMine(x+1,y-1)) checkBlank(x+1,y-1);
//                if(!getField().hasNeighbourMine(x-1,y-1)) checkBlank(x-1,y-1);
//                if(!getField().hasNeighbourMine(x+1,y+1)) checkBlank(x+1,y+1);
//                if(!getField().hasNeighbourMine(x-1,y+1)) checkBlank(x-1,y+1);
//            }
//        }
//    }

}