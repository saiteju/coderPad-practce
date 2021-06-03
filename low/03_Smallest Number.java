import java.util.*;
public class HelloWorld{

    static int FindMin(int[] input){
        if (input.length <=0)
            return 0;

        int min = input[0];

        for(int i=0;i< input.length;i++){
            if(input[i]< min)
                min= input[i];
        }
        return min;

    }


    public static void main(String []args){


        System.out.println(FindMin(new int[]{3,4,5,6,1,2}));
        System.out.println(FindMin(new int[]{2,1}));
        System.out.println(FindMin(new int[]{1}));
        System.out.println(FindMin(new int[]{}));



    }
}