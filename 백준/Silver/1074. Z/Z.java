import java.util.*;


public class Main {

	static int N,r,c,cnt=0;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		find(r,c,(int)Math.pow(2, N));
		System.out.println(cnt);
		
	
	}// main()
	
	static void find(int x,int y, int size) {
		if(size==1)
			return;
		
		if(x<size/2&&y<size/2) {	
			find(x,y,size/2);
		}else if(x<size/2&&size/2<=y) {	
			cnt+=(size*size/4);
			find(x,y-size/2,size/2);
		}else if(x>=size/2&&size/2>y) { 
			cnt+=(size*size/4)*2;
			find(x-size/2,y,size/2);
		}else {
			cnt+=(size*size/4)*3;
			find(x-size/2,y-size/2,size/2);
			
		}
			
	}
	
}
