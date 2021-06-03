import java.util.*;
public class M31SubArrayExceedingTarget
{
    public static int subArrayExceedsSum(int arr[], int target )
    {

        if( target <= 0 )
            return 0;

        if( arr.length < 1 )
            return -1;


        int i=0,j=0;
        int sum= arr[i],  subArraySize= Integer.MAX_VALUE;
        while(true){
            if(sum >=target){
                if(i==j) return 1;
                else{
                    if(j-i+1 < subArraySize)
                        subArraySize = j-i+1;
                    sum -= arr[i];
                    i++;
                }
            }
            else{
                j++;
                if(j == arr.length) break;
                else{
                    sum +=arr[j];
                }
            }
        }

        if(subArraySize == Integer.MAX_VALUE) return -1;

        return subArraySize;
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args)
    {
        boolean result = true;
        int[] arr = new int[]{ 1, 2, 3, 4 };
        result = result && subArrayExceedsSum( arr, 6 ) == 2;
        result = result && subArrayExceedsSum( arr, 12 ) == -1;
        result = result && subArrayExceedsSum( arr, 10 ) == 4;
        result = result && subArrayExceedsSum( arr, 4 ) == 1;


        if( result )
        {
            System.out.println("All tests pass\n");
        }
        else
        {
            System.out.println("There are test failures\n");
        }

        int[] arr2 = {};
//   result = result && subArrayExceedsSum( arr2, 0 ) == 0;
        result = result && subArrayExceedsSum( arr2, 2 ) == -1;

        if( result )
        {
            System.out.println("All tests pass\n");
        }
        else
        {
            System.out.println("There are test failures\n");
        }
    }
};