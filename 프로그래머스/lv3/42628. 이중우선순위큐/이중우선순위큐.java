import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    static ArrayList<Integer> tmp;
     static int[] solution(String[] operations) {
            int[] answer = {};
            answer = new int[2];

            PriorityQueue<Integer> pQ = new PriorityQueue<>();

            for(String s : operations) {
                if(s.equals("D -1")) {
                    if(!pQ.isEmpty())
                        pQ.poll();



                } else if(s.equals("D 1")) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    while(!pQ.isEmpty()) {
                        arr.add(pQ.poll());
                    }
                    if(arr.size() != 0){
                        for(int i=0; i<arr.size()-1;i++) pQ.add(arr.get(i));
                    }



                } else {
                    int num;
                    if(s.charAt(1) == '-') {
                        num = Integer.parseInt(s.substring(1));
                    } else{
                        num = Integer.parseInt(s.substring(2));
                    }
                    pQ.add(num);
                }
            }
            tmp = new ArrayList<>();
            ArrayList<Integer> arr2 = new ArrayList<>();
            if(!pQ.isEmpty()){
                while(!pQ.isEmpty()){
                    int l = pQ.poll();
                    arr2.add(l);
                    tmp.add(l);
                }
                answer[0] = arr2.get(arr2.size()-1);
                answer[1] = arr2.get(0);
            }

            return answer;
        }
}