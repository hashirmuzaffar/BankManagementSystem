/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loantree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author hashi
 */

public class AdminLoan {

   
    queue head;
   queue tail;
   static int count=0;
   
   public void enqueue(String AccountNo, String Name, String AmountAskedFor, String AnualIncome, String Tenure, String Urgent){
   queue newElement = new queue(AccountNo,Name,AmountAskedFor,AnualIncome,Tenure,Urgent);
   if(head==null){
   head=newElement;
   tail=newElement;
   }
   else{
   queue prev=null;
   queue curr=head;
   if(newElement.Urgent.equals("no")){
   while(curr!=null){
       prev=curr;
       curr=curr.next;
   }
       prev.next=newElement;
   }
   else if(newElement.Urgent.equals("yes"))
   {
   while(curr!=null && !curr.Urgent.equals("no")){
       prev=curr;
       curr=curr.next;
   }
   if(curr==head){newElement.next=curr; head=newElement;}
   else if(curr==null){prev.next=newElement;}
   else{newElement.next=curr;prev.next=newElement;}
   }
   }
   }
    
   public void Dequeue(){
   head=head.next;
   }
   
   

    public static int getCount() {
        return count;
    }
  
   
   
   public void CreateQueue(){
   try{
   File file = new File("Loan.txt");
   Scanner sc= new Scanner(file);
   while(sc.hasNext()){
   String line = sc.nextLine();
   String[] parts = line.split("  ");
   if(parts.length==6)
   this.enqueue(parts[0], parts[01], parts[02], parts[03], parts[04], parts[05]);
   count++;}
   }
   catch(Exception e){System.out.print(e);}
   }
   File log = new File("LoanUpdated.txt");
   public void UpdateFile(){
      
     
        try{
            if(log.exists()==false){
                System.out.println("We had to make a new file.");
                log.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            queue temp=head;
            while(temp!=null){
            out.append(temp.AccountNo+"  "+temp.Name+"  "+temp.AnualIncome+"  "+temp.AmountAskedFor+"  "+temp.Tenure+"\n");
            temp=temp.next;
            }
            out.close();
        }catch(IOException e){
            System.out.println("COULD NOT LOG!!");
        }
   
   
   
   
   
   
   }
   

  
   
   public static void main(String[] args){
   AdminLoan AL = new AdminLoan();
    
   
   }
}
