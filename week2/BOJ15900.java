import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15900 {
	public static ArrayList<ArrayList<Integer>> tree;
	public static boolean visited[];
	public static int totalDepth=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		tree = new ArrayList<>();
		visited = new boolean[N+1];
		for(int i=0; i<=N; i++) {
			tree.add(new ArrayList<>());
		}
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		dfs(1,0);
		if(totalDepth%2==0) {
			System.out.println("No");
		}
		else {
			System.out.println("Yes");
		}
	}
	private static void dfs(int i,int depth) {
		visited[i]=true;
		for (int next : tree.get(i)) {
			if(!visited[next]) {
				dfs(next,depth+1);
			}
		}
		if(i!=1 && tree.get(i).size()==1) {
			totalDepth+=depth;
		}
	}
}
