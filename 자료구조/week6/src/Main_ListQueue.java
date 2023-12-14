
public class Main_ListQueue {

	public static void main(String[] args) {
		ListQueue <String> queue = new ListQueue<String>();
		
		queue.add("apple"); 
		queue.add("orange");  
		queue.add("cherry"); 
		
		queue.add("pear");  queue.print();
		
		queue.remove(); queue.print();
		queue.remove();  queue.print();
		queue.remove(); queue.print();
		queue.remove(); queue.print();
		
		queue.add("grape"
				+ "");  queue.print();
	}

}
