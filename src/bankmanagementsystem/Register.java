/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanagementsystem;
 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
 
/**
 *
 * @author wfati
 */
 public class Register {
    //String acc_type;
    private String acc_num;
    public String typecode;
    String inc;
    //java.util.Date dateCreated=new java.util.Date();
    //ArrayList numbers =  new ArrayList();
   private static int var ;
    public Register(){
    //var++;
        
    }
   
    public void login(){
        
    }  
    ArrayList acclist=new ArrayList();
   public String generateAccountNumber(String city, String code,String acctype){
   //Acc_num = Reading branch code from file - acc type - rand number
       
      try {
      File myObj = new File("AccountNo.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        acclist.insert(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
      
      //Branch Code
    /* String code="";
        try {
      File myObj = new File("BranchCode.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] parts = data.split(",");
        if(parts.length==2&&parts[1].equals(city))
            code=parts[0];
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }  */ 
       
    //Account Type
    //acc_type="user";
     if (acctype.equalsIgnoreCase("current")){
     typecode="00";    
     }
     else if (acctype.equalsIgnoreCase("savings")){
         typecode="01";     
     }
     else{
         System.out.println("Choose an appropriate account type.");
     }
   // Random 3 digit number
     var=(int)(100+(Math.random()*1000));
     
    acc_num = code + typecode + var;
     while(true){
     if(acclist.Find(acc_num)){
     var=(int) (Math.random()*1000);
     acc_num = code  + typecode + var;}
     else{break;}
     }
    
    //acc_num = code + "-" + index +"-"+ inc;
   
    return acc_num;
   }  
    
}
 
// Driver Code
class Registration {
 
    public static void main(String[] args) throws Exception
    {
        Register f = new Register();
        
        //System.out.println(f.generateAccountNumber("Hyderabad"));
        //System.out.println(f.generateAccountNumber("Karachi"));
       // System.out.println(f.generateAccountNumber("Islamabad"));
        //f.acclist.PrintList();
    }
}
    

