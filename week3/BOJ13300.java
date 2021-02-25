import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[][] = new int[7][2];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			arr[grade][gender]+=1;
		}
		int result = 0;
		for(int i=1; i<=6; i++) {
			if(arr[i][0]%K==0) {result+= arr[i][0]/K;}
			else {
				result+=arr[i][0]/K+1;
			}
			if(arr[i][1]%K==0) {result+= arr[i][1]/K;}
			else {
				result+=arr[i][1]/K+1;
			}
		}
		System.out.println(result);
	}
}
