import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.*;
import java.io.*;
class Account implements Serializable{

    static int accn ;
    static String name ;
    static int balance ;
    public Account(){
    }

     public Account(int accn , String name , int balance){
        this.accn=accn;
        this.name=name;
        this.balance=balance;

    }

    public String toString(){
        return "Welcome"+name
                +"Your Acc no is"+accn
                +"Your balance is "+balance;
    }
    public static void createacc(){

        System.out.println("Welcome Customer ,"+name);
        System.out.println("Your Account is created");
        System.out.println("your acc no is"+accn);



    }
    public static void viewacc(){
        Scanner sc = new Scanner(System.in);
        System.out.println("The details of the customer are");
        System.out.println("Enter acc no");
        int a = sc.nextInt();
        if(a==accn){
            System.out.println("Welcome"+name);
            System.out.println("Your acc no is"+accn);
            System.out.println("Your balance is "+balance);
        }
    }
    public static void viewall(){
        try {
            FileInputStream fis = new FileInputStream("C:/Users/Aryan/OneDrive/Documents/javafile/New folder/Account.txt");
            ObjectInputStream ois=new ObjectInputStream(fis);

            Account a = (Account) ois.readObject();
            System.out.println(a);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
public class Menudrivenprog extends Account  {
    public static void main(String[] args)  throws Exception{
        HashMap<String,Integer> hm = new HashMap<>();
        Account a = new Account(1222,"Hacker",0);
        Account a2 = new Account(1223,"Joker",10);
        Account a3 = new Account(1224,"Demo",1200);
        System.out.println("=====================");
        System.out.println("1.Create Account");
        System.out.println("2.Delete Account ");
        System.out.println("3.View Account");
        System.out.println("4.View All Accounts");
        System.out.println("5.Save");
        System.out.println("=====================");

        System.out.println("Enter your choice");
     Scanner sc = new Scanner(System.in);
     int choice = sc.nextInt();
     switch (choice){
         case 1 : if (choice==1){
             createacc();
             System.out.println("Press Enter to continue...");
             System.in.read();
             System.out.println("Finished.");
             break;
         }
         case 2: if (choice==2){
             System.out.println("Enter acc no");
             accn = sc.nextInt();
             hm.remove(accn);
             System.out.println("Press Enter to continue...");
             System.in.read();
             System.out.println("Finished.");
              break;
         }
         case 3: if (choice==3){
            viewacc();
             System.out.println("Press Enter to continue...");
             System.in.read();
             System.out.println("Finished.");
         }
         case 4:if (choice==4){
             viewall();
             System.out.println("Press Enter to continue...");
             System.in.read();
             System.out.println("Finished.");
         }
         case 5: if (choice==5){
             try {
                 FileOutputStream fos = new FileOutputStream("C:/Users/Aryan/OneDrive/Documents/javafile/New folder/Account.txt");
                 ObjectOutputStream oos=new ObjectOutputStream(fos);
                 oos.writeObject(a);
                 oos.writeObject(a2);
                 System.out.println("Press Enter to continue...");
                 System.in.read();
                 System.out.println("Finished.");
             }
             catch (Exception e){
                 System.out.println(e);

             }
         }
     }
    }
}
