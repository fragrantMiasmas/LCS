/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Longest_common_subsequence;

import java.util.HashMap;

/**
 *
 * @author ElizabethReed PC
 */
public class LCS {

    public int[][] LCS_length(char[] x, char[] y) {
        int m = x.length;
        int n = y.length;

        int[][] b = new int[n][m];
        int[][] c = new int[n + 1][m + 1];

        // row and column 0 are automatically zeros
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int ci = i + 1; //c needs to be up by one
                int cj = j + 1;

                if (x[i] == y[j]) { //because x,y need to start at 0
                    c[ci][cj] = c[ci][cj - 1] + 1;
                    b[i][j] = 1; //where one = diagonal arrow
                    System.out.println(i + ", " + j + " = " + b[i][j]);
                } else if (c[ci - 1][cj] >= c[ci][cj - 1]) {
                    c[ci][cj] = c[ci - 1][cj];
                    b[i][j] = 2; //where 2 = up arrow
                    System.out.println(i + ", " + j + " = " + b[i][j]);
                } else {
                    c[ci][cj] = c[ci][cj - 1];
                    b[i][j] = 3; //where 3 = side arrow
                    System.out.println(i + ", " + j + " = " + b[i][j]);
                }
            }
        }
        return b;
    }
//    public void printLCS(int[][] b, char[] x, int i, int j){
//        if(i==0 || j==0){
//            
//        }
//        if(b[i][j] == 1){
//            printLCS(b, x, i-1,j-1);
//            System.out.println(x[i]);
//        }    
//        else if(b[i][j] == 2){
//            printLCS(b,x,i-1,j);
//        }
//        else
//            printLCS(b,x,i,j-1);
//        
//    }

    public void printLCS(int[][] b, char[] x, int i, int j) {
        if (i == 0 || j == 0) {
            //does nothing
        }

        int curr = b[i][j];
        switch (curr) {
            case 1:
                printLCS(b, x, i - 1, j - 1);
                System.out.println(x[i]);
                break;
            case 2:
                printLCS(b, x, i - 1, j);
                break;
            default:
                printLCS(b, x, i, j - 1);
        }

    }

    public void dynamicLCS(String u, String v) {
        char[] x = u.toCharArray();
        char[] y = v.toCharArray();

        int[][] b = LCS_length(x, y);
        printLCS(b, x, x.length - 1, y.length - 1);
    }
    
    public StringBuilder base10to2(int middleman) { //base 10 number is our middleman
        
        StringBuilder sb = new StringBuilder();
        
        //divide method
        int remainder = middleman % 2;
        sb.append(remainder); 

        int semi_quotient = (middleman - remainder) / 2;

        while (semi_quotient != 0) {

            remainder = semi_quotient % 2; // until your semi quotient reaches zero
            sb.append(remainder); // add to stringbuilder
            
            semi_quotient = (semi_quotient - remainder) / 2;

        }
        return(sb.reverse());

    }

    HashMap<Integer, StringBuilder> hmap = new HashMap<Integer, StringBuilder>();

    public void findsub(String u) { //find subsequences of first string
        char[] charA = u.toCharArray();
        int c = (int) Math.pow(2, charA.length); //2^n for binary counter
        int[] counter = new int[c]; //create binary number array
        
        for (int i = 0; i < c; i++) { //find all subsequences of x

            for (int j = i; j < u.length(); j++) {
                StringBuilder sb = new StringBuilder(); //new stringbuilder every loop iteration
                char curr = u.charAt(i); // includes trivial cases
                sb.append(curr);
                //if new combo
                hmap.put(j, sb);
                
                
            }
        } //end of outer loop
        //still need to account for nonconsecutive sequences
    }

    public void bruteForce(String u, String v) {

        findsub(u); //find all subsequences of u
        for (int i = 0; i < v.length(); i++) {
            //see if substring in u is also in v
            hmap.get(i);
        }
    }
}
