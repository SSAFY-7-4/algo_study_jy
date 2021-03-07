import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ12101 {
	public static ArrayList<String> arr= new ArrayList<>();
	public static ArrayList<Integer> arrI = new ArrayList<>();
	public static int n,k;
	public static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		dfs(0,0);
		
		Collections.sort(arr);
		if(k>arr.size()) {
			System.out.println(-1);
			return;
		}
		System.out.println(arr.get(k-1));
	}
	private static void dfs(int cnt, int j) {
		if(j>n) return;
		if(j==n) {
			sb = new StringBuilder();
			for(int i=0; i<arrI.size(); i++) {
				sb.append(arrI.get(i)).append('+');
			}
			arr.add(sb.substring(0,sb.length()-1).toString());
		}
		for(int i=1; i<=3; i++) {
			arrI.add(i);
			dfs(cnt+1,j+i); arrI.remove(arrI.size()-1); 
		}
	}
}
