import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i =0; i< n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int lt = 0;
        int sum =0;
        int cnt =1;
        for(int k =0; k<=x-2;k++)
            sum += arr[k];

        for (int rt= x-1;rt<n;rt++){
            sum += arr[rt];
            if(sum > max) {
                max = sum;
                cnt = 1;
            } else if(sum == max)
                cnt++;
            sum -= arr[lt++];
        }

        if(max == 0){
            bw.write("SAD");
        } else{
            bw.write(max+"\n"+cnt);
        }

        br.close();
        bw.flush();
        bw.close();

    }

}