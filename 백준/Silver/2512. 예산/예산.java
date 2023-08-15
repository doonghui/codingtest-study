import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int n,m;
    static int[] arr;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        int sum = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        m =Integer.parseInt(br.readLine());

        Arrays.sort(arr);


        if(sum <=m) bw.write(arr[arr.length-1]+"");
        else {
            bw.write(binarySearch()+"");
        }

        bw.flush();
        br.close();
        bw.close();

    }


    static int binarySearch() {
        int lt = 0;
        int rt = arr[arr.length-1];
        int mid = 0;
        int sum = 0;

        while(lt <= rt) {
            mid = (lt + rt) / 2;
            sum = findMax(mid);

             if(sum > m) {
                 rt = mid -1;
             } else if (sum < m) {
                 lt = mid +1;
             } else {
                 return mid;
             }

        }
        if(sum > m ) return mid-1;
        else {
            return mid;
        }


    }

    static int findMax(int mid) {
        int tmp = 0;
        for(int i =0; i<n;i++) {
            if(arr[i] <mid) tmp += arr[i];
            else {
                tmp += mid;
            }
        }

        return tmp;

    }


}




