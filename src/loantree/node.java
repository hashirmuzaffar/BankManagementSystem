/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loantree;

/**
 *
 * @author hashi
 */
public class node {

    node yes;
    node no;
    node maybe;
    String Question;
    String answer;
    
    public node(String Question, String Answer) {
        this.Question = Question;
        this.answer = Answer;
    }

}
