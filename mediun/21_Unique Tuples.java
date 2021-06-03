import java.util.*;
public class HelloWorld{

    public static HashSet<String> uniqueTuples(String input, int len){
        HashSet<String> result= new HashSet<String>();
        for(int i=0; i< input.length()-len+1;i++){
            result.add(input.substring(i, i+len));
        }

        return result;
    }



    public static void main(String []args){
        String input = "aaab";
        HashSet<String> result = uniqueTuples( input,2 );
        if( result.contains( "aa" ) && result.contains( "ab" ) ) {
            System.out.println( "Test passed." );

        } else {
            System.out.println( "Test failed." );

        }

    }
}