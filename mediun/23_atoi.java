import java.util.*;
public class HelloWorld{

    public static int atoi(String input){
        int result=0;
        for(int i=0;i<input.length(); i++){
            // int asciia = str.charAt(i);
            // System.out.println(  asciia);
            result= result*10 + input.charAt(i)-'0';
            // System.out.println( "Result: " +result );
        }

        return result;

    }



    public static void main(String []args){

        System.out.println( atoi("-123"));

    }

}