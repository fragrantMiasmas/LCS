package Longest_common_subsequence;

import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ElizabethReed PC
 */
public class BruteForce {
    
    
    HashMap<Integer, StringBuilder> hmap = new HashMap<Integer, StringBuilder>();
    
     public boolean trueFalse(int remainder){
        return remainder == 1;
    }
    
   
    //converts base 10 number to boolean array
    public boolean[] boolArray(int middleman, int n) { //goes to base 2
        boolean[] TF = new boolean[n];
        
        //divide method
        int remainder = middleman % 2;
        TF[n-1]= trueFalse(remainder); //start at end of array
        
        int semi_quotient = (middleman - remainder) / 2;
        
        int i = n-2;
        while (semi_quotient != 0) {

            remainder = semi_quotient % 2; // until your semi quotient reaches zero
            TF[i]= trueFalse(remainder);
            i--;
            semi_quotient = (semi_quotient - remainder) / 2;

        }
       return TF;
    }
 
    
     public void findSubstrings(String input, int n, int c){ 
         char[] charA = input.toCharArray();
        //increment base 10 number 0-n
        //where c is number of characters in original array
         for(int i = 0; i < n; i++){ //increment number by one
             boolean[] counter = boolArray(i, n); //convert number to binary
             StringBuilder sb = new StringBuilder(); //new stringbuilder every loop iteration
             
             for (int j = 0; j<c; j++){ //go through each index
                 if (counter[j]){ //if index is true
                    //append char[j] to array
                    sb.append(charA[j]);
                    hmap.put(j, sb); //later have stringbuilder?
             }
             }
             
         }
     }

    public void bruteForce(String u, String v) {
        int exU = (int) Math.pow(2, u.length());
        int exV = (int) Math.pow(2, v.length());
        findSubstrings(u, exU, u.length());
        findSubstrings(u, exV, v.length());
    }
}
