import java.util.EmptyStackException;

public class ListStack_class <E> {
	private Node <E> top; //스텍 top 항목을 가진 Node를 가리킴
	private int size; //스텍 항목 수
	
	public ListStack_class() { //스택 생성ㅈ
		top=null;
		size=0;
	}
	
	//스택 top 항목만을 리턴
	public E peek() {
		//underflow 시 프로그램 정지
		if (isEmpty()) {
			throw new EmptyStackException();}
			
		return top.getItem();
		}
		
	//스텍의 항목의 수를 리턴
	public int size() {return size;}
		
	//스텍이 empty면 true를 리턴
	public boolean isEmpty() {return size==0;}
		
	//스텍 push 연산
	public void push(E newItem) {
		//top 노드 앞에 새 노드 삽입
		Node newNode = new Node(newItem, top);
		
		top = newNode; //top이 새 노드 가리킴
		size++; //스택 항목 수 1 증가
	}
	
	//스택 pop연산
	public E pop() {
		//underflow 시 프로그램 정지
		if (isEmpty())
			throw new EmptyStackException();
		
		E topItem = top.getItem();
		top=top.getNext(); //top이 top 바로 아래 항목을 가리킴
		size--; //스택 항목 수를 1 감소
		
		return topItem;
	}
	//스택의 항목들을 top부터 차례로 출력
	public void print() {
		if (isEmpty())
			System.out.print("라스트가 비어있음");
		else
			for(Node p=top;p!=null;p=p.getNext())
				System.out.print(p.getItem()+"\t ");
		System.out.println();
	}
}
