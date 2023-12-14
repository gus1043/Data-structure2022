//자료구조 과제 #5 60211704 최지현
import java.util.*;
public class BinaryTree<Key extends Comparable<Key>> {
	private Node root;
	
	//트리 생성자
	public BinaryTree() {root=null;}
	public Node getRoot() {return root;}
	public void setRoot(Node newRoot) {root=newRoot;}
	public boolean isEmpty() {return root==null;}
	
	public void preorder(Node n) {
		if(n!=null) {
			System.out.print(n.getKey()+" ");
			preorder(n.getLeft());
			preorder(n.getRight());
		}
	}
	
	public void inorder(Node n) {
		if(n!=null) {
			inorder(n.getLeft());
			System.out.print(n.getKey()+" ");
			inorder(n.getRight());
		}
	}
	public void postorder(Node n) {
		if (n!=null) {
			postorder(n.getLeft());
			postorder(n.getRight());
			System.out.print(n.getKey()+" ");
		}
	}
	
	public void levelorder(Node root) {
		LinkedList<Node> q=new LinkedList<Node>();
		Node t;
		
		q.add(root);
		while (!q.isEmpty()) {
			t=q.remove();
			System.out.print(t.getKey()+" ");
			
			if(t.getLeft()!=null)
				q.add(t.getLeft());
			if(t.getRight()!=null)
				q.add(t.getRight());
		}
	}
	
	//n를 루트로 하는 (서브)트리의 노드 수
	public int size(Node n) {
		if(n==null) 
			return 0;
		else
			return (1+size(n.getLeft())+size(n.getRight()));
	}
	
	//n를 루트로 하는 (서브)트리의 높이
	public int height(Node n) {
		if(n==null)
			return 0;
		else
			return (1+Math.max(height(n.getLeft()), height(n.getRight())));
	}
	
	//두 트리의 동일성 비교
	public static boolean isEqual(Node n, Node m) {
		//둘다 null이면 true, 아니면 false
		if(n==null||m==null)
			return n==m;
		
		//둘다 null이 아니면 item 비교
		if(n.getKey().compareTo(m.getKey())!=0)
			return false;
		
		//item이 같으면 왼쪽/오른쪽 자식으로 재귀 호출
		return (isEqual(n.getLeft(), m.getLeft())&&
				isEqual(n.getRight(), m.getRight()));
	}
	
	public Node Treecopy(Node t) {
		if(t!=null) {
			Node temp=t;
			temp.setLeft(Treecopy(t.getLeft()));
			temp.setRight(Treecopy(t.getRight()));
			return temp;
		}
		return null;
	}
	
}
