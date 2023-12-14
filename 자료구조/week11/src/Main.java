//자료구조 과제 #6 60211704 최지현
public class Main {

	public static void main(String[] args) {
		AVL t=new AVL(50,"Apple");
		
		t.put(60, "Banana");
		t.put(20, "Melon");
		t.put(10, "Orange");
		t.put(40, "Tangerine");
		t.put(25, "Kiwi");
		t.put(15, "Grape");
		t.put(80, "Strawberry");
		t.put(70, "Cherry");
		t.put(35, "Lemon");
		
		System.out.println("1. 키와 값 10개 삽입 후>>");
		t.print(t.root);
	
		
		System.out.println("최소 키값 = "+t.min());

		System.out.println("2. 최소 키 삭제 후>>");
		t.deleteMin();
		t.print(t.root); System.out.println();
		
		System.out.println("\n3. 15, 35 삭제 후>>");
		t.delete(15);
		t.delete(35);
		t.print(t.root); System.out.println();
	
		
		
	}

}
