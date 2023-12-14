//자료구조 과제 #9(60211704 최지현)
public class Chaining <K, V> {
	private int M=11; //테이블 크기
	private Node[] a = new Node[M];	//해시테이블
	private K [] c=(K[])new Object[M]; //충돌 입력값 저장
	private int [] ccount=new int[M];//충돌 횟수 저장 
	public int ci=0; //충돌 관련 리스트 저장 인덱스
	
	public static class Node<K> { //Node 클래스
		private Object key;
		private Object data;
		private Node next;
		private Node(Object newkey, Object newdata, Node ref) { //생성자
			key = newkey;
			data=newdata;
			next=ref;
		}
		public Object getKey() {return key;}
		public Object getData() {return data;}
	}
	private int hash(K key) { //해시코드
		return (key.hashCode()&0x7fffffff) % M; }//나눗셈 함수
		
	public void put(K key, V data) { //삽입 연산
		int i = hash(key); int c_count=0;
		for (Node x = a[i]; x != null; x=x.next) {
			c_count++;
			if (key.equals(x.key)) { //이미 key 존재
				x.data=data; //데이터만 갱신
				return;
			}
		}
		if (c_count>0) {
			c[ci]=key; 
			ccount[ci]=c_count; ++ci; 
		}
		a[i]= new Node(key, data, a[i]); //연결 리스트의 첫 노드로 삽입
	}
	public V get(K key) {//탐색 연산
		int i= hash(key);
		for(Node x=a[i]; x!=null; x=x.next) //연결리스트 탑색
			if(key.equals(x.key)) 
				return (V) x.data; //탐색 성공
			return null;//탐색 실패
	}
	
	public static void main(String[] args) {
		Chaining t=new Chaining();
		
		//71, 23, 73, 49, 54, 89, 39을 차례로 해시테이블에 저장
		t.put(71,  "grape"); t.put(23,  "apple"); t.put(73,  "banana"); 
		t.put(49,  "cherry"); t.put(54,  "mango"); t.put(89,  "lime"); 
		t.put(39,  "orange"); 
				
		System.out.println("탐색결과: ");
		System.out.println("71의 데이터: "+t.get(71));
		System.out.println("23의 데이터: "+t.get(23));
		System.out.println("49의 데이터: "+t.get(49));
		System.out.println("89의 데이터: "+t.get(89));
		
		System.out.println();		System.out.println("해시테이블: ");
		for (int i=0; i<t.M;i++) {
			System.out.print(String.format("\t%d",i));
			Node x=t.a[i];
			while(x!=null) {
				System.out.print("-->["+x.getKey()+","+x.getData()+"]");
				x=x.next;
			}
		System.out.println();
		}
		
		System.out.println();
		System.out.println("충돌 입력값: ");
		for (int i=0; i<t.ci;i++) 
			System.out.printf("\t%d",t.c[i]);
		System.out.println();
		
		System.out.println("충돌 횟수: ");
		for (int i=0; i<t.ci;i++) 
			System.out.printf("\t%d",t.ccount[i]);
		System.out.println();

		}

}
