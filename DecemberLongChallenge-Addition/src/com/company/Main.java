package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while (t-->0) {

            String A=sc.next();
            String B=sc.next();

            double binaryA=Long.parseLong(A,2);
            double binaryB=Long.parseLong(B,2);


            double count=0;
            double U,V;

            while (binaryB>0){
                U=(long)binaryA^(long)binaryB;
                V=(long)binaryA & (long)binaryB;
                binaryA=U;
                binaryB=V*2;
                count++;

            }

            System.out.println((long)count);

        }
    }
}
