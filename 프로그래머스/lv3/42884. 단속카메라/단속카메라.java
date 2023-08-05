import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        ArrayList<Integer> camera = new ArrayList<Integer>();
        Arrays.sort(routes,(o1,o2)->(o1[1]-o2[1]));         // 나간 시점 오름차순 정렬
        
        camera.add(routes[0][1]);                           // 제일 빠르게 나간 차량 지점 카메라 설치
        
          for(int i=1;i<routes.length;i++){
              int startPoint = routes[i][0];
              int endPoint = routes[i][1];
              if(startPoint>camera.get(camera.size()-1))
                  camera.add(endPoint);
          }
      
        answer = camera.size(); 

        return answer;
    }
}