import java.util.Scanner;

public class BOJ1074 {
	public static int N, r, c;
	public static int[][] arr;
	public static int directX[] = { 0, 0, 1, 1 };
	public static int directY[] = { 0, 1, 0, 1 };
	public static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// input N ,r , c 
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		searchZ(0, 0, (int) Math.pow(2, N));
		System.out.println(result);
	}

	public static void searchZ(int raw, int col, int size) {
		int n;
		n = size / 2;
		if (n == 1) {
			for (int i = 0; i < 4; i++) {
				int x = raw + directX[i];
				int y = col + directY[i];
				if (r == x && c == y) {
					result += i;
				}
			}
		} else if (r < (raw + n) && c < (col + n)) {
			searchZ(raw, col, n);
		} else if (r < (raw + n) && c >= (col + n)) {
			result += (n * n);
			searchZ(raw, col + n, n);
		} else if (r >= (raw + n) && c < (col + n)) {
			result += (2 * n * n);
			searchZ(raw + n, col, n);
		} else if (r >= (raw + n) && c >= (col + n)) {
			result += (3 * n * n);
			searchZ(raw + n, col + n, n);
		}

	}
}
