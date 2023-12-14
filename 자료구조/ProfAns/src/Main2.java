
public class Main2 {
	public static void checkPaired(String s) {
		ListStack<Character> stack = new ListStack<Character>();
		int mismatch=-1;
		
		for(int i=0;i<s.length()&&mismatch==-1;i++) {
			switch(s.charAt(i)) {
			case '(':
			case'{':
				stack.push(s.charAt(i)); break;
			case ')':
				if(stack.isEmpty()) mismatch=i;
				else if(stack.pop() !='(') mismatch=i;
				break;
			case '}':
				if(stack.isEmpty()) mismatch=i;
				else if(stack.pop() !='{') mismatch=i;
				break;
			}
		}
		if (mismatch != -1)
			System.out.println(s.substring(0, mismatch) +
					"^^^부처 괄호 쌍이 맞지 않습니다.");
		else if((!stack.isEmpty()))
			System.out.println(s+"^^^부터 괄호쌍이 맞지 않습니다");
		else
			System.out.println("괄호쌍이 맞습니다.");
	}

	public static void main(String[] args) {
		String str=new String("{{(){()}}}");
		System.out.println(str);
		checkPaired(str);
		
		str=new String("{{(){()})()}");
		System.out.println("\n"+str);
		checkPaired(str);
		
		str=new String("{{()(}}}");
		System.out.println(str);
		checkPaired(str);
		
		str=new String(")}");
		System.out.println("\n"+str);
		checkPaired(str);

	}

}
