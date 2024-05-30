/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package refugeoly;

/**
 *
 * @author Klaud
 */
public class ReceiverEntity implements MoneyReceiver{
    private final String name;
    private int money;
    
    public ReceiverEntity(String name) {
        this.name = name;
        money = 0;
    }
    
    public String getName(){
        return name;
    }
    
    public int getMoney(){
        return money;
    }
    
    public void setMoney(int money){    // DEN XREIAZETAI
        this.money = money;
    }
    
    @Override
    public void receiveMoney(int money){
        this.money += money;
    }
    
    @Override
    public String toString(){
        return name + " has: " + money + "$";
    }
}
