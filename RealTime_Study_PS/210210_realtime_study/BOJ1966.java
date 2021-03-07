import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966 { // 프린터큐
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int arr[] = new int[N]; // 중요도 배열
			Queue<int[]> queue = new LinkedList<>(); // 큐에 인덱스와 중요도를 배열형태로 넣어줌.
			boolean popcheck[] = new boolean[N]; // 해당 인덱스가 pop이 되었는지 체크하는 배열 
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				int temp[] = { j, arr[j] }; 
				queue.offer(temp);
			}
			int count = 1;
			while (!queue.isEmpty()) {
				int temp[];
				temp = queue.poll();
				boolean checkJ = false;
				for (int j = 0; j < N; j++) {
					if (!popcheck[j] && temp[1] < arr[j]) {// temp 의 중요도가 pop 되지 않은 녀석들 중 제일 높은지.
						checkJ = true; // true = 이번에 나갈차례가 아니다.
					}
				}
				if (!checkJ) { // temp는 이번에 나갈 차례. 
					if (temp[0] == M) { // temp의 인덱스가 M인지 체크. 
						break; // 맞으면 바로 빠져 나옴. 
					} else { // temp 인덱스가 M이 아니다. 중요도는 가장 높기 때문에 pop , 그리고 count ++로 pop된 갯수 체크. 
						popcheck[temp[0]]=true;
						count++;
					}
				} else { // 다시 큐에 넣어라. 
					queue.offer(temp);
				}
			}
			System.out.println(count); 
		}

	}
}
