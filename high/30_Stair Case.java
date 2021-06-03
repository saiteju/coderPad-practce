// Given a a string of letters and a dictionary, the function longestWord should
//     find the longest word or words in the dictionary that can be made from the letters
//     Input: letters = "oet", dictionary = {"to","toe","toes"}
//     Output: {"toe"}

import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        System.out.println(countSteps(3));

    }

    static int countSteps(int totalSteps){
        // this follows fibbonacci series when value should be sum of last 3 elements (as kid can take upto 3 steps at a time)
        // but there is one thing to notice, the value of ways(n) is equal to fibonacci(n+1).
        // 0 1 1 2 4 7 13....

        return fib(totalSteps+1);

    }

    static int fib(int steps){
        if(steps <=1) return steps;
        if(steps ==2) return 1;

        return fib(steps-1)+fib(steps-2)+fib(steps-3);
    }




}