import java.util.*;
public class HelloWorld{


    static public String panagram(String s) {


        Map<Character, Boolean> map= new HashMap<>();
        for(char c: s.toLowerCase().toCharArray()){
            map.put(c, true);
        }

        StringBuilder sb= new StringBuilder();
        for(char c='a' ; c<='z'; c++){
            if(!map.containsKey(c))
                sb.append(c);
        }

        return sb.toString();
    }



    public static void main(String []args){
        String sentence = "The quick brown fox jumps over the lazy dog";

        System.out.println(panagram(sentence));

        String sentence1 = " jumps over the lazy dog";

        System.out.println(panagram(sentence1));


    }
}