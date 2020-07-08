package com.softserve.sprint05.task5;

class CheckingAccount {
    private double balance;
    private int number;

    public CheckingAccount(int number) {
        this.number = number;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientAmountException {
        if(amount <= balance) {
            balance -= amount;
        }else {
            double needs = amount - balance;
            throw new InsufficientAmountException(needs);
        }
    }
    //some other code
}

class BankDemo {
    public static void doOperations() {
        CheckingAccount c = new CheckingAccount(101);
        c.deposit(500.00);
        try {
            c.withdraw(100.00);
            c.withdraw(600.00);
        } catch (InsufficientAmountException e) {
            System.out.println(e.getMessage());
            System.out.println("Please, deposit at least $" + e.getAmount());
            e.printStackTrace();
        }
    }
}

class InsufficientAmountException extends Exception {
    private double amount;
    public InsufficientAmountException(double needs) {
        this.amount = needs;
    }

    @Override
    public String getMessage() {
        return "Sorry, but you are short $" + this.amount;
    }

    public String getAmount() {
        return String.valueOf(amount);
    }
}

/**
 * Sorry, but you are short $200.0
 * Please, deposit at least $200.0
 *      **standard stack trace output**
 */
public class Task5 {
    public static void main(String[] args) {
        BankDemo.doOperations();
    }
}
