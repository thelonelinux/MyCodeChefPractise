package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner sc=new Scanner(System.in);

        int t;
        int n,i,j;
        long[] A=new long[128];
//        memset(A,-1,sizeof(A));
        Arrays.fill(A,-1);
        A[0]=0;
        A[1]=0;
        long[] B=new long[128];
//        memset(B,-1,sizeof(B));
        Arrays.fill(B,-1);
        B[0]=0;

//        map<long,long>mp;

        for(i=0;i<127;i++)
        {
            if(B[(int)A[i]]!=-1)
            {
                A[i+1]=i-B[(int)A[i]];
            }
            else
            {
                A[i+1]=0;
            }
            B[(int)A[i]]=i;
        }


        t=sc.nextInt();
        while(t-->0)
        {
           n=sc.nextInt();

            j=0;
            for(i=0;i<n;i++)
            {
                if(A[n-1]==A[i])
                    j++;
            }

//            cout<<j;
//            cout<<endl;

            System.out.println(j);

        }
    }
}
