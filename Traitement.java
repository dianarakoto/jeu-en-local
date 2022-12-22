package game;

import network.*;

import java.io.*;

public class Traitement {
    Boutons button;
    PlayField play;
    public Boutons getButton() {
        return button;
    }

    public void setButton(Boutons button) {
        this.button = button;
    }

    public PlayField getPlay() {
        return play;
    }

    public void setPlay(PlayField play) {
        this.play = play;
    }

    public Traitement(Boutons bouton, PlayField field){
        this.button=bouton;
        this.play=field;
    }

    public void traitementDroite(){
        if(!play.getPlay().getButtons()[getButton().getYplace()][getButton().getXplace()].isOpen()){
            if(play.checkMine(button.getXplace(), button.getYplace())){
                play.getPlay().getButtons()[getButton().getYplace()][getButton().getXplace()].setOpen(true);
                play.getPlayer().setScore(play.getPlayer().getScore()+10);
            }
            else{
                play.getPlay().getButtons()[getButton().getYplace()][getButton().getXplace()].setOpen(true);
                play.getPlayer().setScore(play.getPlayer().getScore()+1);
            }
        }
    }

    public void traitementGauche(){
        if(!play.getPlay().getButtons()[getButton().getYplace()][getButton().getXplace()].isOpen()){
            if(play.checkMine(button.getXplace(), button.getYplace())){
                play.getPlay().getButtons()[getButton().getYplace()][getButton().getXplace()].setOpen(true);
                play.getPlayer().setScore(play.getPlayer().getScore()-12);
            }
            if(!play.checkMine(button.getXplace(), button.getYplace())){
                play.getPlay().getButtons()[getButton().getYplace()][getButton().getXplace()].setOpen(true);
                play.getPlayer().setScore(play.getPlayer().getScore()+6);
            }
        }
    }
}
