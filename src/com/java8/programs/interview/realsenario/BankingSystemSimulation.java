package com.java8.programs.interview.realsenario;
import java.util.HashMap;
import java.util.Map;

class Account {
    private int accountNumber;
    private double balance;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }
}

class Bank {
    private Map<Integer, Account> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public void createAccount(int accountNumber) {
        accounts.put(accountNumber, new Account(accountNumber));
    }

    public void deposit(int accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found");
        }
    }

    public void checkBalance(int accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Balance for account " + accountNumber + ": " + account.getBalance());
        } else {
            System.out.println("Account not found");
        }
    }

    public void displayAccounts() {
        for (Account account : accounts.values()) {
            System.out.println(account);
        }
    }
}
public class BankingSystemSimulation {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.createAccount(101);
        bank.createAccount(102);

        bank.deposit(101, 500.0);
        bank.deposit(102, 1000.0);

        bank.withdraw(101, 200.0);

        bank.checkBalance(101);
        bank.checkBalance(102);

        System.out.println("\nAll accounts in the bank:");
        bank.displayAccounts();
    }
}
