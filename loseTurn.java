/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package refugeoly;

/**
 *
 * @author Klaud
 */
public class loseTurn implements Action{
    
    public loseTurn(){
        
    }
    
    @Override
    public void act(Refugee refugee){
        System.out.println("----------------------------------------------");
        System.out.println("You lose the next turn");
        System.out.println("----------------------------------------------");
        refugee.setIsMyTurn(false);
    }
    
}
