package codeAlpha;
import java.util.*;
public class Bank extends Locker{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Map<String,String> users=new HashMap<>();
        int suffix=1000;
        while(true)
        {
            System.out.println("If you have account type yes");
            System.out.println("If you want to create account type create");
            System.out.println("Type exit to exit from app");
            String input=s.next();
            final String prefix="bank";
            String username;
            String password;
            if(input.equalsIgnoreCase("create"))
            {
                System.out.println("your account id and your username is : "+(prefix+suffix));
                System.out.println("enter your password");
                password=s.next();
                users.put((prefix+suffix),password);
                locker.put((prefix+suffix),0.0);
                System.out.println("----Congratulations your account is created----");
                suffix++;
            }
            else if(input.equalsIgnoreCase("yes"))
            {
                System.out.println("enter username");
                username=s.next();
                if(users.containsKey(username))
                {
                    System.out.println("enter password");
                    password=s.next();
                    if(users.get(username).equals(password))
                    {
                        bankMenu(username);
                    }
                    else
                    {
                        System.out.println("Invalid password");
                    }
                }
                else
                System.out.println("Invalid username");
            }
            else
            {
                break;
            }
        }

    }
    public static void bankMenu(String id)
    {
        Scanner s=new Scanner(System.in);
        System.out.println("**********Select an option***********");
        System.out.println(" 1) Deposit \n 2) Withdraw \n 3) Check Balance \n 4) Exit");
        while(true)
        {
            String input=s.next();
            if(input.equalsIgnoreCase("Deposit") || input.equals("1"))
            Deposit(id);
            else if(input.equalsIgnoreCase("Withdraw") || input.equals("2"))
            Withdraw(id);
            else if(input.equalsIgnoreCase("Check balance") || input.equals("3"))
            CheckBalance(id);
            else if(input.equalsIgnoreCase("Exit") || input.equals("4"))
            break;
            else
            System.out.println("Only options which are provided can be initiated. Please try again if any mistake");
        }
    }
    public static void Deposit(String id)
    {
        Scanner s=new Scanner(System.in);
        double amt=0;
        System.out.println("Enter the amount");
        amt=s.nextDouble();
        double bal=getBalance(id);
        bal+=amt;
        setBalance(id,bal);
        System.out.println("Deposit was succussful");
    }
    public static void Withdraw(String id)
    {
        Scanner s=new Scanner(System.in);
        double amt=0;
        System.out.println("enter amount to withdraw");
        amt=s.nextDouble();
        double bal=getBalance(id);
        if(bal>=amt)
        {
            bal-=amt;
            if(setBalance(id,bal))
            System.out.println("withdrawal is succussful");
            else
            System.out.println("Withdrawal is failure");
        }
        else
        {
            System.out.println("Insufficent balance");
        }

    }
    public static void CheckBalance(String id)
    {
        System.out.println("Your balance is : "+getBalance(id));
    }
}
class Locker
{
    static Map<String,Double> locker=new HashMap<>();
    protected static double getBalance(String id)
    {
        if(locker.get(id)!=null)
        return locker.get(id);
        else
        return -1;
    }
    protected static boolean setBalance(String id,double amt)
    {
        if(locker.get(id)!=null)
        {
            locker.put(id,amt);
            return true;
        }
        else
        return false;
    }
}
