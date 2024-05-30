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
public class Win implements Action{
    private ArrayList<Refugee> players; 

    public Win() {
        this.players = new ArrayList<>();
    }

    public void addWinningPlayer(Refugee player) {
        this.players.add(player);
    }

    @Override
    public void act(Refugee refugee) {
        System.out.println("You won. Congratulations");
    }

    public void getWinners() {
        System.out.println("Winners:");
        for (Refugee player : players) {
            System.out.println(player.getName());
        }
    }
    
}
