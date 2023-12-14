//자료구조 과제 #8 60211704 최지현
public class BHeap_class<Key extends Comparable<Key>, Value> {
	private Entry[] a; //a[0]은 사용 안함
	private int N; //힙크기
	public BHeap_class(Entry[] harray, int initialSize) {
		a=harray;
		N=initialSize;
	}
	public int size() {return N;} //힙의 크기 리턴
	private boolean greater(int i, int j) { //키 비교
		return a[j].getKey().compareTo(a[i].getKey())<0;  //a[j]가 더 작으면 교환
	}
	private void swap(int i, int j) { //a[i]와 a[j]를 교환
		Entry temp = a[i]; a[i]=a[j]; a[j]=temp;
	}
	
	public void print() {
		for (int i=1; i<N+1 ; i++) {
			System.out.printf("["+a[i].getKey()+" "+a[i].getValue()+"]");
		}
		System.out.println();
		System.out.printf("힙 크기 = "+size()+"\n\n");
	}
	
	//creapteheap, 삽입, 최솟값 삭제, downheap, upheap 메소드 선언
	public void createHeap() {//초기 힙 만들기
		for(int i=N/2; i>0;i--) {
			downheap(i);
		}
	}
	private void downheap(int i) {
		while (2*i<=N) { //왼쪽 자식이 있는지
			int k=2*i;
			if (k<N && greater(k,k+1)) k++; //왼쪽 자식<오른쪽자식이면 k값이 k+1이 됨
			if(!greater(i,k)) break;  //현재 노드가 자식보다 작으면 break 후 종료
			swap(i,k); //교환 
			i=k;
		}
	}
	
	public void insert(Key newKey, Value newValue) {
		Entry temp=new Entry(newKey, newValue) ;
		a[++N]=temp; //배열 마지막에 새 노드 temp 삽입
		upheap(N);
	}
	
	private void upheap(int j) {
		while (j<1 & greater(j/2, j)) {
			swap(j/2, j);
			j=j/2;
		}
	}
	
	public Entry deleteMin() {
		Entry min = a[1]; //루트가 최소값
		swap(1, N--); //맨 아래 있는 것과 swap하고 크기 줄여줌
		a[N+1] = null;
		downheap(1);
		return min;
	}
}
