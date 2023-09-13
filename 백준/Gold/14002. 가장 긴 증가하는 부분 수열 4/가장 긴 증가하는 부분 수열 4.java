import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Main {

    static int n;
    static int[] arr;
    static int[] disIdx;
    static ArrayList<Integer> dis;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        disIdx = new int[n];
        dis = new ArrayList<>();



        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] =  Integer.parseInt(st.nextToken());
        }

        sol();

        int size = dis.size()-1;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int k = disIdx.length-1;k>=0;k--) {
            if(disIdx[k] == size) {
                ans.add(arr[k]);
                size--;
            }
        }

        br.close();
        bw.write(dis.size()+"\n");

        for(int z = ans.size()-1;z>=0;z--) {
            bw.write(ans.get(z)+" ");
        }

        bw.flush();
        bw.close();

    }


    static void sol() {
        dis.add(arr[0]);
        disIdx[0] = 0;
        int idx = 0;
        for(int i=1;i<n;i++) {
            if(dis.get(dis.size()-1) <arr[i]) {
                idx++;
                dis.add(arr[i]);
                disIdx[i] = idx;
            } else {
                int tmp = binarySearch(0,dis.size()-1,i);
                dis.set(tmp,arr[i]);
                disIdx[i] = tmp;
                }


            }

        }
    static int binarySearch(int left,int right,int find) {
        int mid;
        if (dis.get(0) > arr[find]) return 0;

        while(left <=right) {
            mid = (left+right) /2;

            if(dis.get(mid) < arr[find]) {
                left = mid +1;
            } else if(dis.get(mid) > arr[find]) {
                right = mid -1;
            } else
                return mid;


        }
        return left;
    }

    }





