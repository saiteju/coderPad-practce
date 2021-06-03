// Given a a string of letters and a dictionary, the function longestWord should
//     find the longest word or words in the dictionary that can be made from the letters
//     Input: letters = "oet", dictionary = {"to","toe","toes"}
//     Output: {"toe"}

import java.util.*;

public class Solution {

    static private int minimalSteps( String ingredients )
    {
        int n = ingredients.length();


        StringBuffer sb = new StringBuffer();

        sb.append(ingredients.charAt(0));

        for(int i=1; i < n;i++) {
            if(i *2<=n){
                String tocompare = ingredients.substring(0, i);
                if(tocompare.equals(ingredients.substring(i, i*2))){
                    sb.append("*");
                    i= i*2 -1;
                }
                else{
                    sb.append(ingredients.charAt(i));
                }
            }
            else{
                sb.append(ingredients.charAt(i));
            }
        }

        System.out.println(sb.toString());
        return sb.toString().length();

    }

    public static void main(String[] args) {

        if (minimalSteps("ABABCABABCE") == 6 && minimalSteps("ABCABCE") == 5) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }


}