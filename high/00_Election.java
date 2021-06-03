import java.util.*;
public class M31SubArrayExceedingTarget
{
    public static int whoIsElected(int n, int k) {

        if(n==1) return 1;
        return (whoIsElected(n-1, k) +k-1)%n+1;
    }

    public static int whoIsElected2(int n, int k) {
        LinkedList<Integer> list= new LinkedList<>();
        for (int i=1;i<=n;i++)
            list.add(i);

        int i=-1;

        while(list.size()>1){
            list.remove((i+k)%list.size());
            i=(i+k)%(list.size()+1) -1;
        }

        return list.getFirst();
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args)
    {
        int[][] testCases = {
            {1, 1, 1},
            {2, 2, 1},
            {4, 2, 1},
            {100, 2, 73},
            {5, 3, 4},
            {6, 4, 5},
            {1000, 5, 763}
        };
        // int[][] testCases = {
        //         {4, 2, 1},

        //     };
        for (int[] testCase : testCases) {
            int answer = whoIsElected2(testCase[0], testCase[1]);
            if (answer != testCase[2]) {
                System.out.println("test failed!");
                System.out.printf("n:%d, k%d, answer got: %d, should be: %d\n", testCase[0], testCase[1], answer, testCase[2]);

            }
        }
        System.out.println("All tested passed");
    }
};