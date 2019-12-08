package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());

            long out_ = CountWays(N);
            System.out.println(out_);
        }

        wr.close();
        br.close();
    }
    static long CountWays(int N){
        // Write your code here

        if(N==1){
            return 1;
        }
        int[][][] arr=new int[N][N][N];
        int[] num=new int[10000001];
        int l=0;

        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                for (int k=0;k<N;k++){
                    arr[i][j][k]=(i+1)+(2*(j+1))+(k+1);
                    num[l++]=arr[i][j][k];
                }
            }
        }

        int[][][] arr2=new int[N][N][N];
        int[] divisor=new int[10000001];
        int m=0;

        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                for (int k=0;k<N;k++){
                    arr2[i][j][k]=(i+1)+(2*(k+1))+(j+1);
                    divisor[m++]=arr2[i][j][k];
                }
            }
        }
        long count=0;

        for (int i=0;i<m;i++){
            for (int j=0;j<l;j++){
                if (num[j]%divisor[i]==0){
                    count++;
                }
            }
        }

        return count;

    }



}
