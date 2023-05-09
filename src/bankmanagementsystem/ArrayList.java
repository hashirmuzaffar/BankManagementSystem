/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanagementsystem;

/**
 *
 * @author wfati
 */
public class ArrayList {
    
    
 String[] arr;
 int currIndex;
 String rand;

ArrayList() { // default constructor to create an array
 arr = new String[10];
 currIndex=-1;
 }
ArrayList(int size) { // constructor to create an array
 arr = new String[size];
 currIndex=-1;
 }
 public void PrintList(){
 for(int i=0; i<arr.length;i++)
 System.out.print(arr[i]+" ");
 System.out.println();
 }
public void insert(String v) {
 if (currIndex==arr.length-1) {
 String [] arr_new=new String[arr.length*2];
 for(int i=0; i<arr.length; i++){
     arr_new[i]=arr[i];
 }
 arr = arr_new;
 }
 if (currIndex==-1){
 currIndex++;
 arr[currIndex] = v;
 }
 else{
     currIndex++;
     arr[currIndex]=v;
 }
 /*for (int i = 0; i < currIndex; i++)   
{  
for (int j = i + 1; j < currIndex; j++)   
{  
String tmp = "";  
if (arr[i].compareTo(arr[j])>0)   
{  
tmp = arr[i];  
arr[i] = arr[j];  
arr[j] = tmp;  
}
} 
}*/
//currIndex++;
//arr[currIndex]=v;
//Arrays.sort(arr,0,currIndex+1); 
}
public int Length(){
 // return length of occupied list
    return arr.length;
 }


public String get(int index) {
 // get element at given index location
    return arr[index];
 }

public void Update (int index, String value) {
  arr[index]=value;

 }
public boolean Find (String value) {
 // if the value found in array then return its index
   for(int i = 0; i<currIndex; i++){
       if (arr[i].compareTo(value)==0)
           return true;
   } 
   return false;
 }
public void Remove (String value) {
 // first find the value in an array then delete the value through
 // backward movement in an array.
    boolean found= false;
    int index = 0;
    for(int i =0; i<arr.length; i++){
        if(arr[i].compareTo(value)==0){
            found=true;
            index=i;
            break;
        }
    }
    if(found==false)
        System.out.println("The value is not available in the array.");
    else{
        currIndex--;
        for(int i=index;i<arr.length-1; i++){
            arr[i]=arr[i+1];
        }        
        arr[arr.length-1]="";
    }
}
}