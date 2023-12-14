import java.util.LinkedList;

public class AVL <Key extends Comparable<Key>, Value>{
	public Node root;
	public Node getRoot() {return root;}
	public AVL(Key newId, Value newName) {
		root=new Node(newId, newName, 0);
	}
	
	private Node rotateRight(Node n) {
		Node x=n.left;
		x.left=x.right;
		x.right=n;
		//높이 갱신
		n.height=tallerHeight(height(n.left), height(n.right))+1;
		x.height=tallerHeight(height(x.left), height(x.right))+1;
		
		return x; //회전 후 x가 n의 이전 자리로 이동되었으므로 		
	}
	private Node rotateLeft(Node n) {
		Node x=n.right;
		n.right=x.left;
		x.left=n;
		//높이 갱신
		n.height=tallerHeight(height(n.left), height(n.right))+1;
		x.height=tallerHeight(height(x.left),height(x.right))+1;
		
		return x; //회전 후 x가 n의 이전 자리로 이동되었으므로 
	}
	
	//삽입 연산
	public void put(Key k, Value v) {root=put(root, k, v);}
	
	private Node put(Node n, Key k, Value v) {
		if (n==null) return new Node(k, v, 1);
		
		int t=k.compareTo((Key)n.id);
		if(t<0) n.left=put(n.left, k, v);
		else if(t>0) n.right=put(n.right, k, v);
		else {
			n.name=v; //k가 이미 트리에 있으므로 Value v만 갱신
			return n;
		}
		
		n.height=tallerHeight(height(n.left), height(n.right))+1;
		
		return balance(n); //노드 n의 균형 점검 및 불균형을 바로 잡음
	}
	
	//불균형 처림
	private Node balance(Node n) {
		//노드 n의 왼쪽 서브트리가 높아서 불균형 발생
		if (bf(n)>1) {
			if(bf(n.left)<0) { //노드 n의 왼쪽 자식 노드의 오른쪽 서브트리가 높은 경우
				n.left=rotateLeft(n.left); //LR-회전
			}
		n=rotateRight(n); //LL-회전
		}
	//노드 n의 오른쪽 서브트리가 높아서 불균형 발생
	else if(bf(n)<-1) {
		if (bf(n.right)>0) {//노드 n의 오른쪽 자식 노드의 왼쪽 서브트리가 높은 경우
			n.right=rotateRight(n.right); //RL-회전
		}
		n=rotateLeft(n); //RR-회전
	}
	return n;
	}
	
	//bf 계산(bf = 왼쪽 서브트리 높이 - 오른쪽 서브트리 높이
	private int bf(Node n) {
		return height(n.left)-height(n.right);
	}
	
	//높이 계산
	public int height(Node n) {
		if (n==null) return 0;
		return n.height;
	}
	
	//높이 비교
	private int tallerHeight(int x, int y) {
		if (x>y) return x;
		else return y;
	}
	
	//삭제 연산
	public void delete(Key k) {root = delete(root, k);}
	
	private Node delete(Node n, Key k) {
		if (n==null) return null;
		int t=k.compareTo((Key)n.id);
		
		if (t<0) n.left=delete(n.left, k);
		else if(t>0) n.right=delete(n.right, k);
		else {
			if(n.left==null) return n.right;
			else if (n.right==null) return n.left;
			else {
				Node target = n;
				n=min(target.right);
				n.right=deleteMin(target.right);
				n.left=target.left;
			}
		}
		n.height=tallerHeight(height(n.left), height(n.right))+1;
		return balance(n);
	}
	
	//최소값 삭제
	public void deleteMin() {
		if (root==null) System.out.println("empty 트리");
		root=deleteMin(root);
	}
	private Node deleteMin(Node n) {
		if (n.left==null) return n.right;
		
		n.left=deleteMin(n.left);
		n.height=tallerHeight(height(n.left), height(n.right))+1;
		
		return balance(n);
	}
	
	//최소값 key를 리턴
	public Key min() {
		if(root==null) return null;
		return (Key) min(root).id;
	}
	
	private Node min(Node n) {
		if (n.left==null) return n;
		return min(n.left);
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
					System.out.print(n.id+" ");
					preorder(n.left);
					preorder(n.right);
				}
			}
			
			//중위 순회
			public void inorder(Node n) {
				if(n!=null) {
					inorder(n.left);
					System.out.print(n.id+" ");
					inorder(n.right);
				}
			}
			
			//후위 순회
			public void postorder(Node n) {
				if(n!=null) {
					postorder(n.left);
					postorder(n.right);
					System.out.print(n.id+" ");
				}
			}
			
			//레벨순회
			public void levelorder(Node root) {
				LinkedList<Node> q=new LinkedList<Node>();
				Node t;
				
				q.add(root);
				while (!q.isEmpty()) {
					t=q.remove();
					System.out.print(t.id+" ");
					
					if(t.left!=null)
						q.add(t.left);
					if(t.right!=null)
						q.add(t.right);
				}
			}
}
