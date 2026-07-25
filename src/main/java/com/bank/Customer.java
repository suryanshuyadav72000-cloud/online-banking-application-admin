package com.bank;

public class Customer {

    private int id;
    private String name;
    private String account;
    private String mobile;
    private double balance;

    public Customer() {
    }

    public Customer(int id, String name, String account, String mobile, double balance) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.mobile = mobile;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}