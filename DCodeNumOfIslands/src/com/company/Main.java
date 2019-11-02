package com.company;

import java.util.Scanner;

public class Main {



    static  int ROW , COL ;

    // A function to check if a given cell (row, col) can
    // be included in DFS
   static boolean isSafe(int M[][], int row, int col,
                   boolean visited[][])
    {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);
    }

    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    static void DFS(int M[][], int row, int col, boolean visited[][])
    {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int rowNbr[] = new int[] {  -1, 0, 0,  1 };
        int colNbr[] = new int[] {  0, -1, 1,  0 };

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 4; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }

    // The main function that returns count of islands in a given
    // boolean 2D matrix
    static int countIslands(int M[][])
    {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[ROW][COL];

        // Initialize count as 0 and travese through the all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j] == 1 && !visited[i][j]) // If a cell with
                { // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS(M, i, j, visited);
                    ++count;
                }

        return count;
    }

    // Driver method
    public static void main(String[] args) throws java.lang.Exception
    {


        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int row=sc.nextInt();
            int col=sc.nextInt();
            ROW=row;
            COL=col;

            int[][] arr=new int[row][col];

            for (int i=0;i<row;i++){
                for (int j=0;j<col;j++){
                    arr[i][j]=sc.nextInt();
                }
            }

            int first=countIslands(arr);

            for (int i=0;i<row;i++){
                for (int j=0;j<col;j++){
                    if (arr[i][j]==0){
                        arr[i][j]=1;

                    }
                    else if(arr[i][j]==1) {
                        arr[i][j]=0;
                    }
                }
            }
            int second=countIslands(arr);
            int ans=Math.min(first,second);

            if (row==col && col==1){
                System.out.println(1);
            }
            else {
                System.out.println(ans);

            }

        }
    }
}