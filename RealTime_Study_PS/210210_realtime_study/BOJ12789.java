import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ12789 {
	public static int N;
	public static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean check = possible();
		if (check) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
	}

	public static boolean possible() {
		Stack<Integer> stack = new Stack<>();
		int count = 1, index = 0;
		while (index < N) {// 인덱스가 N 이하일 경우 반복 진행. index==N break. 
			if (arr[index] == count) { // arr[index]와 count가 같으면 
				count++;
				index++;
			} else { 
				if (!stack.isEmpty()) { // arr[index]와 count가 다르기 떄문에 스택을 체크 
					while (!stack.isEmpty()) { 
						if (stack.peek() == count) { //stack peek이 count면 
							stack.pop(); // pop과 count ++ 
							count++;
						} else {
							break; // 스택이 peek이 count와 다르면 while문 빠져 나옴. 
						}
					}
					if (!stack.isEmpty()&& stack.peek() <= arr[index]) {
						return false;  // 
					} else {
						stack.push(arr[index]);
						index++;
					}
				} else {
					stack.push(arr[index]);
					index++;
				}
			}
		}
		if (!stack.isEmpty()) {
			while (!stack.isEmpty()) {
				if (stack.peek() == count) {
					stack.pop();
					count++;
				}
				else {
					return false;
				}
			}
		}

		return true;
	}
}
