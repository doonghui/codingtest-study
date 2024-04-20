import java.util.*;
import java.io.*;

class Solution {

    static char[] arr;
    static int change;
    static int[] map;
    static int answer;


    public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int n = 1;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String num = st.nextToken();
            change = Integer.parseInt(st.nextToken());
            arr = num.toCharArray();
            answer = 0;

             if(change > num.length()) change = num.length();
//            if (arr.length == 1) {
//                bw.write("#" + n + " " + num + "\n");
//            } else if (arr.length == 2) {
//                if (change % 2 == 0) bw.write("#" + n + " " + num + "\n");
//                else
//                    bw.write("#" + n + " " + arr[1] + arr[0] + "\n");
//            } else {

//            map = new int[num.length()];

//            for(int k =0;k<num.length();k++) map[k] = num.charAt(k) - '0';


                dfs(0,0);

                bw.write("#" + n + " " + answer + "\n");

//            }


            n++;

        }

        bw.flush();
        br.close();
        bw.close();

    }

    static void dfs(int idx,int cnt) {
        if(cnt ==change) {
            String str = new String(arr);

            answer = Math.max(answer,Integer.parseInt(str));
//            StringBuilder str = new StringBuilder();
//            for(int i =0;i<map.length;i++) {
//                str.append(map[i]);
//            }
////            String str = Arrays.toString(map).replaceAll("[^0-9]","");
//
//            answer = Math.max(answer,Integer.parseInt(str.toString()));


            return;
        }
//        for(int i =idx;i<map.length-1;i++) {
//            for(int j = i+1;j<map.length;j++) {
//                    swap(i,j);
//                    dfs(i,cnt+1);
//                   swap(i,j);
//
//            }
//
//        }

        for(int i =idx;i<arr.length-1;i++) {
            for(int j = i+1;j<arr.length;j++) {
                    char tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    dfs(i,cnt+1);
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;



            }

        }




    }

    public static void swap(int a, int b) {
        int tmp = map[a];
        map[a] = map[b];
        map[b] = tmp;
    }


}