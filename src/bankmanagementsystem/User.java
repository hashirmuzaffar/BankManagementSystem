/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanagementsystem;

import java.util.ArrayList;

/**
 *
 * @author madih
 */
public class User implements Comparable<User>{

    String firstName;
    String lastName;
    String gender;
    String contactNumber;
    String dateOfBirth;
    String address;
    String branchCode;
    String accountType;
    String accountNumber;
// 00101001
    String dateCreated;
    String pincode;
    String CNIC;
    double accountBalance;
    ArrayList<Transaction> transactionHistory;

    public User() {
    }
    
    

    public User(String accountNumber,String pincode, String firstName, String lastName, double accountBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.transactionHistory = new ArrayList<Transaction>();
        this.pincode = pincode;
    }
    
    public User(String firstName, String lastName, String accountNumber, String gender, String contactNumber, String dateOfBirth, String address, String branchCode, String dateCreated, String pincode, String cnic, double accountBalance, ArrayList<Transaction> transactionHistory) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.branchCode = branchCode;
        this.accountNumber = accountNumber;
        this.dateCreated = dateCreated;
        this.pincode = pincode;
        this.CNIC = cnic;
        this.transactionHistory = new ArrayList<>();
    }
    
//    public void viewTransactionReport()
//    public void viewAccountBalance()
//    public void viewLoanApplicationStatus()
//    public void applyForLoan()

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String cnic) {
        this.CNIC= cnic;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    
    public void addTransaction(Transaction transaction){
        transactionHistory.add(transaction);
        this.accountBalance += transaction.getAmount();
    }
    
    public int transactionLength(){
        return transactionHistory.size();
    }
    
    public ArrayList<Transaction> getTransaction(){
        return transactionHistory;
    }
    
    public String[] getDisplayRow(){
        String[] array = {accountNumber, accountNumber.substring(0,4), accountNumber.substring(4,6), firstName, lastName, Double.toString(accountBalance)};
        return array;
    }

    @Override
    public String toString() {
        return "User{" + "firstName=" + firstName + ", lastName=" + lastName + ", accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + ", transactionHistory=" + transactionHistory + '}';
    }

    @Override
    public int compareTo(User user) {
       return this.firstName.compareTo(user.firstName);
    }
    
}


