/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loantree;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hashi
 */
public class LoanTree {

    node top;
    static int count = 0;
    public static boolean eligible=false;

    public void Tree(String q, String a) {
        node newnode = new node(q, a);
        if (top == null) {
            top = newnode;
        } else {
            node last = null;
            node curr = top;
            while (curr != null) {
                last = curr;
                curr = curr.yes;
            }
            last.yes = newnode;
            last.no = newnode;
            last.maybe = newnode;
        }
    }

    public void CreatTree() {
        try {
            File file = new File("TEST.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                String[] arr = s.split("_");
               if(arr.length==2)
                this.Tree(arr[0], arr[1]);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void gothru() {
        try {
            File file = new File("Answers.txt");
            Scanner s = new Scanner(file);
            node temp= top;
            boolean RightAnswer = false;
            String S;
            while (s.hasNextLine()) {
                 S = s.nextLine();
                 //temp = top;
                while (temp != null) {
                    if (S.equals(temp.answer)) {
                        RightAnswer = true;
                        if(S.equals("yes")){
                        temp = temp.yes;
                        count++;}
                        else if(S.equals("maybe")){
                        temp = temp.maybe;
                        count++;}
                        else if(S.equals("no")){
                        temp = temp.maybe;
                        count++;}
                    }
                    
                    else {
                        RightAnswer = false;
                         temp = temp.no;
                    }
                break;
                }
            }
            s.close();
            if (count > 10) {
                this.eligible=true;
               System.out.println("You can get a loan "+ count);
            } else {
                this.eligible=false;
                System.out.println("You can not get a loan" + count);
            }
            count=0;
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void print(node n) {
        if (n == null) {
            return;
        } else {
            print(n.yes);
            System.out.println(n.Question + " " + n.answer);
            print(n.no);
        }
    }
    
    public boolean CallTree(){
    this.CreatTree();
    this.gothru();
    return this.eligible;
    }
    
  

}
