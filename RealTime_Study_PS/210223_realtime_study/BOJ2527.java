
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2527 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int x1,y1,p1,q1,x2,y2,p2,q2; // 첫번쨰 사각형 두번째 사각형 받아오기. 
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			p1 = Integer.parseInt(st.nextToken());
			q1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			p2 = Integer.parseInt(st.nextToken());
			q2 = Integer.parseInt(st.nextToken());
		
			if(x2>p1||p2<x1||y2>q1||q2<y1) {
				System.out.println("d");
			}
			else if((x2==p1&&y2==q1)||(p2==x1&&y2==q1)||(x2==p1&&q2==y1)||(p2==x1&&q2==y1)) {
				System.out.println("c");
			}
			else if(p2 == x1 || y2==q1 || x2 == p1 || q2 == y1 ) {
				System.out.println("b");
			}else {
				System.out.println("a");
			}
		
		
		
		
		}
		
	}
}
