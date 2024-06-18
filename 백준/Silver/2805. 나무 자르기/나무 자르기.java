import java.util.*;

public class Main {
	
	static int[] trees;
	static int M;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	
		M = sc.nextInt();	
		
		trees = new int[N];
		int max=0; 	
		
		for(int i=0;i<N;i++) {
			trees[i]=sc.nextInt();
			if(max<trees[i])
				max= trees[i];	
		}

		int start =0;
		int end = max;
		
		while(start+1<end) {
			int mid = (start+end)/2;
			if(check(mid)) {
				start=mid;
			}else {
				end = mid;
			}
		}
		
		
		System.out.println(start);
		
	}// main() 
	
	 static boolean check(int cut) {

	        long sum = 0;
	        long result;
	        long tree;

	        for (int i = 0; i < trees.length; i++) {
	            tree = trees[i];
	            if (tree >= cut) {
	                result = tree - cut;
	                sum += result;
	            }
	        }
	        if (sum >= M) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	
	
}
