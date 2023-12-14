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
			System.out.print(n.gerKey()+" ");
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
			System.out.print(n.getKey()+"");
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
	
	
}
