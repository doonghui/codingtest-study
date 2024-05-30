import java.util.*;
import java.io.*;

public class Main {

    static int[] heights;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();

        heights = new int[w];
        for(int i = 0; i < w; i++) {
            heights[i] = sc.nextInt();
        }

        int sum = 0;
        for(int i = 1; i < w - 1; i++) {

            int currentHeight = heights[i];

            int LM = 0;
            for(int j = 0; j <= i; j++) { 
                LM = Math.max(LM, heights[j]);
            }

            int RM = 0;
            for(int j = i; j < w  ; j++) {
                RM = Math.max(RM, heights[j]);
            }

            sum += Math.min(LM, RM) - currentHeight;
        }
        if(sum < 0) sum = 0;
        System.out.println(sum);

    }
}