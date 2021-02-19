import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2504 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>(); // 좌괄호만 스택에 쌓는다.
		String s = br.readLine(); // 괄호 받아쥼 
		int sum = 0; // 괄호의 합 
		int temp = 1; // 누적이 어떻게 곱해지는지 
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i); 
			
			if(c=='(') { // 좌괄호면 
				stack.push(c);
				temp*=2; // 곱해준다. '(' 는 2만큼
			}
			else if(c=='[') { // 좌괄호면 
				stack.push(c);
				temp*=3; //곱해준다. '[' 는 3만큼
			}else if(!stack.isEmpty()) { // 스택이 비어있지 않다면 
				if(c ==')') { //우괄호 ) 가 온다면 
					if(s.charAt(i-1)=='(') {  // 바로 직전이 ( 였나! 
						sum+=temp; // 그럼 누적 temp를 합산  ( ( ( ) <- 이상황. ex) 2* 2* 2 합해짐
					}
					else if(stack.peek()!='(') // 스택에 [ 같은게 있다?! -> error 안맞는 쌍. 
					{
						sum = 0 ; break; // 합 = 0 하고 포문 종료 
					}
					stack.pop(); // 괄호 뺴주고 
					temp/=2; // temp 다시 나눠주고 because 이미 하나 빠져서 누적에서는 없어짐.  
				}
				else if(c==']') { // (와 마찬가지.
					if(s.charAt(i-1)=='[') {
						sum+=temp;
					}
					else if(stack.peek()!='[')
					{
						sum = 0; break;
					}
					stack.pop();
					temp/=3;
				}
				else { // ( 나 [ 이 들어오지 않으면 그거 또한 에러. 
					sum = 0; break;
				}
			}
			else { // 좌괄호도 아닌데 스택이 비어있다 = 에러. 반복문 제어. 
				sum = 0; break;
			}
			
		}
		if(!stack.isEmpty()) sum = 0; // 반복이 종료됬는데 스택에 들어있다? -> 안맞는 괄호. 
		System.out.println(sum);
	}

}
