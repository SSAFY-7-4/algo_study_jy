import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ16206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> rollcake = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int diff = o1.compareTo(o2);
				if(o1%10==0 && o2%10==0) {
					return diff;
				}
				else if(o1%10==0) {
					return -1;
				}
				else if(o2%10==0) {
					return 1;
				}
				else {
					return diff;
				}
				
			}
			
		});
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp == 10) {
				sum++;
			}
			else if(temp>10) {
			rollcake.add(temp);
			}
		}
		
		while (!rollcake.isEmpty()) {
			int temp = rollcake.poll();
			temp-=10;
			sum++;
			M--;
			if(temp==10) sum++;
			else if(temp>10) {rollcake.add(temp);}
			
			
			if(M==0) break;
			
		}
		
		System.out.println(sum);

	}
}
