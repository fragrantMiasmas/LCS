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
public class Dynamic {

    public int[][] LCS_length(char[] x, char[] y) {
        int m = x.length;
        int n = y.length;

        int[][] b = new int[m][n];
        int[][] c = new int[m + 1][n + 1];

        // row and column 0 are automatically zeros
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int ci = i + 1; //c needs to be up by one
                int cj = j + 1;

                if (x[i] == y[j]) { //because x,y need to start at 0
                    c[ci][cj] = c[ci - 1][cj - 1] + 1;
                    b[i][j] = 1; //where one = diagonal arrow
                    //System.out.println(i + ", " + j + " = " + b[i][j]);
                } else if (c[ci - 1][cj] >= c[ci][cj - 1]) {
                    c[ci][cj] = c[ci - 1][cj];
                    b[i][j] = 2; //where 2 = up arrow
                    //System.out.println(i + ", " + j + " = " + b[i][j]);
                } else {
                    c[ci][cj] = c[ci][cj - 1];
                    b[i][j] = 3; //where 3 = side arrow
                    //System.out.println(i + ", " + j + " = " + b[i][j]);
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
        if (i < 0 || j < 0) {
            //does nothing
            return;
        }

        int curr = b[i][j];
        switch (curr) {
            case 1:
                //System.out.printf("Case 1 at (%d,%d)\n", i, j);
                printLCS(b, x, i - 1, j - 1);
                System.out.print(x[i]);
                break;
            case 2:
                //System.out.printf("Case 2 at (%d,%d)\n", i, j);
                printLCS(b, x, i - 1, j);
                break;
            default:
                //System.out.printf("Case 3 at (%d,%d)\n", i, j);
                printLCS(b, x, i, j - 1);
        }

    }

    public void dynamicLCS(String u, String v) {
        char[] x = u.toCharArray();
        char[] y = v.toCharArray();

        int[][] b = LCS_length(x, y);
        printLCS(b, x, x.length - 1, y.length - 1);
        System.out.println();
    }
   

}
