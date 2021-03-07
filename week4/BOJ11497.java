import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11497 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int result[] = new int[N];int lidx=0,ridx=N-1; 
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					result[lidx++] = arr[i];
				}
				else {
					result[ridx--] = arr[i];
				}
			}
			int answer = Math.abs(result[0]-result[N-1]);
			for(int i=0; i<N-1; i++) {
				int temp = Math.abs(result[i]-result[i+1]);
				if(answer<=temp) answer = temp;
			}
			System.out.println(answer);
		}
	}
}
