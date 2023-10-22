import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static int n;
    static int[] roads;
    static int[] city;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        roads = new int[n-1];
        city = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n-1; i++) {
            roads[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }
        int minGas = city[0];
        long min = (long) minGas * roads[0];
        for(int j =1; j<n-1;j++) {
            if(city[j] < minGas) minGas = city[j];

            min += minGas * roads[j];
        }




        bw.write(min+"");
        br.close();
        bw.flush();
        bw.close();

    }





}