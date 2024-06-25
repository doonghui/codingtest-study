import java.util.*;
import java.io.*;

public class Main {
    static int[][] point = new int[3][2];	
    static public void  main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine()," ");
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }
        int result = cal();		
        bw.write(result + "\n");
        bw.flush();		
        bw.close();
        br.close();
    }
    static int cal(){
        int sumA = point[0][0]*point[1][1] + point[1][0]*point[2][1] + point[2][0]*point[0][1];
        int sumB = point[1][0]*point[0][1] + point[2][0]*point[1][1] + point[0][0]*point[2][1];
        int temp = sumA - sumB;
        if(temp>0)	
            return 1;
        else if(temp<0)
            return -1;
        else		
            return 0;
    }
}