import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1068 {
	public static ArrayList<ArrayList<Integer>> tree;
	public static int N, leef = 0,del,root;
	public static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		tree = new ArrayList<>();
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			tree.add(new ArrayList<>());
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp == -1) {
				root = i;
			} else {
				tree.get(i).add(temp); // 부모노드 추가
				tree.get(temp).add(i); // 자식 노드 추가
			}
		}
		del = Integer.parseInt(br.readLine());
		deleteTree(del); // del 노드 clear .
		dfs(root);

		System.out.println(leef);
	}

	private static void dfs(int node) {
		visited[node] = true; // 방문 처리.
		
		if (tree.get(node).size() == 0) { // clear 된 노드면 return;
			return;
		}
		else if (tree.get(node).size() == 1) { // 부모노드 만 적혀있으면 leef 임으로 +1
			leef++;
			return;
		}
		else if(node!=root&&tree.get(node).contains(del)&&tree.get(node).size()==2) {
			leef++;
			return;
		}
		for (int i = 0; i < tree.get(node).size(); i++) { // node 탐색.
			if (!visited[tree.get(node).get(i)]) { // node의 i번쨰가
				dfs(tree.get(node).get(i)); // dfs 실시
			}
		}
	}

	private static void deleteTree(int node) {
		visited[node] = true;
		tree.get(node).clear();
	}
}
