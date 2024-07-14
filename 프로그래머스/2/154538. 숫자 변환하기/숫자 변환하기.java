import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        answer = dfs(x, y, n);
        return answer;
    }
    int dfs(int x, int y, int n){
        boolean []checkXValue = new boolean[y-x + 1];
        Queue<XValueCost> queue = new LinkedList<>();
        queue.add(new XValueCost(x, 0));
        checkXValue[0] = true;
        while(!queue.isEmpty()){
            XValueCost xValueCost = queue.poll();
            if(xValueCost.x == y){
                return xValueCost.cost;
            }
            if(xValueCost.x*2 <= y && !checkXValue[xValueCost.x*2 - x]){
                queue.add(new XValueCost(xValueCost.x*2, xValueCost.cost + 1));
                checkXValue[xValueCost.x*2 - x] = true;
            }
            if(xValueCost.x*3 <= y && !checkXValue[xValueCost.x*3 - x]){
                queue.add(new XValueCost(xValueCost.x*3, xValueCost.cost + 1));
                checkXValue[xValueCost.x*3 - x] = true;
            }
            if(xValueCost.x + n <= y && !checkXValue[xValueCost.x + n - x]){
                queue.add(new XValueCost(xValueCost.x + n, xValueCost.cost + 1));
                checkXValue[xValueCost.x + n - x] = true;
            }
        }
        return -1;
    }
    class XValueCost{
        int x;
        int cost;
        XValueCost(int x, int cost){
            this.x = x;
            this.cost = cost;
        }
    }
}