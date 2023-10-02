import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] people;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        people = new int[n+1][n+1];

        int peopleNum = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                people[i][j] = Integer.parseInt(st.nextToken());
                peopleNum += people[i][j];
            }
        }

        for(int x =1 ; x<=n;x++) {
            for(int y = 1; y <=n;y++) {
                for(int d1 = 1;d1<=n;d1++) {
                    for(int d2 = 1; d2<=n;d2++) {
                        if((x + d1 + d2) > n) continue;
                        if((y-d1) < 1) continue;
                        if((y+d2) >n) continue;
                        election(x,y,d1,d2,peopleNum);

                    }
                }
            }
        }





        bw.write(min + "");
        bw.flush();     
        br.close();
        bw.close();


    }

    static void election(int x,int y, int d1, int d2,int peopleNum) {
        int[][] map = new int[n+1][n+1];

        for(int i = 0;i<= d1;i++) {
            map[x+i][y-i] = 5;
            map[x+d2+i][y+d2-i] = 5;
        }

        for(int i = 0;i<= d2;i++) {
            map[x+i][y+i] = 5;
            map[x+d1+i][y-d1+i] = 5;
        }

        int[] peopleSum = new int[5];
        // 1번
        for(int r = 1;r<x+d1;r++) {
            for(int c = 1;c<=y;c++) {
                if(map[r][c] == 5) break;
                peopleSum[0] += people[r][c];
            }
        }
        // 2번
        for(int r = 1;r<=x+d2;r++) {
            for(int c = n;c>=y+1;c--) {
                if(map[r][c] == 5) break;
                peopleSum[1] += people[r][c];

            }
        }
        // 3번
        for(int r = x+d1;r<=n;r++) {
            for(int c = 1;c<y-d1+d2;c++) {
                if(map[r][c] == 5) break;
                peopleSum[2] += people[r][c];

            }
        }
        // 4번
        for(int r = x+d2+1;r<=n;r++) {
            for(int c =n;c>= y-d1+d2;c--) {
                if(map[r][c] == 5) break;
                peopleSum[3] += people[r][c];
            }
        }
        peopleSum[4] = peopleNum - (peopleSum[0]+peopleSum[1]+peopleSum[2]+peopleSum[3]);

        Arrays.sort(peopleSum);

        min = Math.min(min,peopleSum[4]-peopleSum[0]);



    }

}
