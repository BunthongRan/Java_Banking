package testingBankingSystem;

import java.util.*;
class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " into account " + accountNumber);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from account " + accountNumber);
        } else {
            System.out.println("Insufficient funds in account " + accountNumber);
        }
    }

    public String toString() {
        return "Account Number: " + accountNumber + "\nAccount Holder Name: " + accountHolderName + "\nBalance: $" + balance;
    }
}

class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<Account>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account " + account.getAccountNumber() + " created successfully!");
    }

    public Account getAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        System.out.println("Account " + accountNumber + " does not exist!");
        return null;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        int choice, accountNumber;
        String accountHolderName;
        double balance, amount;

        do {
            System.out.println("1. Create Account\n2. Deposit\n3. Withdraw\n4. Check Balance\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    accountHolderName = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    balance = scanner.nextDouble();
                    Account account = new Account(accountNumber, accountHolderName, balance);
                    bank.addAccount(account);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextInt();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter Amount to Deposit: ");
                        amount = scanner.nextDouble();
                        account.deposit(amount);
                    }
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextInt();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter Amount to Withdraw: ");
                        amount = scanner.nextDouble();
                        account.withdraw(amount);
                    }
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextInt();
                    account = bank.getAccount(accountNumber);
                    if (account != null) {
                        System.out.println(account);
                    }
                    break;
                case 5:
                    System.out.println("Breaking system....");
                    break;
                default:
                    System.out.println("Invalid choice, please try again!");
            }
        } while (choice != 5);
    }
}



