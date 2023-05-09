/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanagementsystem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author madih
 */
//save User account
//get User account
//update User Account
//save User's transaction history
//get User's transaction history(not needed)
// other functions that have been coded by Hashir and Warda
//Fixed Hashtable for branch code and their names  (select from dropdown)
// same for account type

public class StorageManager {
public static StorageManager instance = null;
    static User currentUser = null;
    public HashTable<String, String> branches = new HashTable<String, String>(12);
    HashTable<String, String> accountTypes = new HashTable<String, String>(2);
    public HashTable<String, HashTable<String, HashTable<String, User>>> usersHashTable;
    LinkedList<String> accountNumbers = new LinkedList<String>();
//    initiliaze in constructor, 
//    readFile

    public StorageManager(HashTable<String, HashTable<String, HashTable<String, User>>> usersHashTable, LinkedList<String> accountNumbers) {
        this.usersHashTable = usersHashTable;
        this.accountNumbers = accountNumbers;
    }

    public StorageManager() {
        readBranchCodes();
        generateAccountTypes();
        ArrayList<String> branchKeys = branches.getKeys();
//        System.out.println("Branch keys: " + branchKeys);
        ArrayList<String> accountTypeKeys = accountTypes.getKeys();
        HashTable<String, HashTable<String, HashTable<String, User>>> usersData = new HashTable<String, HashTable<String, HashTable<String, User>>>(12);
        for (int i = 0; i < branchKeys.size(); i++) {
            HashTable<String, HashTable<String, User>> accountTypeData = new HashTable<String, HashTable<String, User>>(2);

            for (int j = 0; j < accountTypeKeys.size(); j++) {
                HashTable<String, User> a = new HashTable<String, User>(5);
//                a.insertNode("000", new User("108900234", "Nagina", "Abid", 12));
                accountTypeData.insertNode(accountTypeKeys.get(j), a);
            }
            usersData.insertNode(branchKeys.get(i), accountTypeData);
//            if(i == 4){
//                System.out.println("currentBranchkey: " + branchKeys.get(i));
//                System.out.println("Is 1090 equal to key: " + ("1090" == branchKeys.get(i)));
//                System.out.println("userData account type data added: " + usersData.get("1090"));
//                System.out.println("userData account type data added: " + usersData.get(branchKeys.get(i)));
//
//            }

        }
//        System.out.println("Get branch 1000: " + usersData.get("1000") );
        this.usersHashTable = usersData;
    }

    public static void initialize(){
        instance = new StorageManager();
    }
    
    public static StorageManager getInstance(){
        return instance;
    }
    
    public static void setCurrentUser(User user){
        currentUser = user;
    }
    
    public static User getCurrentUser(){
        return currentUser;
    }
    
    public void readBranchCodes() {
        ArrayList<String> list = new ArrayList<String>();
        try {
            File file = new File("branchCity.txt");
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()) {
                String line = readFile.nextLine();
                if (!line.isEmpty()) {
                    list.add(line);
                }
            }
            readFile.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split(",");
            if (split.length == 2) {
//                branchKeys.add(split[0].trim());
                branches.insertNode(split[0].trim(), split[1].trim());
            }
        }
    }

    public void generateAccountTypes() {
        accountTypes.insertNode("00", "Current");
        accountTypes.insertNode("01", "Savings");
    }

    public void addUser(User user) throws Exception {
        try {
            //  function that stores splitted numbers in hashtable
            String[] split = splitAccountNumber(user.accountNumber);
            accountNumbers.insert(user.accountNumber);
            HashTable<String, HashTable<String, User>> acc = usersHashTable.get(split[0]);
            HashTable<String, User> users = acc.get(split[1]);
            users.insertNode(split[2], user);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void printHashTable(){
        System.out.println(usersHashTable);
    }

    public User getUserByAccountNumber(String accountNumber) throws Exception {
        try {
            String[] split = splitAccountNumber(accountNumber);
            return usersHashTable.get(split[0]).get(split[1]).get(split[2]);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public ArrayList<User> getAllUsersByBranchCode(String branchCode) {
        HashTable<String, HashTable<String, User>> accountTypes = usersHashTable.get(branchCode);
        ArrayList<User> users = new ArrayList<>();
        ArrayList<String> accountTypeKeys = accountTypes.getKeys();
        for (int i = 0; i < accountTypeKeys.size(); i++) {
            ArrayList<String> uniqueUserKeys = usersHashTable.get(branchCode).get(accountTypeKeys.get(i)).getKeys();
            for (int j = 0; j < uniqueUserKeys.size(); j++) {
                User user = usersHashTable.get(branchCode).get(accountTypeKeys.get(i)).get(uniqueUserKeys.get(j));
                users.add(user);
            }
        }
        return users;
    }

    public ArrayList<User> getAllUsersByBranchCodeAndAccountTypes(String branchCode, String accountType) {
        ArrayList<User> users = new ArrayList<>();
        ArrayList<String> uniqueUserKeys = usersHashTable.get(branchCode).get(accountType).getKeys();
        for (int i = 0; i < uniqueUserKeys.size(); i++) {
            User user = usersHashTable.get(branchCode).get(accountType).get(uniqueUserKeys.get(i));
            users.add(user);
        }
        return users;
    }
    
//    public ArrayList<User> getAllUsersByAccountTypes(String accountType) {
//        ArrayList<User> users = new ArrayList<>();
////        ArrayList<String> uniqueUserKeys = usersHashTable.get(branchCode).get(accountType).getKeys();
//                ArrayList<String> uniqueUserKeys = accountTypes.getKeys();
//                        ;
//
//        for (int i = 0; i < uniqueUserKeys.size(); i++) {
////            User user = usersHashTable.get(branchCode).get(accountType).get(uniqueUserKeys.get(i));
//                        User user = accountTypes.get(accountType).get(uniqueUserKeys.get(i));
//
//            users.add(user);
//        }
//        return users;
//    }

    public ArrayList<User> getAllUsers() throws Exception {
        ArrayList<String> listOfAccountNumbers = accountNumbers.getAllNodes();
        ArrayList<User> users = new ArrayList<User>();
        for (int i = 0; i < listOfAccountNumbers.size(); i++) {
            try {
                User user = getUserByAccountNumber(listOfAccountNumbers.get(i));
                users.add(user);
            } catch (Exception ex) {
                throw ex;
            }
        }
        return users;
    }
    
    public String[] getBranchesAndCities(){
        ArrayList<String> listOfBranches = branches.getKeys();
        String array[] = new String[listOfBranches.size() +1];              
		for(int j =0;j<listOfBranches.size();j++){
		  array[j] = listOfBranches.get(j);
		}
                array[array.length-1] = "Any";
             return array;
    }

    public String[] getAccountTypes() {
        ArrayList<String> listOfAccountTypes = accountTypes.getKeys();
        String array[] = new String[listOfAccountTypes.size() + 1];
        for (int j = 0; j < listOfAccountTypes.size(); j++) {
            array[j] = listOfAccountTypes.get(j);
        }
        array[array.length - 1] = "Any";
        return array;
    }
    
    public void printBranchesAndCities(){
        String[] arr = branches.getArrayKeys();
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i] + ", ");
        }
    }

    private String[] splitAccountNumber(String accountNumber) throws Exception {
//        use substring function to split accountNumber
        String[] split = {null, null, null};
        if (accountNumber.length() == 9) {
            split[0] = accountNumber.substring(0, 4);
            split[1] = accountNumber.substring(4, 6);
            split[2] = accountNumber.substring(6);
        } else {
            System.out.println("The account number you entered is invalid");
            throw new Exception("The account number you entered is invalid");
        }
        return split;
    }

    public void insertAccountNumbersInLinkedList(String accountNumber) {
        accountNumbers.insert(accountNumber);
    }

//    public void updateUserInformation(String accountNumber){
////        user = new User(getters from fields);
//     if(accountNumber.length() == 9){
//      String[] split = splitAccountNumber(accountNumber);   
//     }
//    }
//    public User getUser(String accountNumber){
//        
//    }
//    
    public boolean saveUsers(LinkedList<User> users) {
        try {
            File allUsersFile = new File("Users.txt");
            allUsersFile.createNewFile();
            FileOutputStream outputFile = new FileOutputStream("Users.txt");
            ObjectOutputStream outputObject = new ObjectOutputStream(outputFile);

            outputObject.writeObject(users);

            outputObject.close();
            outputFile.close();

            return true;

        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
    }

   public LinkedList<User> loadUsers() {
        LinkedList<User> users = new LinkedList<User>();
        User user = new User();
        String filename = user.accountNumber+".txt";
        try {

            FileInputStream inputFile = new FileInputStream(filename);
            ObjectInputStream inputObject = new ObjectInputStream(inputFile);

            users = (LinkedList<User>) inputObject.readObject();

            inputObject.close();
            inputFile.close();

            System.out.println(users.toString());
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
        return users;
    }
    
}
