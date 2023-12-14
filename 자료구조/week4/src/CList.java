import java.util.NoSuchElementException;

public class CList <E extends Comparable<E>> {
	private Node2 last; //리스트의 마지막 노드(항목)
	private int size; //리스트의 항목(노드) 수
	
	//원형 연결리스트 생성자
	public CList() {
		last=null;
		size=0;
	}
	//last가 가리키는 노드의 다음에 새노드 삽입
	public void insert(E newItem) {
		Node2 newNode = new Node2(newItem, null);
		if (last == null) {
			newNode.setNext(newNode);
			last=newNode;
		}
		else {
			newNode.setNext(last.getNext());
			last.setNext(newNode);
		}
		size++;
	}
	//last가 가리키는 노드의 다음 노드를 제거
	public void delete() {
		if(isEmpty()) throw new NoSuchElementException();
		
		Node2 x = last.getNext();
		if (x==last) last = null;
		else {
			last.setNext(x.getNext());
		}
		size--;
	}
	public void print() {
        if (size>0) {
        	int i=0;
        	for(Node2 p=last.getNext();i<size;p=p.getNext(),i++)
        		System.out.print(p.getItem()+"\t");
            }
        else
        	System.out.println("리스트 비어있음");
        System.out.println();
    }
	public boolean isEmpty() {
		return size==0;
	}
	public int size() {
		return size;
	}
}
