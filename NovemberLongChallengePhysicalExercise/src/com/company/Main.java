package com.company;

import com.sun.media.sound.MidiOutDeviceProvider;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static double getDistance(int x1,int y1, int x2, int y2){

        double cordinateX=Math.pow(Math.abs(x1-x2),2);
        double cordinateY=Math.pow(Math.abs(y1-y2),2);

        double distance=Math.sqrt(cordinateX+cordinateY);

        return distance;

    }

    public static void main(String[] args) {
	// write your code here

        try{

            Scanner sc=new Scanner(System.in);

            int t=sc.nextInt();

            while (t-->0){

                int[] source=new int[2];

                source[0]=sc.nextInt();
                source[1]=sc.nextInt();

                int n=sc.nextInt();
                int m=sc.nextInt();
                int k=sc.nextInt();

                int red=n;
                int green=m;
                int dest=k;

                int[][] redArray=new int[red][2];
                for (int i=0;i<red;i++){
                    redArray[i][0]=sc.nextInt();
                    redArray[i][1]=sc.nextInt();
                }

                int[][] greenArray=new int[green][2];
                for (int i=0;i<green;i++){
                    greenArray[i][0]=sc.nextInt();
                    greenArray[i][1]=sc.nextInt();
                }

                int[][] destArrary=new int[dest][2];
                for (int i=0;i<dest;i++){
                    destArrary[i][0]=sc.nextInt();
                    destArrary[i][1]=sc.nextInt();
                }

                double min1=Integer.MAX_VALUE;

                for (int i=0;i<green;i++){
                    double sourceToGreen=getDistance(source[0], source[i],greenArray[i][0],greenArray[i][1]);

                    for (int j=0;j<red;j++){
                        double sourceToGreenToRed=getDistance(redArray[j][0],redArray[j][1],greenArray[i][0],greenArray[i][1])+sourceToGreen;

                        for (int l=0;l<dest;l++){
                            double sourceToGreenToRedToDest=getDistance(redArray[j][0],redArray[j][1],destArrary[l][0],destArrary[l][1])+sourceToGreenToRed;

                            min1=Math.min(min1,sourceToGreenToRedToDest);
                        }
                    }

                }


                double min2=Integer.MAX_VALUE;

                for (int i=0;i<red;i++){
                    double sourceToGreen=getDistance(source[0], source[1],redArray[i][0],redArray[i][1]);

                    for (int j=0;j<green;j++){
                        double sourceToGreenToRed=getDistance(greenArray[j][0],greenArray[j][1],redArray[i][0],redArray[i][1])+sourceToGreen;

                        for (int l=0;l<dest;l++){
                            double sourceToGreenToRedToDest=getDistance(greenArray[j][0],greenArray[j][1],destArrary[l][0],destArrary[l][1])+sourceToGreenToRed;

                            min2=Math.min(min2,sourceToGreenToRedToDest);
                        }
                    }

                }

                double ans=Math.min(min1,min2);

                System.out.printf("%.10f",ans);
                System.out.println();



            }

        }
        catch (Exception e){
            return;
        }



    }
}
