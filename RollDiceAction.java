/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package refugeoly;
/**
 *
 * @author Klaud
 */
public class RollDiceAction implements Action{
    Board board;
    Square square;
    Boolean goForward;
    
    public RollDiceAction(Board board,Square square,Boolean goForward){
        this.board = board;
        this.square = square;
        this.goForward = goForward;
    }
    
    @Override
    public void act(Refugee refugee){
        int diceRoll = board.rollDice();
        System.out.println("Rolling the dice again: " + diceRoll);
        System.out.println();

        int squareNumber = refugee.getNumber();
        if (goForward) {             // If true go Forward (The goForward variable is set while making the square)
            squareNumber += diceRoll;
        } else {                     // If false go Backward
            squareNumber -= diceRoll;
        }

        // Update the square field directly
        square = board.getSquare(squareNumber);

        // Move the refugee to the updated square
        refugee.moveTo(square);

    }
}
