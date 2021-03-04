import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2564 {
	public static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int dir[] = new int[N]; // 상점 갯수 만큼의 동서남북
		int distance[] = new int[N]; // 상점 갯수만큼의 거리
		int result = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dir[i] = Integer.parseInt(st.nextToken());
			distance[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int dx = Integer.parseInt(st.nextToken()); // 동근이 동서남북.
		int dirX = Integer.parseInt(st.nextToken()); // 동근이 거리
		for (int i = 0; i < N; i++) {
			if (dx == dir[i]) {
				int a = Math.abs(dirX - distance[i]);
				int b = 2 * R + 2 * C - a;
				result += Math.min(a, b);
			} else if ((dir[i] + dx) == 7 || (dir[i]+dx==3)) {
				if (dx == 1 || dx == 2) {
					int a = Math.abs(R + dirX + distance[i]);
					int b = 2 * R + 2 * C - a;
					result += Math.min(a, b);

				} else {
					int a = Math.abs(C + dirX + distance[i]);
					int b = 2 * R + 2 * C - a;
					result += Math.min(a, b);

				}
			} else {
				if (dx == 1) {
					if (dir[i] == 3) {
						int a = Math.abs(dirX + distance[i]);
						int b = 2 * R + 2 * C - a;
						result += Math.min(a, b);
					} else {
						int a = Math.abs(C - dirX + distance[i]);
						int b = 2 * R + 2 * C - a;
						result += Math.min(a, b);
					}
				} else if (dx == 3) {
					if (dir[i] == 1) {
						int a = Math.abs(dirX + distance[i]);
						int b = 2 * R + 2 * C - a;
						result += Math.min(a, b);

					} else {
						int a = Math.abs(R - dirX + distance[i]);
						int b = 2 * R + 2 * C - a;
						result += Math.min(a, b);
					}
				} else if (dx == 2) {
					if (dir[i] == 3) {
						int a = Math.abs(R + dirX - distance[i]);
						int b = 2 * R + 2 * C - a;
						result += Math.min(a, b);
						
					} else {
						int a = Math.abs(R - dirX + C - distance[i]);
						int b = 2 * R + 2 * C - a;
						result += Math.min(a, b);
					}
				} else {
					if (dir[i] == 1) {
						int a = Math.abs(C + dirX - distance[i]);
						int b = 2 * R + 2 * C - a;
						result += Math.min(a, b);
					} else {
						int a = Math.abs(R - dirX + C - distance[i]);
						int b = 2 * R + 2 * C - a;
						result += Math.min(a, b);
					}
				}

			}
		}
		System.out.println(result);
	}
}
