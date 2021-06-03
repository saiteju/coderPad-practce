import java.util.*;
public class HelloWorld{

    static public int highestAverage(String[][] scores) {
        if(scores== null || scores.length <=0){
            return -1;
        }
        int highestAve=0;
        Map<String, List<Integer>> map= new HashMap<>();

        for (int i=0; i<scores.length; i++){
            List<Integer> scoreList = map.get(scores[i][0]);
            if(scoreList == null){
                List<Integer> currentScore = new ArrayList<>();
                currentScore.add(Integer.valueOf(scores[i][1]));
                map.put(scores[i][0], currentScore);
            }else{
                scoreList.add(Integer.valueOf(scores[i][1]));
                map.put(scores[i][0], scoreList);
            }
        }

        for(Map.Entry<String, List<Integer>> entry: map.entrySet()){
            int average = getAverageScore(entry.getValue());
            highestAve = Math.max(highestAve, average);
        }
        return highestAve;
    }

    static private int  getAverageScore(List<Integer> scores){
        int len= scores.size();
        int sum=0;
        for(int score: scores){
            sum += score;
        }
        int avg= sum/len;
        return avg;

    }


    public static void main(String []args){
        String[][] s1 = { { "Rohan", "84" }, { "Sachin", "102" }, { "Ishan", "96" }, { "Sachin", "100" } };

        // 		String[][] s2 = {};
        System.out.println(highestAverage(s1));

    }
}