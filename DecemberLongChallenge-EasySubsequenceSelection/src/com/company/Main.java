package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while (t-->0){
            int n=sc.nextInt();

            String str=sc.next();

            int count=0;
            HashSet<Character> set=new HashSet<>();

            for (char c : str.toCharArray()){

                if (!set.contains(c)){
                    set.add(c);
                }
                else {
                    count++;
                }
            }

            System.out.println(count);
        }

    }
}
