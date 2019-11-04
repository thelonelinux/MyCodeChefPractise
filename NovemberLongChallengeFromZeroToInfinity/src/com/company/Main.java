package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static boolean aliceProperty(String str){

        int vCount=0;
        int cCount=0;

        for(int i = 0; i < str.length(); i++) {
            //Checks whether a character is a vowel
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                //Increments the vowel counter
                vCount++;
            }
            //Checks whether a character is a consonant
            else if(str.charAt(i) >= 'a' && str.charAt(i)<='z') {
                //Increments the consonant counter
                cCount++;
            }
        }

        if (vCount>=cCount){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
	// write your code here

        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        while (t-->0){

            int n=sc.nextInt();

            String[] alice;
            int a=0;
            String[] bob;
            int b=0;

            String[] arr=new String[n];

            for (int i=0;i<arr.length;i++){

                arr[i]=sc.next();

                if (aliceProperty(arr[i])){
                    a++;
                }
                else {
                    b++;
                }

            }

            alice=new String[a];
            bob=new String[b];
            int c=0;
            int d=0;

            for (int i=0;i<arr.length;i++){

                arr[i]=sc.next();

                if (aliceProperty(arr[i])){
                    alice[c++]=arr[i];
                }
                else {
                    bob[d++]=arr[i];
                }

            }

            HashMap<Character,Integer> mapAliceFX=new HashMap<>();

            for (int i=0;i<alice.length;i++){
                for (char m : alice[i].toCharArray()){
                   if( mapAliceFX.containsKey(m)){
                       int count=mapAliceFX.get(m);
                       mapAliceFX.put(m,count+1);
                   }
                   else {
                       mapAliceFX.put(m,1);
                   }
                }
            }

           HashMap<Character,Integer> mapAliceX=new HashMap<>(mapAliceFX);

            for (int i=0;i<alice.length;i++){
                for (char m : alice[i].toCharArray()){

                    if (mapAliceFX.)
                }
            }




        }

    }
}
