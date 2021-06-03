import java.util.*;
public class HelloWorld{


    private static double sqrt(double x){

        if(x  == 0 || x==1) return x;
        double temp;
        double sr= x/2;

        do{
            temp=sr;
            sr= (temp+(x/temp))/2;

        }while((temp-sr)!=0);

        return sr;
    }


    public static void main(String []args){

        double result= sqrt(3);

        System.out.println(result);



    }
}