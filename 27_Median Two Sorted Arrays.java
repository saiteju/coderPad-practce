import java.util.*;
public class M16CountLengthOfCycle {

    public static int median(int[] a, int[] b)
    {
        int[] mergedArray= merge(a, b);
        Arrays.sort(mergedArray);
        for(int i=0;i< mergedArray.length;i++){
            System.out.print( mergedArray[i] + " ");

        }
        return findMedian(mergedArray);

    }

    private static int findMedian(int[] sorted){
        int length= sorted.length;
        int index1=0;
        int index2=0;
        if(length%2 ==0){
            index1= length/2;
            index2= index1+1;
            return (sorted[index1-1]+sorted[index2-1])/2;
        }else{
            index1=length/2 +1;
            return sorted[index1-1];
        }
    }

    private static int[] merge(int[] a, int[] b){
        int[] mergedArray= new int[a.length+b.length];
        int mergeIndex=0;
        for(int i=0;i< a.length;i++){
            mergedArray[mergeIndex]= a[i];
            mergeIndex++;
        }
        for(int i=0;i<b.length;i++){
            mergedArray[mergeIndex]= b[i];
            mergeIndex++;
        }

        return mergedArray;
    }

    public static void main( String[] args ) {

        int[] a={1,5};
        int[] b= {4,3};
        System.out.println( median(a,b));
        int[] a1= new int[]{1,5};
        int[] b1= new int[]{3};
        System.out.println( median(a1,b1));

    }
}