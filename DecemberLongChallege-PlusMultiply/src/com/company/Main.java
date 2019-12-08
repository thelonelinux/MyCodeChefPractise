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

            for(int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }

            for (int i=0;i<arr.length;i++){

                if (arr[i]==2){
                    for (int j=i+1;j<arr.length;j++){
                        if(arr[j]==2){
                            count++;
                        }
                    }
                }

                if (arr[i]==0){
                    for (int k=i+1;k<arr.length;k++){
                        if (arr[k]==0){
                            extra++;
                        }
                    }

                }
            }
//            if (extra!=0){
//                System.out.println(count-1);
//
//            }
//            else {
//                System.out.println(count-1+extra-1);
//            }

            System.out.println(extra+count);




        }
    }
}
