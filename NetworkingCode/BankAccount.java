

/**
 * Write a description of class BankAccount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BankAccount
{
    private int Total;
    public BankAccount(){
        Total = 0; 
    }
    
    public int deposit(double Amount){
        Total += Amount;
        return Total;
    }
    
    public int withdraw(double Amount){
        Total -= Amount;
        return Total;
    }
    
    public int getBalance(){
        return Total;
    }
}
