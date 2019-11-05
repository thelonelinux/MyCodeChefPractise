package com.company;

import java.util.Scanner;

public class Main {

    static boolean isPerfectSquare(double x)
    {

        // Find floating point value of
        // square root of x.
        double sr = Math.sqrt(x);

        // If square root is an integer
        return ((sr - Math.floor(sr)) == 0);
    }

    public static void main(String[] args) {
	// write your code here

        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while (t-->0){

            int numOfDigits=sc.nextInt();


            double startNum=Math.pow(10,numOfDigits-1);
            double endNum=Math.pow(10,numOfDigits);

            int[] arr=new int[]{0,1,34,122,1111,11123,111112,1111124,11111113,111111111,1111111114};

            if(numOfDigits<=10){
                System.out.println(arr[numOfDigits]);
            }
//            else if(numOfDigits>10){
                double sumOfSquare=0;

                for (int i=(int)startNum;i<(int)endNum;i++){
                    String str=String.valueOf(i);
                    for (int j=str.length()-4;j<str.length();j++){
                        if (str.charAt(j)=='0'){
                            sumOfSquare=0;
                            break;
                        }
                        int num=str.charAt(j)-48;
                         sumOfSquare+=Math.pow(num,2);
                    }
                    sumOfSquare+=str.length()-4;
                    if (isPerfectSquare(sumOfSquare) && sumOfSquare>0){
                        System.out.println(i);
                        break;
                    }
                    sumOfSquare=0;
                }

          //  }


        }
    }
}
