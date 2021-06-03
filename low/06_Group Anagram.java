import java.util.*;
public class HelloWorld{

    public static void printAnagram(String string){

        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        String[] wordList= string.split(" ");


        for(String word: wordList){
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String newWord= new String(letters);
            if(map.containsKey(newWord)){
                map.get(newWord).add(word);
            }
            else{
                List<String> words = new ArrayList<String>();
                words.add(word);
                map.put(newWord, words);
            }
        }

        for(String s: map.keySet()){
            if(map.get(s).size() > 1){
                for(String w: map.get(s))
                    System.out.print(w + " ");
            }
        }
    }


    public static void main(String []args){

        String anagram = "cat dog tac sat tas god dog";
        printAnagram(anagram);

    }
}





//import java.util.*;
//
//public class FindAnagrams {
//
//    private static void printAnagrams(String arr[])
//    {
//        HashMap<String, List<String> > map = new HashMap<>();
//
//        // loop over all words
//        for (int i = 0; i < arr.length; i++) {
//
//            // convert to char array, sort and
//            // then re-convert to string
//            String word = arr[i];
//            char[] letters = word.toCharArray();
//            Arrays.sort(letters);
//            String newWord = new String(letters);
//
//            // calculate hashcode of string
//            // after sorting
//            if (map.containsKey(newWord)) {
//
//                map.get(newWord).add(word);
//            }
//            else {
//
//                // This is the first time we are
//                // adding a word for a specific
//                // hashcode
//                List<String> words = new ArrayList<>();
//                words.add(word);
//                map.put(newWord, words);
//            }
//        }
//
//        // print all the values where size is > 1
//        // If you want to print non-anagrams,
//        // just print the values having size = 1
//        // for (String s : map.keySet()) {
//        //     List<String> values = map.get(s);
//        //     if (values.size() > 1) {
//        //         System.out.print(map.get(s) + "");
//        //     }
//        // }
//
//        for(String s: map.keySet()) {
//            if(map.get(s).size() >  1) {
//                for(String word: map.get(s)) {
//                    System.out.print(word + " ");
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args)
//    {
//
//        // Driver program
//        String arr[] = { "cat", "dog", "tac", "god", "act"  };
//        printAnagrams(arr);
//    }
//}