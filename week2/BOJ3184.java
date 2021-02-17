import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3184 {
	public static int R,C;
	public static char madang[][];
	public static boolean visited[][];
	public static int sheep,wolf;
	public static int totalSheep,totalWolf;
	public static int dx[] = {1,-1,0,0};
	public static int dy[] = {0,0,1,-1};	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		madang = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				madang[i][j] = s.charAt(j);
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if((madang[i][j]=='o'||madang[i][j]=='v'||madang[i][j]=='.')&&!visited[i][j]) {
					sheep=0;
					wolf=0;
					dfs(i,j);
					if(sheep<=wolf) {
						totalWolf+=wolf;
					}
					else {
						totalSheep +=sheep;
					}
				}
			}
		}
		System.out.println(totalSheep+" "+totalWolf);
		
	}
	private static void dfs(int raw,int col) {
		visited[raw][col]=true;
		if(madang[raw][col]=='o') {
			sheep++;
		}
		else if(madang[raw][col]=='v'){
			wolf++;
		}
		for(int i=0; i<4; i++) {
			int nx = raw + dx[i];
			int ny = col + dy[i];
			if(nx>=0 && nx<R && ny>=0&&ny<C&&
					(madang[nx][ny]=='o'||madang[nx][ny]=='v'||madang[nx][ny]=='.')&&!visited[nx][ny]) {
				dfs(nx,ny);
			}
		}
	}
}
