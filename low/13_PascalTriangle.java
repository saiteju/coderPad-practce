// Given a a string of letters and a dictionary, the function longestWord should
//     find the longest word or words in the dictionary that can be made from the letters
//     Input: letters = "oet", dictionary = {"to","toe","toes"}
//     Output: {"toe"}

import java.util.*;

public class PascalTriangle_13 {

    public static void main(String[] args) {
        System.out.println(getElementFromTriangle(6,3));
        System.out.println(getElementFromTriangle(3,2));
        System.out.println(getElementFromTriangle(7,6));
        System.out.println(getElementFromTriangle(9,5));
        System.out.println(getElementFromTriangle(7,7));
        //   getElementFromTrianglel(3,2) ==  2 &&
        //getElementFromTriangle(7,6) ==  6 &&
        //getElementFromTriangle(9,5) ==  70 &&
        // getElementFromTriangle(7,7) ==  1)
    }


    // time and space complx n^2
    static int getElementFromTriangle(int row, int index){

        int[][] triangle = new int[row][row];

        for(int i=0;i<row;i++){
            for(int j=0;j<=i;j++){
                triangle[i][j]= fetchValue(triangle, i,j);
                if(i==row-1 && j== index-1){
                    return triangle[i][j];
                }
            }
        }

        return 0;

    }

    static int fetchValue(int[][] triangle, int i, int j){
        if(j==0 || i==j){
            return 1;
        }

        else if(i<0  || j<0) return 0;

        return fetchValue(triangle, i-1,j-1)+fetchValue(triangle, i-1,j);
    }


}