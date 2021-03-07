
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2635 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N= Integer.parseInt(st.nextToken());
		int maxCount=0; int max=0;
		for(int i=1; i<=N; i++) {
			int count =0; int t = N; int p=i;
			while(t>=0) {
				int temp = t-p;
				t=p;
				p= temp;
				count++;
			}
			if(maxCount<count) {
				maxCount = count;	
				max = i;
			}
		}
		ArrayList<Integer> maxNum = new ArrayList<>();
		while(N>=0) {
			maxNum.add(N);
			int temp = N-max;
			N = max;
			max = temp;
		}
		System.out.println(maxCount);
		for (Integer integer : maxNum) {
			System.out.print(integer+" ");
		}
		
	}
}
