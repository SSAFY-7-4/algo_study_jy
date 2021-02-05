import java.util.ArrayList;
import java.util.Scanner;

public class BOJ2667 {
	public static int n;
	public static int arr[][];
	public static boolean visited[][];
	public static int count = 0;
	public static ArrayList<Integer> danji = new ArrayList<Integer>();
	public static int directX[] = {-1,1,0,0};
	public static int directY[] = {0,0,1,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr= new int[n][n];
		visited=new boolean[n][n];
		for(int i=0; i<n; i++)
		{
			String s = sc.next();
			for(int j=0; j<n; j++)
			{
				arr[i][j]= s.charAt(j)-'0';
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]==1 && !visited[i][j])
				{
					count = 0;
					visited[i][j]=true;
					dfs(i,j);
					danji.add(count);
				}
			}
		}
		danji.sort(null);
		System.out.println(danji.size());
		for (int t : danji) {
			System.out.println(t);
		}
		
	}
	public static void dfs(int raw,int col) {
		count++;
		visited[raw][col]=true;
		for(int i=0; i<4; i++) {
			int X = raw + directX[i];
			int Y = col + directY[i];
			if(X>=0 && X<n && Y>=0 && Y<n &&!visited[X][Y]&&arr[X][Y]==1)
			{
				dfs(X,Y);
			}
		}
		
	}
}
