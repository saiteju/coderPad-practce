import java.util.*;
public class Solution {

    public static String reverseString(String input) {
        StringBuilder sb= new StringBuilder();
        for (int i= input.length()-1 ; i>=0;i--){
            sb.append(input.charAt(i));
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(reverseString("abcde1"));
    }
}