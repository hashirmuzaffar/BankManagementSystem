/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanagementsystem;

/**
 *
 * @author madih
 */
public class Admin {
 
   final String adminId;
   final String password;

    public Admin() {
        this.adminId = "admin";
        this.password = "admin123";
    }

   

    public String getAdminId() {
        return adminId;
    }

    public String getPassword() {
        return password;
    }
   
}
