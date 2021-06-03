// Given a a string of letters and a dictionary, the function longestWord should
//     find the longest word or words in the dictionary that can be made from the letters
//     Input: letters = "oet", dictionary = {"to","toe","toes"}
//     Output: {"toe"}

import java.util.*;

public class Solution {

    /**
     * Given a log file, return IP address(es) which accesses the site most often.
     */

    public static String findTopIpaddress(String[] lines) {
        // Your code goes here
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        String highestIp;
        String[] ipAddresses = new String[lines.length];
        int j=0;
        for(String line : lines){

            String[] words =  line.split(" ");
            ipAddresses[j] = words[0];
            j++;
        }


// 	for(int i= 0;i<ipAddresses.length;i++)
// 	System.out.println(ipAddresses[i]);

        for(String ip : ipAddresses){
            if(!hm.containsKey(ip)){
                hm.put(ip, 1);
            }else{
                int count = hm.get(ip);
                hm.put(ip, count+1);
            }
        }

// 	System.out.println(hm);

        highestIp = ipAddresses[0];
// 		System.out.println(highestIp);
        int highest =1;

        for(Map.Entry<String, Integer> ip: hm.entrySet()){
            if(ip.getValue() > highest){
                highestIp = ip.getKey();
                highest= ip.getValue();
            }

        }

        return highestIp;
    }


    public static void main(String[] args) {

        String lines[] = new String[] {
            "10.0.0.1 - log entry 1 11",
            "10.0.0.1 - log entry 2 213",
            "10.0.0.2 - log entry 133132",
            "10.0.0.2 - log entry 133132",
            "10.0.0.2 - log entry 133132",
            "10.0.0.2 - log entry 133132"
        };
        String result = findTopIpaddress(lines);

        if (result.equals("10.0.0.2")) {
            System.out.println("Test passed");

        } else {
            System.out.println("Test failed");

        }

    }

}



