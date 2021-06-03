import java.util.*;
public class HelloWorld{


    private static int[] addFraction(int[] f1, int[] f2){
        return new int[]{ (f1[0]*f2[1])+ (f1[1]*f2[0]) , f1[1]* f2[1]};
    }


    public static void main(String []args){

        int[] result= addFraction(new int[]{2,3}, new int[]{1,2});

        System.out.println(result[0]+ " "+ result[1]);



    }
}



//import java.util.*;
//
//class GFG
//{
//    static int den3, num3;
//
//    // Function to return gcd of a and b
//    static int gcd(int a, int b)
//    {
//        if (a == 0)
//            return b;
//        return gcd(b % a, a);
//    }
//
//    // Function to convert the obtained fraction
//// into it's simplest form
//    static void lowest()
//    {
//        // Finding gcd of both terms
//        int common_factor = gcd(num3, den3);
//
//        // Converting both terms into simpler
//        // terms by dividing them by common factor
//        den3 = den3 / common_factor;
//        num3 = num3 / common_factor;
//    }
//
//    // Function to add two fractions
//    static void addFraction(int num1, int den1,
//        int num2, int den2)
//    {
//        // Finding gcd of den1 and den2
//        den3 = gcd(den1, den2);
//
//        // Denominator of final fraction obtained
//        // finding LCM of den1 and den2
//        // LCM * GCD = a * b
//        den3 = (den1 * den2) / den3;
//
//        // Changing the fractions to have
//        // same denominator.
//        // Numerator of the final fraction obtained
//        num3 = (num1) * (den3 / den1) +
//            (num2) * (den3 / den2);
//
//        // Calling function to convert final fraction
//        // into it's simplest form
//        lowest();
//    }
//
//    // Driver Code
//    public static void main(String[] args)
//    {
//        int num1 = 1, den1 = 500,
//            num2 = 2, den2 = 1500;
//
//        addFraction(num1, den1, num2, den2);
//
//        System.out.printf("%d/%d + %d/%d is equal to %d/%d\n",
//            num1, den1, num2, den2, num3, den3);
//    }
//}