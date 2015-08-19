/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.util.*;

/**
 *
 * @author JP
 */
public class Anagram {
    public static void check_anagrams(String[] firstWords, String[] secondWords) {
        // Write your code here
        // To print results to the standard output you can use System.out.println()
        // Example: System.out.println("Hello world!");
        String s1 = new String();
        String s2 = new String();
        
        for(int i=0;i<100;i++){
            if(firstWords[i].length() != secondWords[i].length()){
                break;
            }
            else{
                s1=sortCharacters(firstWords[i]);
                s2=sortCharacters(secondWords[i]);
                
                if (s1.equals(s2)){
                    System.out.println(s1 + " is anagram of " + s2);
                    
                }
            }
        }
        
    }
    
    public static String sortCharacters(String str){
        char[] cArray = str.toLowerCase().toCharArray();
        Arrays.sort(cArray);
        return String.valueOf(cArray);
    }   
}
