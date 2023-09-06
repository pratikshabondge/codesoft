

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited Rs" + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn Rs" + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(double initialBalance) {
        bankAccount = new BankAccount(initialBalance);
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the ATM!");
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private void checkBalance() {
        double balance = bankAccount.getBalance();
        System.out.println("Your balance is Rs" + balance);
    }

    private void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            bankAccount.deposit(amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            bankAccount.withdraw(amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        double initialBalance = 1000.0; // Initial account balance
        ATM atm = new ATM(initialBalance);
        atm.start();
    }
}




Output 
Welcome to the ATM!

Select an option:
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
1
Your balance is Rs1000.0

Select an option:
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
2
Enter the amount to deposit: 500
Deposited Rs500.0

Select an option:
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
1
Your balance is Rs1500.0

Select an option:
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
