import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2304 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int arr[] = new int[1002];
		int lmax[] = new int[1002];
		int rmax[] = new int[1002];
		int min=1000,max=0; // 창고 다각형 시작점 끝점
		int result = 0;
		if(N==1) {
			st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			System.out.println(k);
			return;
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			if(j<min) {
				min=j;
			}
			if(j>max) {
				max=j;
			}
			arr[j] = k;
		}
		
		result +=arr[min];
		result +=arr[max];
		lmax[min]=arr[min];
		for(int i=min+1; i<max; i++) {
			lmax[i]= Math.max(lmax[i-1], arr[i]);
		}
		for(int i=max; i>min; i--) {
			rmax[i]= Math.max(rmax[i+1], arr[i]);
		}
		for(int i=min; i<max; i++) {
			result+= Math.max(0, Math.min(rmax[i],lmax[i]));
		}
		System.out.println(result);
	}
}
