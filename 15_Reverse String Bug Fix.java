import java.util.*;
public class HelloWorld{


    static public String reverse(String s) {

        StringBuilder sb= new StringBuilder();

        sb.append(s);
        sb.reverse();
        return sb.toString();
    }



    public static void main(String []args){
        String sentence = "abcbs";

        System.out.println(reverse(sentence));




    }
}