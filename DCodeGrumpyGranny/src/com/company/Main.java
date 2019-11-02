package com.company;

import java.util.Scanner;

public class Main {




    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while (t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int m=sc.nextInt();

             int mod=(int)1e9+7;

            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
                a[i]=a[i]%m;
            }

            int[] b=new int[k+1];
            for(int i=0;i<=k;i++){
                b[i]=0;
            }

            for(int i=n-1;i>=0;i--){
                while(a[i]<=k){
                    if(a[i]==0){
                        a[i]+=m;
                        continue;
                    }
                    if(a[i]==k){
                        b[a[i]]=(b[a[i]]+1)%mod;
                    }else{
                        b[a[i]]=(b[a[i]]+b[a[i]+1])%mod;
                    }
                    a[i]+=m;
                }
            }
            System.out.println(b[1]);
        }
    }
}
