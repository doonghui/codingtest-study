import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Point implements Comparable<Point> {
    int key;
    int value;


    public Point(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Point po) {
        if (this.value == po.value) return this.key - po.key;

        return this.value - po.value;
    }
}

class Main {

    static int r, c, k;
    static ArrayList<ArrayList<Integer>> arr;
    static boolean isRow = true;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();

        for(int z = 0; z<3;z++) {
            arr.add(new ArrayList<>());
        }


        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) arr.get(i).add(Integer.parseInt(st.nextToken()));
        }

        int t = 1;
        if(arr.size() > r-1 && arr.get(r-1).size() > c-1) {             // t가 0 초일 때 확인
            if(arr.get(r-1).get(c-1) == k) t = 0;
        }

        if(t != 0) {
            while(true) {
                if(t >100) {
                    t = -1;
                    break;
                }
                if(sol()) break;

                t++;
            }
        }





        br.close();
        bw.write(t + "\n");
        bw.flush();
        bw.close();

    }

    static boolean sol() {
        ArrayList<ArrayList<Integer>> tmp = new ArrayList<>();
        for(int z = 0; z<arr.size();z++) {
            tmp.add(new ArrayList<>());
        }

        int size = Integer.MIN_VALUE;

        for (int i = 0; i < arr.size(); i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < arr.get(i).size(); j++) {
                if(arr.get(i).get(j) ==0) continue;
                map.put(arr.get(i).get(j), map.getOrDefault(arr.get(i).get(j), 0) + 1);
            }


            PriorityQueue<Point> pQ = new PriorityQueue<>();
            for (Integer key : map.keySet()) {
                    pQ.add(new Point(key,map.get(key)));
            }


            while(!pQ.isEmpty()) {
                if(tmp.get(i).size() == 100) break;
                Point p = pQ.poll();
                int key = p.key;
                int value = p.value;
                tmp.get(i).add(key);
                tmp.get(i).add(value);
            }

            size = Math.max(size,tmp.get(i).size());
        }



        for(int x = 0; x < tmp.size();x++) {
            int s = tmp.get(x).size();
            if(s < size) {
                for(int y =s; y<size;y++) {
                    tmp.get(x).add(0);
                }
            }
        }

        if(isRow) {
            if(tmp.size() > r-1 && size > c-1) {
                if(tmp.get(r-1).get(c-1) == k) return true;
            }
            if(size > tmp.size()) {
                isRow = false;
                arr = change(tmp,size);
            } else
                arr = tmp;
        }
        else {
            if(tmp.size() > c-1 && size > r-1) {
                if(tmp.get(c-1).get(r-1) == k) return true;
            }
            if(size >= tmp.size()) {
                isRow = true;
                arr = change(tmp,size);
            } else{
                arr = tmp;
            }
        }






        return false;

    }

    static ArrayList<ArrayList<Integer>> change(ArrayList<ArrayList<Integer>> tmp,int size) {
        ArrayList<ArrayList<Integer>> changeArr = new ArrayList<>();

        for(int z = 0; z <size;z++) {
            changeArr.add(new ArrayList<>());
        }

        for(int i =0; i<tmp.size();i++) {
            for(int j=0;j<size;j++) {
                changeArr.get(j).add(tmp.get(i).get(j));
            }

        }

        return changeArr;
    }


}





