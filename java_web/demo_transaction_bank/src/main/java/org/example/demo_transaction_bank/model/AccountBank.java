package org.example.demo_transaction_bank.model;

public class AccountBank {
   private String accountNumber;
   private String username;
   private String password;
   private String ownerName;
   private double totalMoney;

    public AccountBank() {
    }

    public AccountBank(String accountNumber, String username, String password, String ownerName, double totalMoney) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.password = password;
        this.ownerName = ownerName;
        this.totalMoney = totalMoney;
    }

    public AccountBank(String accountNumber, String username, String password, String ownerName) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.password = password;
        this.ownerName = ownerName;
    }





    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
