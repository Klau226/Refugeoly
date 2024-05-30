/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package refugeoly;

/**
 *
 * @author Klaud
 */
public class NoMoneyException extends Exception{
    
    public NoMoneyException(){

    }
    
    public NoMoneyException(String msg){
        super(msg);
    }
}
