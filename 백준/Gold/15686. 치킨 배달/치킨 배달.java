import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Chicken {
    int x;
    int y;
    public Chicken(int x, int y ) {
        this.x = x;
        this.y = y;
    }
}

class House {
    int x;
    int y;
    public House(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class Main {

    static int n,m;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Chicken> chickens;
    static ArrayList<House> house;



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        chickens = new ArrayList<>();
        house = new ArrayList<>();
        map = new int[n][n];

        for(int i=0; i<n;i++) {
            st = new StringTokenizer(br.readLine()," ");

            for(int j=0;j<n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    house.add(new House(i,j));
                }
                if(map[i][j] == 2) {
                    chickens.add(new Chicken(i,j));
                }
            }
        }
        boolean[] chickensCheck = new boolean[chickens.size()];


        dfs(0,0,chickensCheck);


        bw.write(min+"");
        bw.flush();     // 출력
        br.close();
        bw.close();

    }


    static void dfs(int dept,int idx,boolean[] chickensCheck) {
        if(dept == m) {
            int distance = 0;
            int tmp = Integer.MAX_VALUE;
            int sum = 0;
            for(House h : house) {
                for(int j =0; j<chickensCheck.length;j++) {
                    if(chickensCheck[j]) {
                        distance = Math.abs(h.x-chickens.get(j).x) + Math.abs(h.y-chickens.get(j).y);
                        tmp = Math.min(tmp,distance);           // 집에서 가장 가까운 치킨집
                    }
                }
                sum += tmp;                             // 도시의 치킨거리
                tmp = Integer.MAX_VALUE;
            }
            min = Math.min(min,sum);

          return;
        }
        for(int i=idx; i<chickens.size();i++) {           // 조합으로 치킨 뽑기
            if(!chickensCheck[i]) {
                chickensCheck[i] = true;
                dfs(dept+1,i+1,chickensCheck);
                chickensCheck[i] = false;
            }


        }




    }

}




