import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1992 {
	public static int N;
	public static int arr[][];
	public static int directX[] = { 0, 0, 1, 1 };
	public static int directY[] = { 0, 1, 0, 1 };
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}

		}
		QuadTree(0, 0, N);
		System.out.println(sb);
	}

	public static void QuadTree(int raw, int col, int size) {
		boolean flagZero = false;
		boolean flagOne = false;

		for (int i = raw; i < (raw + size); i++) {
			for (int j = col; j < (col + size); j++) {
				if (arr[i][j] == 0) {
					flagZero = true;
				} else if (arr[i][j] == 1) {
					flagOne = true;
				}

			}
		}

		if (flagZero && flagOne) {

			sb.append('(');
			for (int i = 0; i < 4; i++) {
				int x = raw + (size / 2) * directX[i];
				int y = col + (size / 2) * directY[i];

				QuadTree(x, y, size / 2);
			}
			sb.append(')');
		} else if (flagZero) {

			sb.append('0');
		} else if (flagOne) {

			sb.append('1');
		}
	}
}
