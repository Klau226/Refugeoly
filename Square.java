/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package refugeoly;

import java.util.ArrayList;

/**
 *
 * @author Klaud
 */
public class Square {
    private int number;
    private String text;
    private String description;
    private Board board;                        // Not used
    private ArrayList<Action> actions;
    
    public Square(){
        
    }
    
    public Square(int number,String text,String description,Board board){
        this.number = number;
        this.text = text;
        this.description = description;
        this.board = board;
        this.actions = new ArrayList<>();
    }
    
    public int getNumber(){
        return this.number;
    }
    
    
    public String getText(){                    
        return this.text;
    }
    
    public String getDescription(){             
        return this.description;
    }
    
    public void addAction(Action actions){
        this.actions.add(actions);
    }
    
    public ArrayList<Action> getActions() {             
        return actions;
    }
    
    public void act(Refugee refugee){
        for (Action action : actions) {
            action.act(refugee);
        }
    }
}


