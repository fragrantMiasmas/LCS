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
public class Longest_common_subsequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LCS LCS = new LCS();
        Timer TM = new Timer();
        
        String ex = "ABCD";
        String ex2 = "ACBD";
        
        char[] b = ex.toCharArray();
        char[] x = ex2.toCharArray();
        
//        LCS.printLCS(b, x, 0, 0);
          LCS.LCS_length(b, x);
        
        
    }
    
}
