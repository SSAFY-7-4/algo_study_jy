import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2477 {
	public static int dx[] = {0,0,0,1,-1};
	public static int dy[] = {0,1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int x[] = new int[7];
		int y[] = new int[7];
		int temp[] = new int[7];
		int dir;
		x[0]=0; y[0]=0;
		for(int i=1; i<=6; i++) {
			st = new StringTokenizer(br.readLine());
			dir= Integer.parseInt(st.nextToken());
			temp[i] = Integer.parseInt(st.nextToken());
			x[i] +=x[i-1]+temp[i]*dx[dir];
			y[i] +=y[i-1]+temp[i]*dy[dir];
		}
		int maxX=0,minX=1000,minY = 1000,maxY=0;
		for(int i=1; i<=6; i++) {
			if(x[i]>=maxX) maxX = x[i];
			if(x[i]<=minX) minX = x[i];
			if(y[i]>=maxY) maxY = y[i];
			if(y[i]<=minY) minY = y[i];
		}
		dir=0;
		for(int i=1; i<=6; i++) {
			if(x[i]!=maxX&&x[i]!=minX&&y[i]!=minY&&y[i]!=maxY) {
				dir=i;
			}
		}
		int result = (maxX-minX)*(maxY-minY);
		
		if(dir ==6) {
			result -= temp[dir]*temp[1];
		}
		else {
			result -= temp[dir]*temp[dir+1];
		}
		result*=K;
		
		System.out.println(result);
	}
}
