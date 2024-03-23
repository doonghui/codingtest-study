class Solution {
    
    static boolean[] check;
    static int ans;
    
public  int solution(int[] numbers, int target) {
        int answer = 0;

        check = new boolean[numbers.length];
        ans = 0;

        dfs(numbers,target,0);

        return ans;
    }

    static void dfs(int[] numbers,int target,int idx) {
        int num = 0;

        for(int j =0;j<numbers.length;j++) {
            if(check[j]) num += numbers[j];
            else
                num -= numbers[j];
        }

        if(num == target) {
            ans +=1;
        }



        for(int i =idx;i<numbers.length;i++) {
            if(check[i]) return;
            check[i] = true;
            dfs(numbers,target,idx+1);
            check[i] = false;

        }

    }
}