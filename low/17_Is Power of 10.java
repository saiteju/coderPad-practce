import java.util.*;
public class Solution {

    public static Boolean isPowerof10(int input) {

        while(input>1){
            if(input%10 !=0)
                return false;
            input= input/10;
        }

        return true;

    }


    public static void main(String[] args) {
        System.out.println(isPowerof10(100));
        System.out.println(isPowerof10(110));
        System.out.println(isPowerof10(1101));

    }
}