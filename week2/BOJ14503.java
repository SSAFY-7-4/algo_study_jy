import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
	public static int arr[][];
	public static boolean Cfield[][];
	public static int N, M, r, c, direct;
	public static int clear;
	public static int dx[] = { -1, 0, 1, 0 };
	public static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		Cfield = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		direct = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clear = 0;
		robot(r, c, direct, 0); // raw , col , 방향 , 4방향 체크여부 
		System.out.println(clear);
	}

	private static void robot(int raw, int col, int direction, int check) {
		if (Cfield[raw][col] == false) { // 청소 하지 않은 상태면 청소 
			clear++;
			Cfield[raw][col] = true;
		}
		if(check==4) { // 4방향 체크 완료 됬다 
			int x = raw + dx[(direction+2)%4]; // 후진하기 위한 x 
			int y = col + dy[(direction+2)%4]; // 후진하기 위한 y
			if (x >= 0 && x < N && y >= 0 && y < M) {
				if(arr[x][y]==0) {
					robot(x,y,direction,0);
				}
				else {
					return;
				}
			}
			return;
		}
		direction = (direction - 1 + 4) % 4; // 좌로 돌아가는 코드  시작이 북 동 남 서 
		int x = raw + dx[direction];
		int y = col + dy[direction];
		if (x >= 0 && x < N && y >= 0 && y < M) {
			if (arr[x][y] == 0 && !Cfield[x][y]) {
				//System.out.println(x+" "+y+" "+check);
				robot(x, y, direction, 0);
		
			}
			else{
				//System.out.println(raw+" "+col+" "+check);
				robot(raw,col,direction,check+1);
			}
		}
		else{
			//System.out.println(raw+" "+col+" "+check);
			robot(raw,col,direction,check+1);
		}
		
	}
}
