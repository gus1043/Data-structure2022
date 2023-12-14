import java.util.NoSuchElementException;

public class DList <E> {
	protected DNode head, tail;
	protected int size;
	
	//이중연결리스트 생성자
	public DList() {
		head = new DNode (null, null, null);
		tail = new DNode(null, head, null); //tail의 이전 노드를 head로
		head.setNext(tail); //head의 다음 노드를 tail로
		size=0;
	}
	
	//탐색, 삽입, 삭제 연산을 위한 메소드 선언
	//p가 가리키는 노드 앞에 삽입
	public void insertBefore(DNode p, E newItem) {
		DNode t=p.getPrevious();
		DNode newNode = new DNode(newItem, t, p);
		p.setPrevious(newNode);
		t.setNext(newNode);
		size++;
	}
	
	//p가 가리키는 노드 뒤에 삽입
	public void insertAfter(DNode p, E newItem) {
		DNode t=p.getNext();
		DNode newNode=new DNode(newItem, p, t);
		t.setPrevious(newNode);
		p.setNext(newNode);
		size++;
	}
	
	public void delete(DNode x) {
		if (x==null) throw new NoSuchElementException();
		DNode f = x.getPrevious();
		DNode r = x.getNext();
		f.setNext(r);
		r.setPrevious(f);
		size--;
	}
	
	public void print() {
		for(DNode p=head; p!=null; p=p.getNext()) {
			if(p.getItem()!=null) {
				System.out.print(p.getItem()+"\t");}			
		}
		
		DNode p=head;
		DNode q=tail;
		if (p.getNext()==q) {
			System.out.print("리스트 비어있음");
		}
		System.out.println();
	}
}
