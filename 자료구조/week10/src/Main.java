//아님 내가 그냥 복붙한 거임

public class Main {

	public static void main(String[] args) {
		BST t=new BST(30,"Apple");
		
		t.put(10, "Banana");
		t.put(80, "Melon");
		t.put(20, "Orange");
		t.put(0, "Tangerine");
		t.put(25, "Kiwi");
		t.put(15, "Grape");
		t.put(80, "Strawberry");
		t.put(70, "Cherry");
		t.put(35, "Lemon");
		
		System.out.println("1. 키와 값 10개 삽입 후>>");
		t.print(t.root);
		System.out.println("\n\n높이 = "+t.height()+"\n");
		
		t.put(40, "Mango");

		System.out.println("최소 키값 = "+t.min());

		System.out.println("2. 최소 키 삭제 후>>");
		t.deleteMin();
		t.print(t.root); System.out.println();
		
		System.out.println("\n3. 15, 35 삭제 후>>");
		t.delete(15);
		t.delete(35);
		t.print(t.root); System.out.println();
		
		System.out.println("\n4. 최대 키 삭제 후>>");
		t.deleteMax();
		t.print(t.root); System.out.println();
		
		
	}

}
