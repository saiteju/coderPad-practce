import java.util.*;
public class HelloWorld{

    static int FindSecondMin(int[] input){


        if(input.length < 1)
            return 0;
        if(input.length < 2) return input[0];

        int min= Integer.MAX_VALUE, min1= Integer.MAX_VALUE;
        for (int i=0;i< input.length;i++){
            if(input[i] <=  min){
                min1= min;
                min=input[i];
            }
            else if(input[i] < min1){
                min1= input[i];
            }
        }

        return min1;

    }


    public static void main(String []args){

        int[] a = { 3, 7 , 9, 5 };
        int[] b = { 0, 4 };



        System.out.println(FindSecondMin(a));
        System.out.println(FindSecondMin(b));



    }
}