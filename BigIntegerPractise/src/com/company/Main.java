package com.company;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.function.BinaryOperator;

public class Main {

    static boolean isPerfectSquare(double x) {

        // Find floating point value of
        // square root of x.
        double sr = Math.sqrt(x);

        // If square root is an integer
        return ((sr - Math.floor(sr)) == 0);
    }


    public static void main(String[] args) throws java.lang.Exception {
	// write your code here
        /** some part working rest all TLE in codechef
         * Even after some optimization its showing TLE only,
         * I optimize by traversing only last three elements rather than all and adding first upto n-3 digit directly in the sumOfSquares ot save some time*/

        try{

            BufferInput in = new BufferInput();

            int t=in.nextInt();

            while (t-->0){

                int numOfDigits=in.nextInt();

                int[] arr=new int[]{0,1,34,122,1111,11123,111112,1111124,11111113,111111111,1111111114};

                if(numOfDigits<=10){
                    System.out.println(arr[numOfDigits]);
                }

                String str="";

                for (int i=0;i<numOfDigits;i++){
                    str+='1';
                }

                if (isPerfectSquare(numOfDigits) && numOfDigits>10){
                    System.out.println(str);
                }

                BigInteger value=new BigInteger(str);

                BigInteger one=BigInteger.ONE;
                int sumOfSquares=0;
                int a=1;

                if (numOfDigits>10  &&  !isPerfectSquare(numOfDigits)){
                    int firstupto4thlast=numOfDigits-3;

                    while (a==1){

                        String string=value.toString();
                        for (int i=firstupto4thlast;i<string.length();i++){
                            if (string.charAt(i)=='0'){
                                sumOfSquares=0;
                                break;
                            }
                            int num=string.charAt(i)-48;
                            sumOfSquares+=Math.pow(num,2);
                        }
                        if (sumOfSquares!=0){

                            if (isPerfectSquare(sumOfSquares+firstupto4thlast)){
                                a=0;
                                System.out.println(value.toString());
                                break;
                            }

                        }

                        sumOfSquares=0;
                        value=value.add(one);
                    }

                }


            }

        }
        catch (Exception e){
            return;
        }

    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }


    static class BufferInput {

        /**
         *  A constant holding default buffer size, 2<sup>16</sup> bytes of memory.
         *
         **/
        final private int BUFFER_SIZE = 1 << 16;

        private DataInputStream din;

        private byte[] buffer;

        private int bufferPointer, bytesRead;

        public BufferInput() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public BufferInput(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        /**
         * Reads the input bytes until it encounters a new line char.
         * @return
         * @throws IOException
         */
        public String readLine() throws IOException {
            byte[] buf = new byte[64];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        /**
         *
         * @return
         * @throws IOException
         */
        public String nextString() throws IOException{

            // Skip all whitespace characters from the stream
            byte c = read();
            while(Character.isWhitespace(c)){
                c = read();
            }

            StringBuilder builder = new StringBuilder();
            builder.append((char)c);
            c = read();
            while(!Character.isWhitespace(c)){
                builder.append((char)c);
                c = read();
            }

            return builder.toString();
        }

        /**
         * Reads an integer value.
         * @return
         * @throws IOException
         */
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }


        /**
         * Reads an array of integers.
         * @return
         * @throws IOException
         */
        public int[] nextIntArray(int n) throws IOException {
            int arr[] = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = nextInt();
            }
            return arr;
        }


        /**
         * Reads a long value.
         * @return
         * @throws IOException
         */
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }


        /**
         * Reads an array of long integers.
         * @return
         * @throws IOException
         */
        public long[] nextLongArray(int n) throws IOException {
            long arr[] = new long[n];
            for(int i = 0; i < n; i++){
                arr[i] = nextLong();
            }
            return arr;
        }

        /**
         *
         * @return
         * @throws IOException
         */
        public char nextChar() throws IOException{
            byte c = read();
            while(Character.isWhitespace(c)){
                c = read();
            }
            return (char) c;
        }


        /**
         * Reads a double value.
         * @return
         * @throws IOException
         */
        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        /**
         * Reads an array of double values.
         * @return
         * @throws IOException
         */
        public double[] nextDoubleArray(int n) throws IOException {
            double arr[] = new double[n];
            for(int i = 0; i < n; i++){
                arr[i] = nextDouble();
            }
            return arr;
        }

        /**
         * Fills the buffer from input stream.
         *
         * @throws IOException
         */
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        /**
         *
         * @return
         * @throws IOException
         */
        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}


