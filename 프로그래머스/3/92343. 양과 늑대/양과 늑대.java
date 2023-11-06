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
        
        
          if(info[idx] == 0) sheep++;
                else {
                    wolf++;
                }
        
        if(wolf >= sheep) {    
            return;
        }
        
        max = Math.max(max,sheep);
        
        if(info[idx] == 1 && gragh.get(idx) == null) {
            nodes.remove(Integer.valueOf(idx));   
            return;
        }
        
        
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
