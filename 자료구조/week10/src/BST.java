//자료구조 과제 #6 60211704 최지현
import java.util.*;
public class BST<Key extends Comparable<Key>, Value> {
	public Node root;
	public Node getRoot() {return root;}
	
	public BST(Key newId, Value newName) {
		root=new Node(newId, newName);
	}
	
	//get, put, min, deleteMin, delete 메소드들 선언
	
	//트리에서 k값을 갖는 노드를 탐색&Value 리턴
	public Value get(Key k) {return get(root, k);}
	
	//n을 루트로 하는 (서브)트리에서 k값을 갖는 노드를 탐색 & Value 리턴
	public Value get(Node n, Key k) {
		if(n==null) return null;
		
		int t=n.getKey().compareTo(k);
		
		if(t>0) //if(k<노드 n의 id) 왼쪽 서브 트리 탐색
			return get(n.getLeft(), k);
		else if(t<0)
			return get(n.getRight(),k);
		else 
			return (Value)n.getValue();
	}
	
	//트리에 노드(k,v)를 삽입
	public void put(Key k, Value v) {
		root = put(root, k, v);
	}
	
	//n을 루트로하는 (서브)트리에 노드 (k,v)를 삽입
	public Node put(Node n, Key k, Value v) {
		if(n==null) return new Node(k,v);
		
		int t=n.getKey().compareTo(k);
		if(t>0)  //if(k<노드 n의 id) 왼쪽 서브 트리에 삽입
			n.setLeft(put(n.getLeft(),k,v));
		else if(t<0) //if(k>노드 n의 id) 오른쪽 서브 트리에 삽입
			n.setRight(put(n.getRight(),k,v)); 
		else
			n.setValue(v);
		
		return n;
	}
	
	//트리에서 최소값을 갖는 노드의 key를 리턴
	public Key min() {
		if(root==null) return null;
		
		return (Key) min(root).getKey();
	}
	
	//n을 루트로 하는 (서브)트리에서 최소값을 갖는 노드를 리턴
	private Node min(Node n) {
		if(n.getLeft()==null) return n;
		
		return min(n.getLeft());
	}
	
	//트리에서 최소값을 갖는 노드를 삭제
	public void deleteMin() {
		if(root==null) System.out.println("empty tree");
		
		root=deleteMin(root);
	}
	
	//n를 루트로 하는 (서브)트리에서 최소값을 갖는 노드를 삭제
	public Node deleteMin(Node n) {
		//if(n의 왼쪽자식==null) n의 오른쪽 자식 리턴
		if(n.getLeft()==null) 
			return n.getRight();
		
		//if(n의 왼쪽자식=/=null), n의 왼쪽 자식으로 재귀 호출
		n.setLeft(deleteMin(n.getLeft()));
		return n;
	}
	
	//트리에서 최대값을 갖는 노드의 key를 리턴
		public Key max() {
			if(root==null) return null;
			
			return (Key) max(root).getKey();
		}
		
		//n을 루트로 하는 (서브)트리에서 최대값을 갖는 노드를 리턴
		private Node max(Node n) {
			if(n.getRight()==null) return n;
			
			return max(n.getRight());
		}
		
		//트리에서 최대값을 갖는 노드를 삭제
		public void deleteMax() {
			if(root==null) System.out.println("empty tree");
			
			root=deleteMax(root);
		}
		
		//n를 루트로 하는 (서브)트리에서 최대값을 갖는 노드를 삭제
		public Node deleteMax(Node n) {
			//if(n의 오른쪽자식==null) n의 왼쪽 자식 리턴
			if(n.getRight()==null) 
				return n.getLeft();
			
			//if(n의 오른쪽자식=/=null), n의 오른쪽 자식으로 재귀 호출
			n.setRight(deleteMax(n.getRight()));
			return n;
		}
		
		//트리에서 k값을 갖는 노드를 삭제
		public void delete(Key k) {
			root=delete(root,k);
		}
		
		//n을 루트로하는 (서브)트리에서 k값을 갖는 노드를 삭제
		public Node delete(Node n, Key k) {
			if(n==null) return null;
			
			int t=n.getKey().compareTo(k);
			if(t>0)  //if (k>노드 n의 id) 왼쪽 자식으로 이동
				n.setLeft(delete(n.getLeft(),k));
			else if(t<0)  //if(k>노드 n의 id) 오른쪽 자식으로 이동
				n.setRight(delete(n.getRight(),k));
			else {  //삭제할 노드 발견
				if(n.getRight()==null)  //case 0,1
					return n.getLeft();
				if(n.getLeft()==null)  //case 1
					return n.getRight();
				
				Node target=n;  //case 2
				//삭제할 노드 자리로 옮겨올 노드 찾아서 n이 가리키게 함
				n=min(target.getRight());
				n.setRight(deleteMin(target.getRight()));
				n.setLeft(target.getLeft());
			}
			return n;
			
		}
		
		//트리의 높이 리턴
		public int height() {
			return height(root)+1;
		}
		
		//n을 루트로 하는 (서브)트리의 높이 리턴
		private int height(Node n) {
			if(n==null) //null이면 -1리턴
				return -1;
			return 1+Math.max(height(n.getLeft()), height(n.getRight()));
		}
		
		//트리 출력 : 세가지 순회 방식 사용
		public void print(Node root) {
			System.out.printf("\ninorder:\n");
			inorder(root);
			System.out.printf("\npreorder:\n");
			preorder(root);
			System.out.printf("\nlevelorder:\n");
			levelorder(root);
		}
		
		//전위 순회
		public void preorder(Node n) {
			if(n!=null) {
				System.out.print(n.getKey()+" ");
				preorder(n.getLeft());
				preorder(n.getRight());
			}
		}
		
		//중위 순회
		public void inorder(Node n) {
			if(n!=null) {
				inorder(n.getLeft());
				System.out.print(n.getKey()+" ");
				inorder(n.getRight());
			}
		}
		
		//후위 순회
		public void postorder(Node n) {
			if(n!=null) {
				postorder(n.getLeft());
				postorder(n.getRight());
				System.out.print(n.getKey()+" ");
			}
		}
		
		//레벨순회
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
