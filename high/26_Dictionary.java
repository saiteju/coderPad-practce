// Given a a string of letters and a dictionary, the function longestWord should
//     find the longest word or words in the dictionary that can be made from the letters
//     Input: letters = "oet", dictionary = {"to","toe","toes"}
//     Output: {"toe"}

import java.util.*;

class Dictionary {
    private String [] entries;

    public Dictionary(String[] entries){
        this.entries=entries;
    }

    public boolean contains(String word){
        return Arrays.asList(entries).contains(word);
    }
}

public class Solution {
    public static Set<String> longestWord(String letters, Dictionary dict) {

        int longest =0;
        Set<String> result = new HashSet<String>();
        char[] arr= letters.toCharArray();

        Set<String> words= new HashSet<String>();
        permute(arr, 0, dict, words);

        for (String word: words){
            if(word.length() > longest){
                result.clear();
                result.add(word);
                longest= word.length();
            }else if (word.length()== longest){
                result.add(word);
            }
        }

        return result;

    }

    public static void permute (char[] arr, int index, Dictionary dict, Set<String> words){
        if(arr.length == index){
            combination(arr, dict,words);
        }else {
            for(int i=index;i<arr.length;i++){
                arr=swap(arr,i, index);
                permute(arr, index+1,dict, words);
                arr=swap(arr, index, i);
            }
        }
    }

    public static void combination (char[] arr, Dictionary dict, Set<String> words){
        StringBuffer sb= new StringBuffer();
        for(int i=0;i< arr.length;i++){
            sb.append(arr[i]);
            if(dict.contains(sb.toString()))
                words.add(sb.toString());
        }
    }

    public static char[] swap (char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;

        return arr;

    }



    public static boolean doTestsPass() {
        Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"});

        boolean result = new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
        result = result && new HashSet<String>(Arrays.asList("toes", "dogs")).equals(longestWord("osetdg", dict));

        return result;
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args) {
        if(doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.err.println("There are test failures");
        }
    }

}