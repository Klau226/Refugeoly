/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package refugeoly;

/**
 *
 * @author Klaud
 */
public class Refugee implements MoneyGiver,MoneyReceiver{
    // TO DO:
    //και επίσης γνωρίζει το ταμπλό(board)
    //καθώς και το τετράγωνο (square)
    //καθώς και να μετακινηθεί σε άλλο τετράγωνο (moveTo())

    
    private final String name;
    private int money;
    private Board board;
    private Square square;
    private int expenses;
    private int position;
    private boolean isMyTurn;
    private int counterIsMyTurn;
    boolean moneyLeft;
    
    public Refugee(String name,Board board,Square square){
        this.name = name;
        this.board = board;
        this.square = square;
        money = 10000;
        expenses = 0;
        position = 0;
        isMyTurn = true;
        counterIsMyTurn = 0;
        moneyLeft = true;
    }
    
    public String getName(){
        return name;
    }
    
    public int getMoney(){
        return money;
    }
    
    public void setMoney(int money){ // DEN XREIAZETAI
        this.money = money;
    }
    
    @Override
    public void receiveMoney(int money){
        this.money += money;
    }
    
    @Override
    public void giveMoney(int money) throws NoMoneyException{
        if(this.money >= money){
            this.money -= money;
        }
        else{
            throw new NoMoneyException("Not enough money to give");
        }
    }
    
    public void moveTo(Square destinationSquare) {
        this.square = destinationSquare;
        
    }
    
    public Square getCurrentSquare() {
        return this.square;
    }
    
    public int getNumber(){                 // Taking the square number
        return square.getNumber();
    }
    
    public int getExpences(){
        return expenses;
    }
    
    public void toExpences(int expences){
        this.expenses += expences;
    }
    
    public void setPreviousPosition(int position){
        this.position = position;
    }
    
    public int getPreviousPosition(){
        return this.position;
    }
    
    public void setIsMyTurn(boolean isMyTurn){          // Den htan sthn ekfwnhsh
        this.isMyTurn = isMyTurn;
    }
    
    public boolean getIsMyTurn(){                       // Den htan sthn ekfwnhsh
        return this.isMyTurn;
    }
    
    public void plusCounterIsMyTurn(){                  // Den htan sthn ekfwnhsh
        this.counterIsMyTurn++;
    }
    
    public void minusCounterIsMyTurn(){                 // Den htan sthn ekfwnhsh
        this.counterIsMyTurn--;
    }
    
    public int getCounterIsMyTurn(){                    // Den htan sthn ekfwnhsh
        return this.counterIsMyTurn;
    }
    
    public void setMoneyLeft(boolean moneyLeft){        // Den htan sthn ekfwnhsh 
        this.moneyLeft = moneyLeft;
    }
    
    public boolean getMoneyLeft(){                      // Den htan sthn ekfwnhsh  
        return this.moneyLeft;
    }
    
    @Override
    public String toString(){
        return "Player " + name +
                ": Money=" + money + 
                ", Expenses=" + expenses + 
                ", Position=" + position;
    }
    
}
