import java.util.NoSuchElementException;

public class SList <E extends Comparable<E>> {
	protected Node head;
	private int size;
	
	public SList() {
		head=null;
		size=0;
	}
	
	public int search(E target) {
		Node p = head;
		
		for(int i=0;i<size;i++) {
			if (target==p.getItem()) return i;
			p=p.getNext();
		}
		return -1;
	}
	
	public void insertFront(E newItem) {
		head=new Node(newItem, head);
		size++;
	}
	
	public void insertAfter(E newItem, Node p) {
		p.setNext(new Node(newItem, p.getNext()));
		size++;
	}
	
	
	public void deleteFront() {
		if (isEmpty()) throw new NoSuchElementException();
		head=head.getNext();
		size--;
	}
	
	public void deleteAfter(Node p) {
		if (p==null) throw new NoSuchElementException();
		Node t = p.getNext();
		p.setNext(t.getNext());
		t.setNext(null);
		size--;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	public int size() {return size;}
	
	public void print() {
		for (Node p=head;p!=null;p=p.getNext()) {
			System.out.print(p.getItem()+"\t");
		}
		System.out.println();
	}
	
	public Node mergeTwoList(Node p1, Node p2) {
		Node head = new Node(0, null);
		Node p = head;
		
		while (p1!=null&&p2!=null) {
			int c = p1.getItem().compareTo(p2.getItem());
			
			if(c<0) {
				p.setNext(p1);
				p1=p1.getNext();
			}
			else {
				p.setNext(p2);
				p2=p2.getNext();
			}
			p=p.getNext();
			}
		
		if(p1!=null) p.setNext(p1);
		if(p2!=null) p.setNext(p2);
		
		return head.getNext();
	}

	public void splitList(Node p, int k, SList l1, SList l2) {
		Node head1=new Node(0,null);
		Node head2=new Node(0,null);
		Node p1=head1;
		Node p2=head2;
		
		while(p!=null) {
			int c= p.getItem().compareTo(k);
			if (c<=0) {
				p1.setNext(p);
				p1=p1.getNext();
			}
			else {
				p2.setNext(p);
				p2=p2.getNext();
			}
			p=p.getNext();
		}
		p1.setNext(null);
		p2.setNext(null);
		l1.setHead(head1.getNext());
		l2.setHead(head2.getNext());
	}

	
}
