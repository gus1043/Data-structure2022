import java.util.NoSuchElementException;
public class SList_class <E extends Comparable<E>> {
	
	protected Node head; //연결 리스트의 첫 노드 가리킴
	private int size;
	
	public SList_class() { //연결 리스트 생성자
		head=null;
		size=0;
	}
	public int search(E target) { //target을 탐색
		Node p = head;
		
		for(int k=0; k<size;k++) {
			if(target==p.getItem()) return k;
			p=p.getNext();
			}
		return -1; //탐색을 실패한 경우 -1 리턴
	}
	//연결리스트 맨 앞에 새 노드 삽입
	public void insertFront(E newItem) {
		head=new Node(newItem, head);
		size++;
	}
	//노드 p 바로 다음에 새 노드 삽입
	public void insertAfter(E newItem, Node p) {
		p.setNext(new Node(newItem, p.getNext()));
		size++;
	}
	//리스트의 첫 노드 삭제
	public void deleteFront() {
		if (isEmpty())
			throw new NoSuchElementException();
		head=head.getNext();
		size--;
	}
	public int size() {return size;}
	//리스트가 empty이면 true 리턴
	public boolean isEmpty() {
		return size==0;
	}
	//p가 가리키는 노드의 다음 노드를 삭제
	public void deleteAfter(Node p) {
		if(p==null) throw new NoSuchElementException();
		
		Node t=p.getNext();
		p.setNext(t.getNext());
		t.setNext(null);
		size--;
	}
	public void print() {
		for (Node p=head;p!=null;p=p.getNext()) {
			System.out.print(p.getItem()+"\t");}
		System.out.println();	
	}
	

}
