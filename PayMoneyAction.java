/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package refugeoly;

/**
 *
 * @author Klaud
 */
public class PayMoneyAction implements Action{
    ReceiverEntity mafiaBank;
    int amount;
    boolean isBank;
    
    public PayMoneyAction(int amount,ReceiverEntity mafiaBank,boolean isBank){
        this.amount = amount;
        this.mafiaBank = mafiaBank;
        this.isBank = isBank;
    }
    
    @Override
    public void act(Refugee refugee){
        try{
            refugee.giveMoney(this.amount);
            refugee.toExpences(this.amount);
            if(isBank){         // If this is true then the square says: "Give money to Mafia" 
                mafiaBank.receiveMoney(this.amount);
                System.out.println("----------------------------------------------");
                System.out.println("Mafia Bank Received: " + this.amount + "$" + " from: " + refugee.getName() + " ");
                System.out.println("----------------------------------------------");
                System.out.println();
            }
        }
        catch(NoMoneyException e){      // Catch if the player has no money left
            System.out.println(refugee.getName() + " does not have enough money to pay.");
            refugee.setMoneyLeft(false);
        }
    }
}
