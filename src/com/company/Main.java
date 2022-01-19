package com.company;
import java.util.*;
public class Main {


    //Need to find a way to store the current balance with the username and password so it saves the data.
    //So babay:boo:900
    public static void main(String[] args) {
        Map<String, String> userfunction = new HashMap<>(); //password manager
        Hello(userfunction);
    }

    public static void Hello(Map<String, String> userfunction){
        Scanner obj = new Scanner(System.in);
        System.out.println("""
                Hello welcome to BankyBank!
                Are you a new user?
                1.Yes
                2.No""");
        int option = obj.nextInt();
        menFromMain(option, userfunction);
    }

 // method to create account
    public static void newUser(Map<String, String> userfunction) {
        Scanner objNew = new Scanner(System.in);
        System.out.println("Enter Username");
        String username = objNew.nextLine();

        System.out.println("Enter password");
        String password = objNew.nextLine();

             //password manager
        userfunction.put(username, password);
        testlopp(userfunction);
        bank(userfunction);

    }
         //********testing function will delete later****************\\
    public static void testlopp(Map<String, String> userfunction){
        for (Map.Entry<String, String> entry : userfunction.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    //method to let in old user
    public static void oldUser(Map<String, String> userfunction) {
        Scanner objOld = new Scanner(System.in);
        System.out.println("Enter Username");
        String username = objOld.nextLine();

        System.out.println("Enter password");
        String password = objOld.nextLine();


        if (userfunction.containsKey(username)) {
            if (userfunction.get(username).equals(password)) {
                System.out.println("Welcome back " + username + "!" + '\n');
                bank(userfunction);
            } else {
                System.out.println("Wrong password, try again" + '\n');
                oldUser(userfunction);
            }
        }
        else {
            System.out.println("""
                    Wrong Info
                     1. Create account
                    try again
                    """);
            int newTry = objOld.nextInt();
            menFromMain(newTry, userfunction);

            }
        }

//method that allows access to deposit, withdraw, and other account function
    public static void bank(Map<String, String> userfunction) {
        Scanner objBank = new Scanner(System.in);
        System.out.println("""
                Would you like to
                1.Deposit
                2.Withdraw
                3.See how much is in account?
                4.Return to start
                5.Stop
                """);
        int choice = objBank.nextInt();
        float total = 0;
        optionMen(choice, total, userfunction);


    }
    //////////////method to deposit money
    public static void deposit(float total, Map<String, String> userfunction) {
        Scanner objDeposit = new Scanner(System.in);
        System.out.println("How much are you depositing?" + '\n');
        float deposit = objDeposit.nextFloat();
        System.out.println("""
                Would you like to
                1.Deposit
                2.Withdraw
                3.See how much is in account?
                4.Return to start
                5.Stop
                """);
        int choice = objDeposit.nextInt();
        total += deposit;
        optionMen(choice, total, userfunction);
    }


    ////////method to withdraw money
    public static void withdraw(float total, Map<String, String> userfunction) {
        Scanner objWithdraw = new Scanner(System.in);
        System.out.println("How much are you withdrawing?");
        float withdraw = objWithdraw.nextFloat();

        System.out.println("""
                Would you like to
                1.Deposit
                2.Withdraw
                3.See how much is in account?
                4.Return to start
                5.Stop
                """);
        int choice = objWithdraw.nextInt();
        total -= withdraw;
        optionMen(choice, total, userfunction);
    }

    //method to see how much is in account
    public static void totalAccount(float total, Map<String, String> userfunction) {
        Scanner objTotalAccount = new Scanner(System.in);
        if(total<0){
            System.out.println("You have " + total +'\n'+"Overdraft fee has been applied"+'\n');
        }
        else {
            System.out.println("You have " + total);
        }
        System.out.println("""
                Would you like to
                1.Deposit
                2.Withdraw
                3.See how much is in account?
                4.Return to start
                5.Stop
                """);
        int choice = objTotalAccount.nextInt();
        optionMen(choice, total,userfunction);
    }

    //public static void assignAccNumber(){
   // }


    //menu that calls deposit, withdraw, total, hello
    public static void optionMen(int choice, float total,Map<String, String> userfunction) {
        switch (choice) {
            case 1:
                deposit(total,userfunction);
                break;
            case 2:
                withdraw(total,userfunction);
                break;
            case 3:
                totalAccount(total,userfunction);
                break;
            case 4:
                Hello(userfunction);
                break;
            case 5:
                break;
        }
    }

    //initial menu for new or old
    public static void menFromMain(int option, Map<String, String> userfunction) {
        switch (option) {
            case 1 -> newUser(userfunction);
            case 2 -> oldUser(userfunction);
        }
    }
}
