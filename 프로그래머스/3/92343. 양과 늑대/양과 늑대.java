import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> gragh;
    static int max = Integer.MIN_VALUE;

    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        gragh = new ArrayList<>();
        
        for(int i=0;i<info.length;i++) gragh.add(new ArrayList<>());
        
        for(int j =0;j<edges.length;j++) {
            int a = edges[j][0];
            int b = edges[j][1];
            gragh.get(a).add(b);            

        }
        ArrayList<Integer> nodes = new ArrayList<>();
        
        nodes.add(0);
        dfs(info,0,0,0,nodes);
        
        
        return max;
    }
    
    
    static void dfs(int[] info,int idx,int sheep,int wolf,ArrayList<Integer> nodes) {
        
            
        if(info[idx] == 1 && gragh.get(idx) == null) {          // 울프인데 자손없으면 더 확인하고 밑에 코드까지 갈 필요없으니깐 return;
            nodes.remove(Integer.valueOf(idx));   
            return;
        }
        
          if(info[idx] == 0) sheep++;
                else {
                    wolf++;
                }
        
        if(wolf >= sheep) {    
            return;
        }
        
        max = Math.max(max,sheep);
    
        
        // 이미 방문한 위치를 또 방문하기 위해서 idx 저장
        ArrayList<Integer> nextNodes = new ArrayList<>();
        nextNodes.addAll(nodes);

        nextNodes.remove(Integer.valueOf(idx));

        
            for(Integer i : gragh.get(idx)){
                nextNodes.add(i);
            }
        
            for(Integer j : nextNodes) {
                dfs(info,j,sheep,wolf,nextNodes);
                
            }
            
            
        }
        
        
    }