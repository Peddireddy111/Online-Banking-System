import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
class Account {
    private String accountNumber;
    private String holderName;
    private double balance;
    private List<String> services = new ArrayList<>();

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) { balance += amount; }
    public boolean withdraw(double amount) {
        if (amount > balance) return false;
        balance -= amount;
        return true;
    }

    public void addService(String service) { services.add(service); }

    public List<String> getServices() { return services; }

    @Override
    public String toString() {
        return accountNumber + " | " + holderName + " | Balance: ₹" + balance +
               " | Services: " + services;
    }
}

