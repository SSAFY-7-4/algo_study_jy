import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14696 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		for(int i=0; i<N ; i++) {
			int A[] = new int[5];
			int B[] = new int[5];
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for(int j=0; j<a; j++) {
				A[Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			for(int j=0; j<b; j++) {
				B[Integer.parseInt(st.nextToken())]++;
			}
			boolean notDraw = false;
			for(int j=4; j>=1; j--) {
				if(A[j]>B[j]) {
					System.out.println("A");
					notDraw = true;
					break;
				}
				else if(A[j]<B[j]) {
					System.out.println("B");
					notDraw = true;
					break;
				}
			}
			if(!notDraw) System.out.println("D");
		}
	}
}
