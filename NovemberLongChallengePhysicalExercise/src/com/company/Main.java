package com.company;

import com.sun.media.sound.MidiOutDeviceProvider;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

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


            /**first red and then green and the destination*/;
            //for source to red;
            double[] sourceToRedDistance=new double[1*red];
            for (int i=0;i<red;i++){
                double cordinateX=Math.pow(Math.abs(source[0]-redArray[i][0]),2);
                double cordinateY=Math.pow(Math.abs(source[1]-redArray[i][1]),2);

                double distanceFromRedToSource=Math.sqrt(cordinateX+cordinateY);

                sourceToRedDistance[i]=distanceFromRedToSource;
                distanceFromRedToSource=0;
            }

            //now from source->red to green;
            double[] sourceToRedDistanceToGreen=new double[1*red*green];
            int c=0;
            for (int i=0;i<red;i++){
               for (int j=0;j<green;j++){

                   double cordinateX=Math.pow(Math.abs(redArray[i][0]-greenArray[j][0]),2);
                   double cordinateY=Math.pow(Math.abs(redArray[i][1]-greenArray[j][1]),2);

                   double distanceFromRedToSourceToGreen=Math.sqrt(cordinateX+cordinateY)+sourceToRedDistance[i];

                   sourceToRedDistanceToGreen[c++]=distanceFromRedToSourceToGreen;
                   distanceFromRedToSourceToGreen=0;

               }
            }

            //now finally to destination; That is from green to destination + preivious total;
            double[] sourceToRedDistanceToGreenToDestination=new double[green*dest];
            int d=0;
            for (int i=0;i<green;i++){
                for (int j=0;j<dest;j++){

                    double cordinateX=Math.pow(Math.abs(greenArray[i][0]-destArrary[j][0]),2);
                    double cordinateY=Math.pow(Math.abs(greenArray[i][1]-destArrary[j][1]),2);

                    double distanceFromRedToSourceToGreenToDestination=Math.sqrt(cordinateX+cordinateY)+sourceToRedDistanceToGreen[i];

                    sourceToRedDistanceToGreenToDestination[d++]=distanceFromRedToSourceToGreenToDestination;
                    distanceFromRedToSourceToGreenToDestination=0;

                }
            }

            /**first green and then red and then distination*/
            //for source to green;
            double[] sourceToGreenDistance=new double[1*green];
            int e=0;
            for (int i=0;i<green;i++){
                double cordinateX=Math.pow(Math.abs(source[0]-greenArray[i][0]),2);
                double cordinateY=Math.pow(Math.abs(source[1]-greenArray[i][1]),2);

                double distanceFromGreenToSource=Math.sqrt(cordinateX+cordinateY);

                sourceToGreenDistance[e++]=distanceFromGreenToSource;
                distanceFromGreenToSource=0;
            }

            //now from source->green to red;
            double[] sourceToGreenDistanceToRed=new double[green*red];
            int f=0;
            for (int i=0;i<green;i++){
                for (int j=0;j<red;j++){

                    double cordinateX=Math.pow(Math.abs(greenArray[i][0]-redArray[j][0]),2);
                    double cordinateY=Math.pow(Math.abs(greenArray[i][1]-redArray[j][1]),2);

                    double distanceFromRedToSourceToGreen=Math.sqrt(cordinateX+cordinateY)+sourceToGreenDistance[i];

                    sourceToGreenDistanceToRed[f++]=distanceFromRedToSourceToGreen;
                    distanceFromRedToSourceToGreen=0;

                }
            }

            // now finally to destination; That is from get to destination+previous total
            double[] sourceToGreenDistanceToRedToDestination=new double[red*dest];
            int g=0;
            for (int i=0;i<red;i++){
                for (int j=0;j<dest;j++){

                    double cordinateX=Math.pow(Math.abs(redArray[i][0]-destArrary[j][0]),2);
                    double cordinateY=Math.pow(Math.abs(redArray[i][1]-destArrary[j][1]),2);

                    double distanceFromRedToSourceToGreenToDestination=Math.sqrt(cordinateX+cordinateY)+sourceToGreenDistanceToRed[i];

                    sourceToGreenDistanceToRedToDestination[g++]=distanceFromRedToSourceToGreenToDestination;
                    distanceFromRedToSourceToGreenToDestination=0;
                }
            }


            /**  now comes to find minimum of them*/

            Arrays.sort(sourceToGreenDistanceToRedToDestination);
            Arrays.sort(sourceToRedDistanceToGreenToDestination);
            double min1=sourceToGreenDistanceToRedToDestination[0];
            double min2=sourceToRedDistanceToGreenToDestination[0];
            double ans=Math.min(min1,min2);

            System.out.printf("%.10f",ans);



        }

    }
}
