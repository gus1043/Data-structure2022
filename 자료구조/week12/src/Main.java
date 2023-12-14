//자료구조 과제 #8 60211704 최지현
public class Main {

	public static void main(String[] args) {
		Entry[] a =new Entry[16];
		a[1] = new Entry(80, "pear");
		BHeap h=new BHeap(a, 1);
		System.out.println("힙 만들기 전: "); h.print();
		h.createHeap();
		h.print();
		h.insert(40,"kiwi"); System.out.println("40 삽입 후"); h.createHeap(); h.print();
		h.insert(70,"melon"); System.out.println("70 삽입 후"); h.createHeap(); h.print();
		h.insert(30,"grape"); System.out.println("30 삽입 후"); h.createHeap(); h.print();
		h.insert(60,"mango"); System.out.println("60 삽입 후"); h.createHeap(); h.print();
		h.insert(20,"cherry"); System.out.println("20 삽입 후"); h.createHeap(); h.print();
		h.insert(50,"lime"); System.out.println("50 삽입 후"); h.createHeap(); h.print();
		h.insert(10,"banana"); System.out.println("10 삽입 후"); h.createHeap(); h.print();
		
		System.out.println("최소 힙: "); 
		System.out.println(h.deleteMin().getKey());
		
		System.out.println("\nmin 삭제 후"); h.createHeap(); h.print();
		
	}

}
