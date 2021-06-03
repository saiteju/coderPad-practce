// Given a a string of letters and a dictionary, the function longestWord should
//     find the longest word or words in the dictionary that can be made from the letters
//     Input: letters = "oet", dictionary = {"to","toe","toes"}
//     Output: {"toe"}

import java.util.*;

public class Dictionary {
    public static Integer optimalPath(Integer[][] grid)
    {

        Integer rowcount = grid.length;
        Integer colcount = grid[0].length;

        if(rowcount == 0 || colcount == 0)
            return 0;


        for(Integer row =rowcount-1;row>=0;row--){
            for(Integer col =0; col<colcount;col++){
                if(row<rowcount-1 && col>0)
                    grid[row][col] += Math.max(grid[row+1][col], grid[row][col-1]);
                else if(row<rowcount-1)
                    grid[row][col] +=grid[row+1][col];
                else if(col>0)
                    grid[row][col] +=grid[row][col-1];
            }
        }

        Integer count = grid[0][colcount-1];
        System.out.println(count);
        return count;

    }

    public static boolean doTestsPass()
    {
        boolean result = true;
        // Base test case
        result &= optimalPath(new Integer[][]{{0,0,0,0,5},
            {0,1,1,1,0},
            {2,0,0,0,0}}) == 10;
        // Random numbers
        result &= optimalPath(new Integer[][]{{1,3,2,0,2,1,8},
            {3,4,1,2,0,1,1},
            {1,1,1,2,3,2,1},
            {1,0,1,1,4,2,1}}) == 25;
        // All 0's
        result &= optimalPath(new Integer[][]{{0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}}) == 0;
        // Many optimal paths
        result &= optimalPath(new Integer[][]{{1,1,1,1,1},
            {1,0,1,0,1},
            {1,0,1,0,1},
            {1,1,1,1,1}}) == 8;
        // Empty grid
        result &= optimalPath(new Integer[][]{{}}) == 0;

        return result;
    }

    public static void main(String[] args)
    {
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }
    }
}