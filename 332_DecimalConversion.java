// Given a a string of letters and a dictionary, the function longestWord should
//     find the longest word or words in the dictionary that can be made from the letters
//     Input: letters = "oet", dictionary = {"to","toe","toes"}
//     Output: {"toe"}

import java.util.*;

public class Dictionary {
    public static String fractionRepresentation(int num, int den) {
        float fraction = (float)num/(float)den;
        String number= String.valueOf(fraction);

        String[] words= number.split("[.]");
        String sub=words[1];
        String result = words[0];


        String intermediate = "";
        Boolean repeated = false;


        for(int i=0;i<sub.length();i++){
            if(intermediate.length() >0 && (i+intermediate.length()) < sub.length()
                && sub.substring(i,i+intermediate.length()).equals(intermediate)){
                repeated= true;
                break;
            }
            else{
                intermediate= intermediate+ sub.charAt(i);
            }
        }
        if(repeated){
            result = result+ ".(" + intermediate +")";
            return result;
        }

        return number;

    }

    public static void main(String args[]) {
        // float f=6/11f;
        // System.out.println(f);
        System.out.println(fractionRepresentation(1, 2) + " " + fractionRepresentation(1, 3) + " "
            + fractionRepresentation(6, 11));

        if (fractionRepresentation(1, 2).equals("0.5") && fractionRepresentation(6, 11).equals("0.(54)")
            && fractionRepresentation(1, 3).equals("0.(3)")) {
            System.out.println("All passed");
        } else {
            System.out.println("Failed");
        }

    }

}