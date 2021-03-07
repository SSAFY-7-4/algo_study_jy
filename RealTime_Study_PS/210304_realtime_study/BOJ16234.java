import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234 {
	public static int N, L, R,sum;
	public static int arr[][];
	public static boolean visited[][],flag;
	public static int dx[] = { -1, 1, 0, 0 };
	public static int dy[] = { 0, 0, -1, 1 };
	public static Queue<int[]> point = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count=0;
		while (true) {
			
			visited = new boolean[N][N];
			flag=false;
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(!visited[i][j]&&check(i,j)) {
							sum=0;
							flag=true;
							dfs(i,j);
							int size = point.size(); 
							while(!point.isEmpty()) {
								int temp[] = point.poll();
								arr[temp[0]][temp[1]]= sum/size;
							}
						
						
						
						}
					}
				}
				
				if(!flag) break;
				count++;
			}
		System.out.println(count);
	}

	private static boolean check(int row, int col) {
		for(int i=0; i<4; i++) {
			int nx = row+ dx[i];
			int ny = col+ dy[i];
		
			
			if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
				int temp =Math.abs(arr[row][col]-arr[nx][ny]);
				if(temp>=L&&temp<=R) {
					return true;
				}
			}
		}
		
		return false;
	}

	private static void dfs(int row, int col) {
		sum+= arr[row][col];
		point.offer(new int[] {row,col});
		visited[row][col]=true;
		
		for(int i=0; i<4; i++) {
			int nx = row+ dx[i];
			int ny = col+ dy[i];
		
			
			if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
				int temp =Math.abs(arr[row][col]-arr[nx][ny]);
				if(temp>=L&&temp<=R) {
					dfs(nx,ny);
				}
			}
		}
	}

}
