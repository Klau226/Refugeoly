/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package refugeoly;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Klaud
 */
public class Refugeoly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);
        game.initiazileBoard();
        System.out.println("Welcome to Refugeoly");
        System.out.println("How many players are you?");

        Scanner input = new Scanner(System.in);
        int playerNumber = 0;
        do {
            try {       // try-catch if the input is not a number
                System.out.println("Enter the number of players (1-4):");
                playerNumber = input.nextInt();

                if (playerNumber < 1 || playerNumber > 4) {
                    System.out.println("The game is played by 1-4 players. Make sure that you inserted the right number");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                input.nextLine();           // Consuming the invalid input to avoid an infinite loop
            }
        } while (playerNumber < 1 || playerNumber > 4);

        input.nextLine();                   // Consuming the newline character left by nextInt()

        String[] refugee = new String[playerNumber];        // A table with names of the players
        for (int i = 0; i < playerNumber; i++) {
            System.out.println("Type your name for player " + (i + 1) + ":");
            try {
                String name = input.next();
                input.nextLine();           // Consuming the newline character left by next()
                refugee[i] = name;
                Refugee refugeePlayer = new Refugee(refugee[i], board, board.getSquare(0));     // The players is ready
                game.addPlayer(refugeePlayer);                                                  // Adding the refugee in the list of players
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid name.");
                input.nextLine(); // Consume the invalid input
                i--;                        // Retring the current iteration
            }
        }
        game.startGame();                  // The game starts
    }   
}
