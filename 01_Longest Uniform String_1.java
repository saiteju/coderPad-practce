/**
 *
 *  e.g.
 *      for the input: "abbbccda" the longest uniform substring is "bbb" (which starts at index 1 and is 3 characters long).
 */

import java.util.*;
public class HelloWorld{

    private static final Map<String, int []> testCases = new HashMap<String, int[]>();

    static int [] longestUniformSubstring(String input){

        if(input.length() <1){
            return new int[]{-1,0};
        }

        int longeststart = -1, longestlength =0, start =0, count =1;
        for (int i=1;i< input.length(); i++){
            if (input.charAt(i) == input.charAt(i-1)){
                count++;
            }
            else{
                if(count> longestlength ){
                    longestlength = count;
                    longeststart= start;
                }
                start =i;
                count =1;
            }
        }
        if(count > longestlength){
            // System.out.println(" count " + count);
            // System.out.println(" longestlength " + longestlength);

            longestlength = count;
            longeststart = start;
        }

        return new int[]{longeststart, longestlength};
    }

    public static void main(String []args){

        testCases.put("", new int[]{-1, 0});
        testCases.put("abcd", new int[]{0, 1});
        testCases.put("10000111", new int[]{1, 4});
        testCases.put("abb", new int[]{1, 2});

        boolean pass = true;
        for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
            int[] result = longestUniformSubstring(testCase.getKey());
            System.out.println(Arrays.toString(result));

            pass = Arrays.equals(result, testCase.getValue());
            if(pass){
                System.out.println("String : "+ testCase.getKey());
                System.out.println("Pass!" );
            } else {
                System.out.println("Failed! ");
            }
        }

    }
}