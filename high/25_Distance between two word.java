import java.util.*;
public class M31SubArrayExceedingTarget
{
    public static double shortestDistance(String _paragraph, String word1, String word2) {

        int wordIndex=0;
        double word1Location=0, word2Location=0;
        double shortd= _paragraph.length();

        String[] words= _paragraph.split("[,. ]");

        for(String word: words){
            if(word.equalsIgnoreCase(word1))
                word1Location = wordIndex+ (word1.length() /2d);
            else if(word.equalsIgnoreCase(word2))
                word2Location = wordIndex+(word2.length()/2d);


            if(word1Location >0 && word2Location>0){
                double currentDistance = Math.abs(word1Location-word2Location);
                if(currentDistance < shortd)
                    shortd = currentDistance;
            }
            wordIndex += word.length()+1;
        }

        if(word1Location ==0 || word2Location==0) {  return -1; }

        return shortd;
    }



    public static boolean doTestsPass() {
        // todo: implement more tests if you'd like
        return  shortestDistance(_paragraph, "and", "graphic") == 6d &&
            shortestDistance(_paragraph, "transfer", "it") == 14d &&
            shortestDistance(_paragraph, "Design", "filler" ) == 25d;
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args) {
        // Run the tests
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }

    private static final String _paragraph;
    static{
        StringBuffer sb = new StringBuffer();
        sb.append("In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements");
        sb.append(" lorem ipsum text has been used in typesetting since the 1960s or earlier, when it was popularized by advertisements");
        sb.append(" for Letraset transfer sheets. It was introduced to the Information Age in the mid-1980s by Aldus Corporation, which");

        _paragraph = sb.toString();
    }
};