/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Longest_common_subsequence;

import java.util.ArrayList;

/**
 *
 * @author jamie
 */
public class BruteForceAlt {
    
    public ArrayList<String> ex1 = new ArrayList<>();
    public ArrayList<String> ex2 = new ArrayList<>();
    
    public void getSubStrings(String str, ArrayList<String> lst) {
        int len = str.length();
        for (int i = 0; i < 1<<len; i++) {
            StringBuilder substring = new StringBuilder(len);
            //System.out.printf("starting with i = %d\n", i);
            int j = 0;
            int k = i;
            while (k >= 1) {
                if ((k & 1) == 1) {
                    substring.append(str.charAt(j));
                }
                j++;
                k /= 2;
//                System.out.printf("shifting, i = %d\n", i);
            }
            String retval = substring.toString();
            lst.add(retval);
        }
        //System.out.println(lst);
    }
    
    public String longestCommonSubstring(String str1, String str2) {
        getSubStrings(str1,ex1);
        //System.out.println(ex1);
        getSubStrings(str2,ex2);
        //System.out.println(ex2);
        String longest = "";
        int len1 = ex1.size();
        int len2 = ex2.size();
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                //System.out.printf("comparing %d, %d\n",i,j);
                if (ex1.get(i).equals(ex2.get(j))) {
                    //System.out.println("Found a Match!");
                    String common = ex1.get(i);
                    if (common.length() > longest.length()) {
                        longest = common;
                    }
                }
            }
        }
        return longest;
    }
    
    public void bruteForceLCS(String u, String v) {
        String lcs = longestCommonSubstring(u,v);
        System.out.println(lcs);
    }
    
}
