import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1967 {
	public static int result = 0;
	public static int N;
	public static int max_point;
	public static boolean visited[];
	public static int Distance,sum;
	public static ArrayList<int[]>[] tree; // [int] [int[]] 형의 ArrayList 응용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		tree = new ArrayList[N+1];  // new로 ArrayList배열 선언
		for(int i=0; i<=N; i++) {
			tree[i] = new ArrayList<>(); // 각 배열 별 ArrayList 할당
		}
		visited = new boolean[N+1]; // 1~N 노드 방문 여부 체크를 위한 배열 
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());    
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			tree[parent].add(new int[] {child,length});  // 부모에 자식, length를 추가
			tree[child].add(new int[] {parent,length}); // 자식에 부모, length를 추가
			
		}
		// 두번의 DFS로 자식 노드 사이에서 제일 먼 거리를 구함
		Distance=0; // Distance = 0 -> 최초에는 루트에서 제일 먼 노드까지 거리가 나올 것.
		dfs(1,0);
		visited = new boolean[N+1];
		Distance = 0;   // Distance 값을 초기화 시킴
		dfs(max_point,0);  // max_point = 루트에서 제일 먼 노드 , 그리고 해당 노드에서 제일 긴 거리를 구할 것.
		
		System.out.println(Distance);
	}
	private static void dfs(int idx,int sum) {
		if(visited[idx]) { // 이미 방문했을 시 return ; 
			return;
		}
		visited[idx]=true;
		
		if(sum>Distance) { //  시작점에서 제일 멀다 ? -> maxpoint 값으로 기록 
			Distance = sum;
			max_point = idx;
		}
		for (int[] temp : tree[idx]) { // tree[idx] arrayList를 순회하면서 담긴 배열의 0번째 인덱스를 방문 . 
			if(!visited[temp[0]]) {
				dfs(temp[0],sum+temp[1]);
			}
		}
	}
}
