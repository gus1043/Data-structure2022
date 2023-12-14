
public class Main_unionfind {

	public static void main(String[] args) {
		int N=10;
		Node_unionfind [] a=new Node_unionfind[N];
		
		for(int i=0; i<N;i++)
			a[i]=new Node_unionfind(i,0);
		
		UnionFind uf=new UnionFind(a);
		
		uf.union(2, 1);		uf.union(2,6);
		uf.union(7, 3);		uf.union(4, 5);
		
		uf.union(9, 5);		uf.union(7, 2);
		uf.union(7, 8);		uf.union(0, 4);
		

		
		for (int i=0; i<N;i++) {
			System.out.print(uf.a[i].getParent()+" ");
		}
		System.out.println();
		
		uf.union(9, 1);

		for (int i=0; i<N;i++) {
			System.out.print(uf.a[i].getParent()+" ");
		}
		


	}

}
