import java.util.*;
public class HelloWorld{

    static public double power(double base, int exp) {
        if(base==0) return 0;
        if(exp==0) return 1;
        if(exp==1) return base;
        int positiveExp = (exp<0) ? exp*-1: exp;
        double result= (positiveExp%2==0)?
            power(base*base,positiveExp/2):
            base*power(base*base,(positiveExp-1)/2);
        return exp<0 ? 1/result:result;
    }



    public static void main(String []args){
        System.out.println(power(2, 4));
        System.out.println(power(3, 3));
        System.out.println(power(0, 3));


    }
}