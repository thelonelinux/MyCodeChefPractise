package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        List<Integer> list=new ArrayList<>();

        for (int i=0;i<n;i++){

            int num=sc.nextInt();


            if (num==1){

                //enter the value to be entered

                int value=sc.nextInt();

                int size=list.size();

                if (size==0){
                    list.add(value);

                }

                if (size==1){
                    list.add(value);

                }

                if (size%2==0  && size!=0){
 in

                }
            }
        }
    }
}
