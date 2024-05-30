/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package refugeoly;

/**
 *
 * @author Klaud
 */
public class GoToTile implements Action{
    Board board;
    private int tileNumber;
    
    public GoToTile(int tileNumber,Board board){
        this.tileNumber = tileNumber;
        this.board = board;
    }
    
    @Override
    public void act(Refugee refugee){
      System.out.println("----------------------------------------------");
      System.out.println("Going to tile " + tileNumber);
      System.out.println("----------------------------------------------");
      Square square = board.getSquare(tileNumber);
      refugee.moveTo(square);
    }
}
