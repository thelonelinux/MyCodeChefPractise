package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while (t-->0){

            int n=sc.nextInt();

            int[][] arr=new int[n][2];

            int[] arr2=new int[9];

            int sum=0;

            Set<Integer> set=new HashSet<>();
            for (int i=0;i<n;i++){
                arr[i][0]=sc.nextInt();



                arr[i][1]=sc.nextInt();

                if (arr[i][0]<=8){
                    if (!set.contains(arr[i][0])){
                        sum=sum+arr[i][1];
                        set.add(arr[i][0]);
                        arr2[arr[i][0]]=arr[i][1];

                    }else {
                        if (arr[i][1]>arr2[arr[i][0]]){
                            sum=sum+arr[i][1]-arr2[arr[i][0]];
                            arr2[arr[i][0]]=arr[i][1];
                        }
                    }

                }

            }
            System.out.println(sum);
        }


    }
}
