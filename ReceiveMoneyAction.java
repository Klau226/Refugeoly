/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package refugeoly;

/**
 *
 * @author Klaud
 */
public class ReceiveMoneyAction implements Action{
    GiverEntity NboBank;
    int number;
    
    public ReceiveMoneyAction(int number,GiverEntity NboBank){
        this.number = number;
        this.NboBank = NboBank;
    }
    
    @Override
    public void act(Refugee refugee){
        try{
            NboBank.giveMoney(this.number);             // Bank gives money
            refugee.receiveMoney(this.number);          // player recieves money
            System.out.println("NBO Bank gave to " + refugee.getName() + ": " + this.number + "$");
            System.out.println("----------------------------------------------");
        }
        catch(NoMoneyException e){      // Catch if the bank has no money left
            System.out.println("NBO Bank has gone BankRupt, can't give money to " + refugee.getName());
        }
    }
}
