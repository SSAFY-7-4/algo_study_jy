import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2217 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int result=0;
		for(int i=0; i<N; i++) {
			int max = arr[i]*(N-i);
			if(result<max) result = max;
		}
		
		System.out.println(result);
	}
}
