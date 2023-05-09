/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanagementsystem;
import GUI.HomePage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author madih
 */
public class BankManagementSystem {
    /**
     * @param args the command line arguments
     */
 
    public void createBranchCode(){
         try {
      File myObj = new File("BranchCode.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    try {
      FileWriter myWriter = new FileWriter("BranchCode.txt");
      myWriter.write("1000\t\tKarachi\n1001\t\tHyderabad\n1012\t\tFaisalabad\n1023\t\tBhawalpur\n1034\t\tLahore\n1045\t\tIslamabad\n1056\t\tPeshawar\n1067\t\tQuetta\n1078\t\tNawabshah\n1089\t\tSukkur\n1090\t\tMultan");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    }
     catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();}
   
    }
    static StorageManager storageManager = null;
    public static void main(String[] args) {
        BankManagementSystem sys= new BankManagementSystem();
         sys.createBranchCode();
//        User user = new User("100000001", "User 1", "Abid", 64);
        StorageManager.initialize();
        storageManager = StorageManager.getInstance();
//        storageManager.printHashTable();
//        System.out.println("Tester" + storageManager.usersHashTable.get("0000"));
        generateUsers();
        try {
//            System.out.println(storageManager.getAllUsersByBranchCode("1090"));
//            storageManager.addUser(new User("100000001", "User 1", "Abid", 64));

        } catch (Exception ex) {
            Logger.getLogger(BankManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

//        storageManager.printHashTable();
//         user.addTransaction(new Transaction("deposit", 12, "12/12/12", "It is for testing purpose"));
//         user.addTransaction(new Transaction("withdraw", 11, "07/09/12", "It is for testing purpose"));
//         System.out.println(user);
//         System.out.println(storageManager.getBranchesAndCities());
//         storageManager.printBranchesAndCities();
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });

    }

    public static void generateUsers(){
        try{
           storageManager.addUser(new User("100000001", "5042", "User 1", "Name", 64));
            storageManager.addUser(new User("100000002", "2983",  "User 2", "Name", 80));
            storageManager.addUser(new User("100000003", "4900", "User 3", "Name", 3));
            storageManager.addUser(new User("100000004", "7127" ,"User 4", "Name", 27));
            storageManager.addUser(new User("100000005", "0019",  "User 5", "Name", 76));
            storageManager.addUser(new User("100001001", "2932","User 6", "Name", 25));
            storageManager.addUser(new User("100001002","6275" ,"User 7", "Name", 13));
            storageManager.addUser(new User("100001003", "5347","User 8", "Name", 58));
            storageManager.addUser(new User("100001004", "3379" ,"User 9", "Name", 78));
            storageManager.addUser(new User("100001005", "4922","User 10", "Name", 55));
            storageManager.addUser(new User("100100001", "1214", "User 11", "Name", 95));
            storageManager.addUser(new User("100100002", "5987", "User 12", "Name", 37));
            storageManager.addUser(new User("100100003", "4395", "User 13", "Name", 79));
            storageManager.addUser(new User("100100004", "2053", "User 14", "Name", 31));
            storageManager.addUser(new User("100100005", "0262", "User 15", "Name", 33));
            storageManager.addUser(new User("100101001", "0963", "User 16", "Name", 93));
            storageManager.addUser(new User("100101002", "1169", "User 17", "Name", 84));
            storageManager.addUser(new User("100101003", "1669", "User 18", "Name", 62));
            storageManager.addUser(new User("100101004", "0221", "User 19", "Name", 9));
            storageManager.addUser(new User("100101005", "5001", "User 20", "Name", 64));
            storageManager.addUser(new User("101200001", "4849", "User 21", "Name", 49));
            storageManager.addUser(new User("101200002", "7189", "User 22", "Name", 65));
            storageManager.addUser(new User("101200003", "8795", "User 23", "Name", 68));
            storageManager.addUser(new User("101200004", "3650", "User 24", "Name", 67));
            storageManager.addUser(new User("101200005", "1417", "User 25", "Name", 9));
            storageManager.addUser(new User("101201001", "4599", "User 26", "Name", 69));
            storageManager.addUser(new User("101201002", "7675", "User 27", "Name", 57));
            storageManager.addUser(new User("101201003", "1234", "User 28", "Name", 2));
            storageManager.addUser(new User("101201004", "3282", "User 29", "Name", 2));
            storageManager.addUser(new User("101201005", "0931", "User 30", "Name", 62));
            storageManager.addUser(new User("102300001", "2290", "User 31", "Name", 65));
            storageManager.addUser(new User("102300002", "2209", "User 32", "Name", 39));
            storageManager.addUser(new User("102300003", "5605", "User 33", "Name", 4));
            storageManager.addUser(new User("102300004", "3229", "User 34", "Name", 66));
            storageManager.addUser(new User("102300005", "0443", "User 35", "Name", 87));
            storageManager.addUser(new User("102301001", "4911", "User 36", "Name", 57));
            storageManager.addUser(new User("102301002", "4826", "User 37", "Name", 86));
            storageManager.addUser(new User("102301003", "4876", "User 38", "Name", 7));
            storageManager.addUser(new User("102301004", "4671", "User 39", "Name", 22));
            storageManager.addUser(new User("102301005", "2148", "User 40", "Name", 68));
            storageManager.addUser(new User("103400001", "8908", "User 41", "Name", 86));
            storageManager.addUser(new User("103400002", "1122", "User 42", "Name", 51));
            storageManager.addUser(new User("103400003", "8829", "User 43", "Name", 9));
            storageManager.addUser(new User("103400004", "8762", "User 44", "Name", 47));
            storageManager.addUser(new User("103400005", "7638", "User 45", "Name", 42));
            storageManager.addUser(new User("103401001", "5848", "User 46", "Name", 90));
            storageManager.addUser(new User("103401002", "5418", "User 47", "Name", 91));
            storageManager.addUser(new User("103401003", "1678", "User 48", "Name", 56));
            storageManager.addUser(new User("103401004", "8901", "User 49", "Name", 9));
            storageManager.addUser(new User("103401005", "5467", "User 50", "Name", 15));
            storageManager.addUser(new User("104500001", "1276", "User 51", "Name", 49));
            storageManager.addUser(new User("104500002", "4411", "User 52", "Name", 86));
            storageManager.addUser(new User("104500003", "8742", "User 53", "Name", 21));
            storageManager.addUser(new User("104500004", "1501", "User 54", "Name", 56));
            storageManager.addUser(new User("104500005", "9008", "User 55", "Name", 9));
            storageManager.addUser(new User("105600001", "6578", "User 61", "Abid", 40));
            storageManager.addUser(new User("105600002", "8902", "User 62", "Abid", 61));
            storageManager.addUser(new User("105600003", "9876", "User 63", "Abid", 76));
            storageManager.addUser(new User("105600004", "3451", "User 64", "Abid", 43));
            storageManager.addUser(new User("105600005", "7632", "User 65", "Abid", 37));
            storageManager.addUser(new User("105601001", "1643", "User 66", "Abid", 36));
            storageManager.addUser(new User("106700001", "6321", "User 71", "Abid", 81));
            storageManager.addUser(new User("106700002", "6541", "User 72", "Abid", 65));
            storageManager.addUser(new User("106700003", "0114", "User 73", "Abid", 65));
            storageManager.addUser(new User("107800001", "2671", "User 81", "Abid", 70));
            storageManager.addUser(new User("107800002", "4386", "User 82", "Abid", 46));
            storageManager.addUser(new User("107800003", "4313", "User 83", "Abid", 69));
            storageManager.addUser(new User("107800004", "8742", "User 84", "Abid", 42));
            storageManager.addUser(new User("108900001", "2341", "User 91", "Abid", 48));
            storageManager.addUser(new User("108900002", "6732", "User 92", "Abid", 36));
            storageManager.addUser(new User("108900003", "5421", "User 93", "Abid", 96));
            storageManager.addUser(new User("109000005", "9411", "User 105", "Abid", 65));
            storageManager.addUser(new User("109001001", "6032", "User 106", "Abid", 21));
            storageManager.addUser(new User("109001002", "0001", "User 107", "Abid", 66));
        } catch (Exception e) {
            System.out.println("Exception occurred");
        }
    }
}
