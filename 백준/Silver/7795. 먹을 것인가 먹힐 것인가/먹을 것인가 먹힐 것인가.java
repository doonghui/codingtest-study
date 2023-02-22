import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int cnt;

    static void Sol(Integer[] A, Integer[] B, int x, int y) {
        cnt = 0;
        int tmp = 0;
        for(int i =0; i<x;i++){
            for(int j =tmp; j<y;j++){
                if(A[i] <=B[j]){
                    tmp = j;
                    continue;
                }
                cnt = cnt + y-j;
                break;
            }
        }

    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Integer[] A = new Integer[x];
            Integer[] B = new Integer[y];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < x; j++)
                A[j] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            for (int k = 0; k < y; k++)
                B[k] = Integer.parseInt(st.nextToken());

            Arrays.sort(A,Collections.reverseOrder());
            Arrays.sort(B,Collections.reverseOrder());
            Sol(A,B,x,y);

            bw.write(cnt+"\n");
        }


        br.close();
        bw.flush();
        bw.close();


    }

}