public class Node2 <E extends Comparable<E>>{
	private E item;
	private Node2 <E> next;
	
	//생성자
	public Node2(E newItem, Node2 <E> p) {
		item = newItem;
		next= p;
	}

	//get 메소드와 set 메소드
	public E getItem() {return item;}
	public Node2<E> getNext() {return next;}
	public void setItem(E newItem) {item=newItem;}
	public void setNext(Node2<E> n) {next=n;}
}