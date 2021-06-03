import java.util.*;
public class HelloWorld{

    public static char findFirst(String input)
    {
        HashMap<Character, Boolean> map = new HashMap<Character,Boolean>();

        for (int i=0;i< input.length();i++){
            if(map.containsKey(input.charAt(i))){
                map.replace(input.charAt(i), false);
            }else{
                map.put(input.charAt(i), true);
            }
        }
        for (int i=0;i< input.length();i++){
            if(map.get(input.charAt(i)))
                return input.charAt(i);
        }
        return '0';
    }


    public static void main(String args[])
    {

        String[] inputs = {"aappll","racecars", "ababdc"};
        char[] outputs = {'a', 'e', 'd' };

        for(int i = 0; i < inputs.length; i++ )
            System.out.println(findFirst(inputs[i]));

        boolean result = true;
        for(int i = 0; i < inputs.length; i++ )
        {
            result = result && findFirst(inputs[i]) == outputs[i];
            if(!result)
                System.out.println("Test failed for: " + inputs[i]);
            else
                System.out.println("Test passed for: " + inputs[i]);
        }
    }
}