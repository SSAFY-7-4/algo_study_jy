import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16948 {
	public static int N, r1, c1, r2, c2;
	public static int result;
	public static int dx[] = { -2, -2, 0, 0, 2, 2 };
	public static int dy[] = { -1, 1, -2, 2, -1, +1 };
	public static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		visited = new boolean[N][N];
		st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		result = -1;
		bfs();
		System.out.println(result);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		int start[] = { r1, c1, 0 };
		visited[r1][c1] = true;
		queue.offer(start);
		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			if(temp[0]==r2&&temp[1]==c2)
			{
				result = temp[2];
				return;
			}
			for(int i=0; i<6;i++) {
				int nx = temp[0]+dx[i];
				int ny = temp[1]+dy[i];
				
				if(nx>=0 && nx<N&& ny>=0 && ny<N&& !visited[nx][ny]) {
					visited[nx][ny]=true;
					int tempQ[] = {nx,ny,temp[2]+1};
					queue.offer(tempQ);
				}
			}
		}
	}

}
