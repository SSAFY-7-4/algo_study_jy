import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15658 {
	public static int N;
	public static int num[],yeonsan[];
	public static int op[];
	public static char yeonsanja[] = {'+','-','*','/'};
	public static int max,min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		num = new int[N];
		st =new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i]= Integer.parseInt(st.nextToken());
		}
		op = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
			
		}
		max =-1000000000;
		min=1000000000;
		yeonsan(1,num[0],op[0],op[1],op[2],op[3]);
		System.out.println(max);
		System.out.println(min);
	}
	private static void yeonsan(int idx, int sum, int add, int sub, int mul, int div) {
		if(idx>=N) {
			if(min>sum) min = sum;
			if(max<sum) max = sum;
			return;
		}
		if(add>0) {yeonsan(idx+1,sum+num[idx],add-1,sub,mul,div);}
		if(sub>0) {yeonsan(idx+1,sum-num[idx],add,sub-1,mul,div);}
		if(mul>0) {yeonsan(idx+1,sum*num[idx],add,sub,mul-1,div);}
		if(div>0) {yeonsan(idx+1,sum/num[idx],add,sub,mul,div-1);}
		
	}
	
}
