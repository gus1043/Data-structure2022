public class Main_Arraystack {

	public static void main(String[] args) {
		ArrayStack<String> stack = new ArrayStack<String>();
		
		stack.push("apple");
		stack.push("orange");
		stack.push("cherry");
		stack.print();
		
		System.out.println(stack.peek());
		stack.push("pear");
		stack.print();
		stack.peek();
		stack.pop();
		stack.print();
		
		System.out.println(stack.peek());
		stack.push("grape");
		stack.print();
		
	}
 
}
