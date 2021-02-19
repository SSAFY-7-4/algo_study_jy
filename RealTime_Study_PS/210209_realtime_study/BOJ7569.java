import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
	public static int dx[] = { 0, 0, 0, 0, -1, 1 }; // 상하 좌우 앞뒤
	public static int dy[] = { 0, 0, -1, 1, 0, 0 };
	public static int dz[] = { 1, -1, 0, 0, 0, 0 };
	public static Queue<int[]> queue = new LinkedList<>();
	public static int M, N, H, result=0, tomato[][][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomato = new int[N][M][H];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine()," ");

				for (int k = 0; k < M; k++) {
					tomato[j][k][i] = Integer.parseInt(st.nextToken());
					if (tomato[j][k][i] == 1) {
						int temp[] = { j, k, i };
						queue.offer(temp);
					}
				}
			}
		}
		bfs();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (tomato[j][k][i] == 0) {
						System.out.println("-1");
						return;
					}
					if(result<tomato[j][k][i]) result = tomato[j][k][i];
				}

			}

		}System.out.println(result-1); return;
	}

	private static void bfs() {
		while(!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.peek()[1];
			int z = queue.peek()[2];
			queue.poll();
			for(int i=0; i<6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				if(nx>=0 &&nx<N&& ny>=0 && ny<M && nz >=0 && nz<H&&tomato[nx][ny][nz]==0) {
					tomato[nx][ny][nz]=tomato[x][y][z]+1;
					int temp[]= {nx,ny,nz};
					queue.offer(temp);
				}
			}
		}
	}
}
