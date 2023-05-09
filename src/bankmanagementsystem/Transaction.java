/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanagementsystem;

import java.util.Date;

/**
 *
 * @author madih
 */
public class Transaction {

    String transactionType;
    double amount;
    Date date;
    String description;
    static String TYPE_WITHDRAWAL = "withdraw";
    static String TYPE_DEPOSIT = "deposit";

    public Transaction(String transactionType, double amount, Date date, String description) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public Transaction(double amount, String description) {
        this.amount = amount;
        this.description = description;
        this.date = new Date();
        if (this.amount < 0) {
            this.transactionType = TYPE_WITHDRAWAL;
        } else {
            this.transactionType = TYPE_DEPOSIT;
        }
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getDisplayRow() {
        String[] array = {date.toString(), transactionType, Double.toString(Math.abs(amount)), description};
        return array;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionType=" + transactionType + ", amount=" + amount + ", date=" + date + ", description=" + description + '}';
    }

}
