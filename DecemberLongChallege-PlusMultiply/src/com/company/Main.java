package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while (t-->0){

            int n=sc.nextInt();

            int[] arr=new int[n];
            int count=0;
            int extra=0;

            for (int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();
                if (arr[i]==2){
                    count++;
                }
                if (arr[i]==0){
                    extra++;
                }
            }
            if (extra!=0){
                System.out.println(count-1);

            }
            else {
                System.out.println(count-1+extra-1);
            }




        }
    }
}
