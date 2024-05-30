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
public class Lose implements Action{
    
    private ArrayList<Refugee> players; // Changed variable name to plural for better clarity

    public Lose() {
        this.players = new ArrayList<>();
    }

    public void addLosingPlayer(Refugee player) {
        this.players.add(player);
    }

    @Override
    public void act(Refugee refugee) {
        System.out.println("You Lost. What a shame");
    }

    public void getLosers() {
        System.out.println("Losers:");
        for (Refugee player : players) {
            System.out.println(player.getName());
        }
    
    }
    
}
