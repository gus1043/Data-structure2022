//자료구조 과제 #5 60211704 최지현
public class Main {
	public static int binarySearch(int []a, int first, int last, int target) {
		if (first>last) return -1;
		int mid=(first+last)/2;
		if(a[mid]==target)
			return mid;
		else if(a[mid]>target)
			return binarySearch(a, first, mid-1, target);
		else
			return binarySearch(a, mid+1, last, target);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1=new Node("A", null,null);
		Node n2=new Node("B", null,null);
		Node n3=new Node("C", null,null);
		Node n4=new Node("D", null,null);
		Node n5=new Node("E", null,null);
		Node n6=new Node("F", null,null);
		Node n7=new Node("G", null,null);
		Node n8=new Node("H", null,null);
		Node n9=new Node("I", null,null);
		
		n1.setLeft(n2);
		n1.setRight(n3);
		n2.setLeft(n4);
		n2.setRight(n5);
		n3.setLeft(n6);
		n3.setRight(n7);
		n6.setLeft(n8);
		n7.setRight(n9);
		
		BinaryTree t= new BinaryTree(); //이진트리 객체 t생성
		t.setRoot(n1); //t의 루트 노드를 n1으로
		
		System.out.print("트리 노드 수 = "+t.size(t.getRoot())
		+"\n트리 높이 = "+t.height(t.getRoot()));
		System.out.println();
		
		BinaryTree t2=new BinaryTree();
		Node n=t.Treecopy(n1);
		t2.setRoot(n);
		
		System.out.print("copy트리 노드 수 = "+t2.size(t2.getRoot())
		+"\ncopy트리 높이 = "+t2.height(t2.getRoot()));
		System.out.println();
		
		System.out.println("-----------------");
		//레벨 순회
		System.out.println("레벨 순회 비교");
		t2.levelorder(n); System.out.println();
		t2.levelorder(n); System.out.println();
		
		System.out.println("-----------------");
		//후위 순회
		System.out.println("후위 순회 비교");
		t2.postorder(n); System.out.println();
		t2.postorder(n); System.out.println();
		
		System.out.println("-----------------");
		//전위순회
		System.out.println("전위 순회 비교");
		t2.preorder(n); System.out.println();
		t.preorder(n1); System.out.println();
		
		System.out.println("-----------------");
		System.out.printf("동일성 검사: "
				+BinaryTree.isEqual(t.getRoot(),t2.getRoot()));
		System.out.println();
		
		int A=1;
        int B=2;
        int C=A+B;
        System.out.println(C);
		
        System.out.println("-----------------");
        int []a = {1,2,3,4,5,6,7,8,9};
        System.out.print(binarySearch(a, 1, 9, 3));        

	}


}
