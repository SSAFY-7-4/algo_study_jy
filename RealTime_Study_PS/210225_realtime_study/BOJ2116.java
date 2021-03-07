
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2116 {
	public static int N;
	public static int dice[][];
	public static int max=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(br.readLine());
		dice= new int[N][6];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<6; j++) {
				dice[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<6; i++) {
			
			dice(0,dice[0][i],0);
		}
		System.out.println(max);
	}
	private static void dice(int cnt,int down, int sum) {
		if(cnt==N) {
			
			if(sum>max) max = sum;
			return;
		}
		int top=0,temp=0;
		if(down==dice[cnt][0]) {
			top = dice[cnt][5];
		}else if(down==dice[cnt][1]) {
			top = dice[cnt][3];
		}else if(down==dice[cnt][2]) {
			top = dice[cnt][4];
		}else if(down==dice[cnt][3]) {
			top = dice[cnt][1];
		}else if(down==dice[cnt][4]) {
			top = dice[cnt][2];
		}else if(down==dice[cnt][5]) {
			top = dice[cnt][0];
		}
		
		for(int i=1; i<=6; i++) {
			if(i!=top&&i!=down) {
				if(i>temp) temp=i;
			}
		}
	
		dice(cnt+1,top,sum+temp);
	}
}
