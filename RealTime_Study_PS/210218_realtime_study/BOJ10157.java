import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10157 {
	public static int C,R;
	public static boolean visited[][];
	public static int dx[] = {0,1,0,-1};
	public static int dy[] = {1,0,-1,0};
	public static int raw,col;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		if (K > C * R) {
			System.out.println(0);
			return;
		}
		
		seat(K);
		System.out.println(raw+" "+col);
	}
	private static void seat(int k) {
		visited = new boolean[C][R];
		int cnt =1;
		int x=0,y=0;
		int direction=0;
		while(cnt !=k) {
			visited[x][y]=true;
			int nx= x+dx[direction];
			int ny= y+dy[direction];
			
			if(nx>=0&&nx<C&&ny>=0&&ny<R&&!visited[nx][ny]) {
				;
			}
			else {
				direction= (direction+1)%4;
				nx= x+dx[direction];
				ny= y+dy[direction];
			}
			
			x = nx;
			y = ny;
			cnt++;	
		}
		raw = x+1; col = y+1;
		
	}
	
}
