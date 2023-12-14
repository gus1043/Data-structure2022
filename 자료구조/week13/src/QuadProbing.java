//자료구조 과제 #9(60211704 최지현)
public class QuadProbing<K,V> {
	private int N=0, M= 11; //테이블 크기 
	private K[] a= (K[]) new Object[M]; //해시테이블
	private V[] d=(V[]) new Object[M]; //key 관련 데이터 저장
	private K [] c=(K[])new Object[M]; //충돌 입력값 저장
	private int [] ccount=new int[M];//충돌 횟수 저장 
	public int ci=0; //충돌 관련 리스트 저장 인덱스
	
	private int hash(K key) { //해시코드
		return (key.hashCode()&0x7fffffff) % M; //나눗셈 함수
	}
	private void put(K key, V data) { //삽입 연산
		int initialpos=hash(key); //초기 위치
		int i=initialpos, j=1;
		int c_count=0;
		do {
			if (a[i]==null) { //삽입 위치 발견
				a[i]=key; //key를 해시 테이블에 저장
				d[i]=data; N++; //key 관련 데이터 저장
				if (c_count>0) {
					c[ci]=key; 
					ccount[ci]=c_count; ++ci; 
				}
				return;
			}
			if (a[i].equals(key)) { //key가 이미 존재
				d[i]=data; //data데이터만 갱신
			}
			c_count++;
			i=(initialpos+j*j++) % M; //충돌 발생시 i=다음 위치
		}while(N<M); //full
	}
	
	public V get(K key) { //탐색 연산
		int initialpos=hash(key);
		int i = initialpos, j=1;
		while(a[i]!=null) { //a[i]가 empty가 아니면
			if (a[i].equals(key)) 
				return d[i]; 
			i=(initialpos+j*j++) % M; //i=다음위치			
		}
		return null; //탐색 실패
	}
	
	
	public static void main(String[] args) {
		QuadProbing t = new QuadProbing();
		
		//71, 23, 73, 49, 54, 89, 39을 차례로 해시테이블에 저장
		t.put(71,  "grape"); t.put(23,  "apple"); t.put(73,  "banana"); 
		t.put(49,  "cherry"); t.put(54,  "mango"); t.put(89,  "lime"); 
		t.put(39,  "orange"); 
				
				System.out.println("탐색결과: ");
				System.out.println("71의 데이터: "+t.get(71));
				System.out.println("89의 데이터: "+t.get(89));
		System.out.println("해시테이블: ");
		for (int i=0; i<t.M;i++) 
			System.out.printf("\t%d",i);
		System.out.println();
		for (int i=0; i<t.M;i++) 
			System.out.printf("\t%d",t.a[i]);
		System.out.println();
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
