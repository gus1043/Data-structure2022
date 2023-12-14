public class Main_ListStack {

	public static void main(String[] args) {
		ListStack_class<String> stack = new ListStack_class<String>();
		
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