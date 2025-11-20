import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;


        int t = Integer.parseInt(br.readLine());

        int count  = 1;

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};

            double[] scores = new double[n];
            double ts = 0;


            // 한명씩 총점 계산해서 배열에 넣기
            // 계산된 점수들을 정렬해서 앞에부터 순서대로 끊어서 주어진 n / 10 해서 그 순서대로 평점 부여
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                double number = (a * 0.35 + b * 0.45 + c * 0.2);

                scores[j] = number;

                if(j == k-1) ts = number;

            }

            int rank = 0;
            for(double score : scores) {
                if(score > ts) rank++;
            }



            int perGrade = n/10;

            int gidx = rank / perGrade;

            bw.write("#"+tc+" "+grade[gidx]+"\n");
            bw.flush();

        }





    }



}
