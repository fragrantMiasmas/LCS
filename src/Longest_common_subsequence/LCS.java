/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Longest_common_subsequence;

/**
 *
 * @author ElizabethReed PC
 */
public class LCS {
    
      
    public char[] charA(String str){
        char[] charA = str.toCharArray();
        return charA;
    }
    
    public int[][] LCS_length(char[] x, char[] y){
        int m =  x.length;
        int n = y.length;
        
        int[][] b = new int [n][m]; 
        int[][] c = new int[n+1][m+1];
        
        // row and column 0 are automatically zeros
        for (int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                
                if(x[i-1]==y[j-1]){ //because x,y need to start at 0
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = 1; //where one = diagonal arrow
                    System.out.println(i + ", " + j + " = " + b[i][j]);
                }
                else if(c[i-1][j]>=c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = 2; //where 2 = up arrow
                    System.out.println(i + ", " + j + " = " + b[i][j]);
                }
                else{
                    c[i][j] = c[i][j-1];
                    b[i][j] = 3; //where 3 = side arrow
                    System.out.println(i + ", " + j + " = " + b[i][j]);
                }
            }
        }
        
        //later return 2-d arrays b and c
        return b;
    }
    public void printLCS(int[][] b, char[] x, int i, int j){
        if(i==0 || j==0)
        if(b[i][j] == 1){
            printLCS(b, x, i-1,j-1);
            System.out.println(x[i]);
        }    
        else if(b[i][j] == 2){
            printLCS(b,x,i-1,j);
        }
        else
            printLCS(b,x,i,j-1);
        
    }
    
    public void runAll(){
        
    }
}
