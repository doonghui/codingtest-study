import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Main {

    //    static Queue<Integer> q1,q2,q3,q4;
    static ArrayList[] arr;
    static int[][] check;
    static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;


        arr = new ArrayList[5];
        check = new int[5][2];
        arr[1] = new ArrayList<>();
        arr[2] = new ArrayList<>();
        arr[3] = new ArrayList<>();
        arr[4] = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i].add(str.charAt(j));

            }
        }


        k = Integer.parseInt(br.readLine());

        for (int j = 0; j < k; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sol(a, b);
        }

        int sum =0;
        // 2가 북
        for(int l =1;l<=4;l++) {
            if((char)arr[l].get(0) == '1') sum += (int)Math.pow(2,l-1);
        }


        bw.write(sum+"");
        bw.flush();
        br.close();
        bw.close();
    }

    // 6 과 2가 동,서, 0가 북
    static void sol(int num, int dir) {
        int[] direction = new int[5];
        if (num == 1) {
            direction[num] = dir;
            for (int i = 2; i <= 4; i++) {
                if (arr[i].get(6) != arr[i - 1].get(2)) {
                    dir *= -1;
                    direction[i] = dir;
                } else break;
            }
        } else if (num == 2) {
            direction[num] = dir;
            if (arr[1].get(2) != arr[num].get(6)) {
                direction[1] = dir * -1;
            }
                for (int i = 3; i <= 4; i++) {
                    if (arr[i].get(6) != arr[i - 1].get(2)) {
                        dir *= -1;
                        direction[i] = dir;
                    } else break;
                }

        } else if (num == 3) {
            direction[num] = dir;
            if (arr[4].get(6) != arr[num].get(2)) {
                direction[4] = dir * -1;
            }
                for (int i = 2; i >= 1; i--) {
                    if (arr[i].get(2) != arr[i + 1].get(6)) {
                        dir *= -1;
                        direction[i] = dir;
                    } else break;
                }



        } else if (num == 4) {
            direction[num] = dir;
            for (int i = 3; i >= 1; i--) {
                if (arr[i].get(2) != arr[i + 1].get(6)) {
                    dir *= -1;
                    direction[i] = dir;
                } else break;
            }


        }

        rotate(direction);
    }

    static void rotate(int[] direction) {
        for (int i = 1; i <= 4; i++) {
            if (direction[i] == -1) {
                char temp = (char) arr[i].get(0);
                for (int j = 0; j <7; j++) {
                    arr[i].set(j,arr[i].get(j+1));
                }
                arr[i].set(7,temp);
            } else if(direction[i] == 1) {
                char temp = (char) arr[i].get(7);
                for(int j=7;j>0;j--) {
                    arr[i].set(j,arr[i].get(j-1));
                }
                arr[i].set(0,temp);
            }
        }
    }


}