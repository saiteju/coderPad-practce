import java.util.*;
public class M31SubArrayExceedingTarget
{
    public static int[] walk(String path) {

        int i=0, j=0;

        for(char c: path.toCharArray()){
            if(c == 'U')  j +=1;
            if(c == 'D')  j -=1;
            if(c == 'L')  i -=1;
            if(c == 'R')  i +=1;

        }

        return new int[]{i,j};


    }

    public static boolean isEqual(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    public static boolean pass() {
        boolean res = true;

        {
            String test = "UUU";
            int[] result = walk(test);
            res &= isEqual(result, new int[]{0, 3});
        }

        {
            String test = "ULDR";
            int[] result = walk(test);
            res &= isEqual(result, new int[]{0, 0});
        }

        {
            String test = "ULLLDUDUURLRLR";
            int[] result = walk(test);
            res &= isEqual(result, new int[]{-2, 2});
        }

        {
            String test = "UP LEFT 2xDOWN DOWN RIGHT RIGHT UP UP";
            int[] result = walk(test);
            res &= isEqual(result, new int[]{1, 1});
        }

        return res;
    }

    public static void main(String[] args) {
        if(pass()){
            System.out.println("Pass");
        } else {
            System.out.println("Test failures");
        }
    }
};