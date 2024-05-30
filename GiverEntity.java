/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package refugeoly;

/**
 *
 * @author Klaud
 */
public class GiverEntity implements MoneyGiver{
    private final String name;
    private int money;
    
    public GiverEntity(String name){
        this.name = name;
        this.money = 10000;
    }
    
    public String getName(){
        return name;
    }
    
    public int getMoney(){
        return money;
    }
    
    
    @Override
    public void giveMoney(int money) throws NoMoneyException{
        if(this.money >= money){
            this.money -= money;
        }
        else{
            throw new NoMoneyException("NBO has gone BankRupt");
        }
    }
    
    @Override
    public String toString() {
        return name + " has: " + money + "$";
    }
}
