
public class Main {

	public static void main(String[] args) {
		SList<Integer> t = new SList<Integer>();
		t.insertFront(50);
		t.insertFront(40);
		t.insertFront(30);
		t.insertFront(20);
		t.insertFront(10);
		System.out.print("Sorted List 1:");
		t.print();
		
		SList<Integer> x = new SList<Integer>();
		x.insertFront(55);
		x.insertFront(37);
		x.insertFront(35);
		x.insertFront(18);
		x.insertFront(15);
		System.out.print("Sorted List 2:");
		x.print();
		
		SList<Integer>m = new SList<Integer>();
		m.head=m.mergeTwoList(t.head, x.head);
		
		System.out.print("Mergerd List: ");
		m.print();
		
		SList<Integer> y = new SList<Integer>();
		y.insertFront(45);
		y.insertFront(17);
		y.insertFront(20);
		y.insertFront(50);
		y.insertFront(57);
		y.insertFront(35);
		y.insertFront(10);
		y.insertFront(15);
		y.insertFront(90);
		y.insertFront(10);
		System.out.print("Single List: ");
		y.print();
		
		SList<Integer> l1=new SList<Integer>();
		SList<Integer> l2 = new SList<Integer>();
		y.splitLit(y.head,20, l1, l2);
		
		System.out.println("k=20을 기준으로 두 개의 리스트 분리");
		System.out.print("List 1(<=20): ");
		l1.print();
		System.out.print("List 2(>=20)" );
		l2.print();
		
	}

}
