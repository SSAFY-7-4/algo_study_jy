import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14889 {
	public static int N;
	public static int arr[][];
	public static int selected[];
	public static int result=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr= new int[N][N];
		selected= new int[N/2];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		comb(0,0);
		
		
		System.out.println(result);
	}
	private static void comb(int cnt, int start) {
		if(cnt==N/2) {
			make();
			return;
		}
		for(int i=start; i<N; i++) {
			selected[cnt] = i;
			comb(cnt+1,i+1);
		}
	}
	private static void make() {
		ArrayList<Integer> start = new ArrayList<>();
		ArrayList<Integer> link = new ArrayList<>();
		for(int i=0; i<N/2; i++) {
			start.add(selected[i]);
		}
		for(int i=0; i<N; i++) {
			if(!start.contains(i)) {
				link.add(i);
			}
		}
		int st=0,ln=0;
		for(int i=0; i<N/2; i++) {
			for(int j=i; j<N/2; j++) {
				int a = start.get(i); int b = start.get(j);
				int c = link.get(i); int d = link.get(j);
				st += arr[a][b]+arr[b][a];
				ln += arr[c][d]+arr[d][c];
			}
		}
		if(result> Math.abs(st-ln)) {
			result= Math.abs(st-ln);
		}
		
		
	}
}
