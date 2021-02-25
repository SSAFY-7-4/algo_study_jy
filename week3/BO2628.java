import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BO2628 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer> garo = new ArrayList<>();
		ArrayList<Integer> sero = new ArrayList<>();
		garo.add(0);garo.add(R);
		sero.add(0);sero.add(C);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(dir==0) {
				sero.add(num);
			}
			else{
				garo.add(num);
			}
		}
		
		Collections.sort(garo);
		Collections.sort(sero);
		
		int maxGaro = 0;
		int maxSero = 0;
		Integer[] ga = garo.toArray(new Integer[garo.size()]);
		for(int i=1; i<ga.length;i++) {
			maxGaro = Math.max(maxGaro, ga[i]-ga[i-1]);
		}
		Integer[] se = sero.toArray(new Integer[sero.size()]);
		maxSero = se[0];
		for(int i=1; i<se.length;i++) {
			maxSero = Math.max(maxSero, se[i]-se[i-1]);
		}
		System.out.println(maxGaro*maxSero);
	}
}
