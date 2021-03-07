import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026 {
	public static int N;
	public static char map[][];
	public static boolean visited[][];
	public static int dx[]= {-1,1,0,0};
	public static int dy[]= {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map= new char[N][N];
		
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j]=s.charAt(j);
				
			}
		}
		visited = new boolean[N][N];
		int result = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					result+=1;
					dfs(i,j,map[i][j]);
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]=='R') {map[i][j]='G';
				}
			}
		}
		
		int nokresult = 0;
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
				
					nokresult+=1;
					dfs(i,j,map[i][j]);
				}
			}
		}
		
		System.out.println(result+" "+ nokresult);
	}
	private static void dfs(int row, int col, char color) {
		visited[row][col]=true;
		for(int i=0; i<4; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];
			
			
			if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]&&map[nx][ny]==color) {
				
				dfs(nx,ny,color);
			}
		}
	}
	
}
