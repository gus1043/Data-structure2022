//자료구조 과제 #3 60211704
public class Main2 {
	public boolean check(String str) {
		char operator, testCh;
		ListStack<Character> stack = new ListStack<Character>();
		ListStack<Integer> stack2 = new ListStack<Integer>();
		
		for (int i=0;i<str.length();i++) {
			testCh = str.charAt(i);
			switch(testCh) {
			case'(':
			case'{':
				stack.push(testCh);
				stack2.push(i);
				break;
			case')':
				if(stack.isEmpty())
					return false;
				else {
					operator = stack.peek();
					  if (operator==')'||operator=='{'||operator=='}'){ 
						return false;
					}
					else {
						stack.pop();
						stack2.pop();
						break;}
					}
			case'}':
				if(stack.isEmpty())
					return false;
				else {
					operator = stack.peek();
					  if ((operator==')'||operator=='('||operator=='}')){ 
						return false;
					}
					else {
						stack.pop();
						stack2.pop();
						break;}
					}
			}
			}
		
		if(stack.isEmpty()) {
			return true;
		}
		else 
			return false;
		
	}
	public static void main(String[] args) {
		String st = "{ }";
		String st2 = "{ { ( ) { ( ) } ) ( ) }";
	
		Main2 test = new Main2();
		Main2 test2 = new Main2();
		if(test.check(st)) {
			System.out.println("짝이 맞는 수식입니다");
		}
		else {
			System.out.println("짝이 맞지 않은 수식입니다");			
		}
		if(test2.check(st2)) {
			System.out.println("짝이 맞는 수식입니다");
		}
		else {
			System.out.println("짝이 맞지 않은 수식입니다");			
		}
	}
}
