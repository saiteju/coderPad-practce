import java.util.*;
public class HelloWorld{


    private static void rle(String x){

        int length = x.length();
        for (int i=0;i< length;i++){
            int count =1;
            while (i< length-1 && x.charAt(i) == x.charAt(i+1)){
                count++;
                i++;
            }
            System.out.print(x.charAt(i));
            System.out.print(count);
        }


    }



    public static void main(String []args){

        rle("aaaabb");



    }
}