import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, W, L; //트럭 수, 다리길이, 최대하중
	static Queue<Integer> bridge = new ArrayDeque<Integer>();
	static int sum; //다리 위에 있는 트럭 무게 합
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < W; i++) { //다리길이만큼 큐에 0 넣어줌 
			bridge.add(0);
		}
		
		//초기화
		sum = 0;
		int time = 0;
		
		st = new StringTokenizer(br.readLine());
		int truck = Integer.parseInt(st.nextToken());
		
		while(true) { //더이상 넣을 트럭이 없을때까지 반복 (반복 1번에 시간+1)
			time++; 
			
			sum-=bridge.poll();
			if(sum+truck <= L) { //새로운 트럭이 다리를 건널 수 있을 때
				bridge.add(truck);
				sum+=truck;
				if(--N == 0) break; //더이상 새로운 트럭이 없으면 중단
				
				truck = Integer.parseInt(st.nextToken());
				
			}else { 
				bridge.add(0);
			}
			
		}
		
		time += bridge.size(); 
		System.out.println(time);
	}
}