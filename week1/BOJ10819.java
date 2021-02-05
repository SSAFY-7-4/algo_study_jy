import java.util.Arrays;
import java.util.Scanner;

public class BOJ10819 {
	public static int arr[];
	public static boolean visited[];
	public static int selected[];
	public static int result;
	public static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n];
		visited = new boolean[n];
		selected = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		dfs(0);
		System.out.println(result);
	}
	public static void dfs(int cnt) {
		if(cnt==n)
		{
			int sum=0;
			for (int i=0; i<n-1; i++)  {
				 sum+=Math.abs((selected[i]-selected[i+1]));
			}
			if (result<sum) {
				result=sum;
			}
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				selected[cnt]= arr[i];
				visited[i]=true;
				dfs(cnt+1);
				visited[i]=false;
			}
		}
	}
}
