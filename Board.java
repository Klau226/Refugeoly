/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package refugeoly;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Klaud
 */
public class Board {
    private ArrayList<Square> squares;
    private Random rnd = new Random();

    public Board(){
        this.squares = new ArrayList<>();
    }
    
    public void addSquare(Square squares){
        this.squares.add(squares);
    }
    
    public Square getSquare(int number){
        Square foundSquare = null;
        for (Square sq : squares) {
            if (sq.getNumber() == number) {
                foundSquare = sq;
                return foundSquare; // Found the square with the specified number, exit the loop
            }
        }
        if (foundSquare == null) {
            System.out.println("No such number");
        }
        return foundSquare;
    }
    
    public int rollDice(){
        int k;
        k = rnd.nextInt(6) + 1;
        return k;
    }
}

