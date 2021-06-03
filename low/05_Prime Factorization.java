import java.util.*;
public class HelloWorld{

    public static ArrayList<Integer> primeFactorization(int input)
    {
        ArrayList<Integer> primeFactors = new ArrayList<Integer>();
        if( input < 2 )
            return primeFactors;
        for(int i = 2; i <= input; i++)
        {
            System.out.println("i == "+i);
            //  System.out.println("input =="  +input );

            while( input % i == 0 )
            {
                System.out.println("i1 =="+i);
                input = input / i;
                System.out.println("input =="  +input );
                primeFactors.add(i);
            }


        }
        return primeFactors;
    }


    public static void main(String []args){

        //  System.out.println(primeFactorization(42) +" \n" + primeFactorization(5));
        System.out.println(primeFactorization(1));





    }
}