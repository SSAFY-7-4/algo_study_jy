import java.util.Scanner;

public class BOJ1107 {
	public static boolean brokenNum[] = new boolean[10];; 
	public static int count =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 찾고자 하는 번호 먼저 입력 
		int M = sc.nextInt(); // 고장난 버튼 갯수
		for(int i=0; i<M; i++) {
			int num = sc.nextInt();
			brokenNum[num] = true; // 고장난 버튼 배열에 삽입
		}
		if(N==100) {System.out.println(0); // 현재 100번 시청중으로 100으로 가기위해서는 버튼을 누를 필요가없다.
		return;
		}
		
		int min = Math.abs(100-N); // 초기값으로 우선 + 나 - 만을 눌러서 이동한다 했을때 횟수로 설정
		for(int i=0; i<1000000; i++) {// 최대 500000의 N 입력이 가능하므로 0부터 50만까지 / 100만부터 50만까지 -> 범위는 100만
			int len = possible(i); //i에 대해 리모컨 이동 여부 판단 가능시 0보다 큰 숫자를 가질것. 
			if(len>0) { // 0 이면 리모컨 번호 입력 불가 무시.
				int temp = Math.abs(i-N); //리모컨으로 최대한 가까운수를 찾아서 타겟 번호까지의 + 나 - 입력 횟수를 계산 
				if(min> len+temp) { // len(리모컨 설정으로 찾음) + temp < min  ---> 새로운 최솟값 탄생.
					min = len+temp;
				}
			}
			
		}
		System.out.println(min);
	}
	private static int possible(int n) {
		if(n ==0) {//0일떄는 %연산이 불가하기떄문에 예외처리
			if(brokenNum[0]==true) { //0 고장시 불가 return;
				return 0;
			}
			else { // 0 가능  결과 = 1
				return 1;
			}
		}
		//0이아닌 숫자를 입력받았을때
		int len=0; // 리모컨 입력 횟수 (길이)
		while(n>0) { 
			if(brokenNum[n%10]) {//리모컨 입력으로는 불가 %10을 한이유 == 끝에서부터 한자리씩 처리하기 위해. ex) 315 나 513이나 상관없다!
				return 0; // 고장난 버튼으로 인해 0으로 return;
			}
			len+=1; // 리모컨 가능으로 len ++ 
			n/=10; // 리모컨 가능으로 n/10 에 대한 다음 루틴 진행 (자릿수) 
		}
		
		return len; //여기까지 왔다는 것은 len이 0보다는 크다는 뜻. 
	}
	
}
