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
class HashNode<K, V> {

    V value;
    K key;

    HashNode(K key, V value) {
        this.value = value;
        this.key = key;
    }
}

class HashTable<K, V> {

    HashNode<K, V>[] arr;
    int capacity;
    int count;

    HashTable(int s) {
        capacity = s + (s / 3);
        capacity = getPrime(capacity);
        arr = new HashNode[capacity];
    }

    private int getPrime(int n) {
        while (true) {
            if (isPrime(n)) {
                return n;
            }
            n++;
        }
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int hashAddress(K key) {
        return key.hashCode() % capacity;
    }

    public double calculateLoadFactor() {
        return count / arr.length;
    }

    public void rehash() {
        HashNode<K, V>[] arr2 = new HashNode[2 * arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        arr = arr2;
    }

    public double calculateThreshold(double loadFactor) {
        return loadFactor * arr.length;
    }

    public int linearProbing(K key, int i) {
        return (key.hashCode() + i) % arr.length;
    }

    public void insertNode(K key, V value) {
        HashNode<K, V> temp = new HashNode<K, V>(key, value);

        // Apply hash function to find index for given key
        int hashIndex = hashAddress(key);
        if (arr[hashIndex] == null) {
            arr[hashIndex] = temp;
            count++;
        } else {
//            int thresholdLimit = (int)calculateThreshold(calculateLoadFactor());
            for (int i = 0; calculateLoadFactor()>0.75 && arr[hashIndex] != null && hashIndex < arr.length; i++) {
//                System.out.println("debug");
                hashIndex = linearProbing(key, i);
            }
            if (arr[hashIndex] == null && hashIndex < arr.length) {
                arr[hashIndex] = temp;
                count++;
            } else {
                System.out.println("debug");
                rehash();
            }

        }

    }

    public V deleteNode(K key) {
        int hashIndex = hashAddress(key);
        if (arr[hashIndex].key == key) {
            arr[hashIndex] = null;
        }
        while (arr[hashIndex] != null) {
            if (arr[hashIndex].key == key) {
                HashNode<K, V> temp = arr[hashIndex];
                arr[hashIndex] = null;
                count--;
                return temp.value;
            }
            hashIndex++;
            hashIndex %= capacity;
        }
        return null;
    }

    public V get(K key) {
        int hashIndex = hashAddress(key);
//        System.out.println("Hash Index " + hashIndex);
        int counter = 0;
        if (arr[hashIndex].key.equals(key)) {
            return arr[hashIndex].value;
        }
        else{
        for (int i = 0; arr[hashIndex].key!=null && hashIndex < count && !arr[hashIndex].key.equals(key) ; i++) {
            hashIndex = linearProbing(key, i);
        }
        if (hashIndex < count && arr[hashIndex].key.equals(key)) {
            return arr[hashIndex].value;
        } else {
            return null;
        }
        }
    }

    public int length() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public String toString() {
        String str = "";
        int currentIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].key != null) {
                str = str + "[" + i + "] " + arr[i].key + ", " + arr[i].value + "\n";
                currentIndex++;
            }
        }
        return str;
    }
    
    public ArrayList<K> getKeys(){
        ArrayList<K> keys = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != null && arr[i].key != null) {
                keys.add(arr[i].key);
            }
        }
        return keys;
    }
    
    public String[] getArrayKeys(){
        String[] keys = new String[arr.length];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != null && arr[i].key != null) {
                keys[i] = String.valueOf(arr[i].key + ", " + arr[i].value);
            }
        }
        return keys;
    }
}
