/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loantree;

/**
 *
 * @author hashi
 */
public class queue{
String AccountNo;
String Name;
String AmountAskedFor;
String AnualIncome;
String Tenure;
String Urgent;
queue next;
queue last;
    public queue(String AccountNo, String Name, String AmountAskedFor, String AnualIncome, String Tenure, String Urgent) {
        this.AccountNo = AccountNo;
        this.Name = Name;
        this.AmountAskedFor = AmountAskedFor;
        this.AnualIncome = AnualIncome;
        this.Tenure = Tenure;
        this.Urgent = Urgent;
    }

}
