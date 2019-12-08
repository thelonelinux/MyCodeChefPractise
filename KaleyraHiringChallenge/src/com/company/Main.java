package com.company;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String[] temp=br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        int X = Integer.parseInt(temp[2]);  //MaxPossible
        int[] a = new int[N];  //initial
        int[] b = new int[N];  //final
        for(int i_b=0; i_b<N; i_b++)
        {
            String[] a_b = br.readLine().split(" ");
            a[i_b] = Integer.parseInt(a_b[0]);
            b[i_b] = Integer.parseInt(a_b[1]);
        }
        String[] arr_c = br.readLine().split(" ");
        int[] c = new int[M];  //New Employee
        for(int i_c=0; i_c<arr_c.length; i_c++)
        {
            c[i_c] = Integer.parseInt(arr_c[i_c]);
        }

        int out_ = solve(a, c, b, M, N, X);
        System.out.println(out_);

        wr.close();
        br.close();
    }
    static int solve(int[] a, int[] c, int[] b, int M, int N, int X){
        // Write your code here

        Set<Integer> set=new HashSet<>();
        for (int i=0;i<b.length;i++){
            if (b[i]<=X){
                set.add(b[i]);
            }
        }

        for (int i=0;i<c.length;i++){
            if (c[i]<=X){
                set.add(c[i]);
            }
        }
        return set.size();

    }
}