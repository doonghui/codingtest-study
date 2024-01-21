import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        arr = new int[N];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') arr[i] = 0;
            else
                arr[i] = 1;
        }

        int answer = Math.min(sol(0),sol(1));



        bw.write(answer+"");
        br.close();
        bw.flush();
        br.close();
    }

    static int sol(int num) {
        int count1 = 0;
        boolean check = false;
        for(int i = N-1;i>=0;i--) {
            if(arr[i] == num) {
              if(check) {
                count1++;
              }
            } else {
                if(!check) check = true;
            }
        }
        int count2 = 0;
        check = false;
        for(int j = 0;j<N;j++) {
            if(arr[j] == num) {
                if(check) {
                    count2++;
                }
            } else {
                if(!check) check = true;
            }
        }

        return Math.min(count1,count2);
    }


}
