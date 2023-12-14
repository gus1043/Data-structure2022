public class Main {
	
	public static int prec(char op) { 
		switch (op) {
			case '(': 
			case ')': 
				return 0; 
			case '+': 
			case '-': 
				return 1; 
			case '*': 
			case '/': 
				return 2; } 
		return -1; }

	public static void changeWrite(String s) {
		ListStack<Character> stack = new ListStack<Character>();
		String str="";
		 for (int i = 0; i < s.length(); i++) {
	            char now = s.charAt(i);
	            switch (now){
	                case '+':
	                case '-':
	                case '*':
	                case '/':
	                    while (!stack.isEmpty() && prec(stack.peek()) >= prec(now)) {
	                       str+=Character.toString(stack.pop());
	                    }
	                    stack.push(now);
	                    break;
	                case '(':
	                    stack.push(now);
	                    break;
	                case ')':
	                    while(!stack.isEmpty() && stack.peek() != '('){
	                    	str+=Character.toString(stack.pop());
	                    }
	                    stack.pop();
	                    break;
	                default:
	                	str+=Character.toString(now);
	            }
	        }

	        while (!stack.isEmpty()) {
	            str+=Character.toString(stack.pop());
	        }
	        System.out.print(str);
	    }
	public static void main(String[] args) {
		System.out.print("a: ");
		String str = new String("A-B+C/D");
		System.out.println(str);
		System.out.print(">> ");
		changeWrite(str);
		System.out.println();
		
		System.out.print("\nb: ");
		str = new String("A/B-C*D");
		System.out.println(str);
		System.out.print(">> ");
		changeWrite(str);
		System.out.println();
		
		System.out.print("\nc: ");
		str = new String("A-B*C+D/E-F");
		System.out.println(str);
		System.out.print(">> ");
		changeWrite(str);
		System.out.println();
		
		System.out.print("\nd: ");
		str = new String("(A-B)*C(D/(E+F))");
		System.out.println(str);
		System.out.print(">>");
		changeWrite(str);
		System.out.println();
		
	}

}