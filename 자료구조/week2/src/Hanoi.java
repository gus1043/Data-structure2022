//자료구조 과제 #1 60211704 최지현

public class Hanoi {
	public Hanoi(int count) {	
		System.out.println("원반이 "+count+"개인 경우");
		if (count>1) {
			System.out.print("원반 이름 : 크기 작은-큰 순서 ");
			for(int i=1;i<=count;i++) {
				System.out.print(i); 
				if (i!=count) System.out.print("-");
				else System.out.println();}}
		
		recurse(count, 'A','B','C');
		}
	
	public static void recurse(int count, char start, char mid, char end) {
		if (count==1) {
			System.out.println("원반 "+count+"을 "+start+"에서 "+end+"로 이동");}
		else {
			recurse(count - 1, start, end, mid);
			// 2. 1개를 start-> end로 이동
			System.out.println("원반 "+count+"을 "+start+"에서 "+end+"로 이동");
			// 3. n-1개를 다시 mid-> end로 이동
			recurse(count - 1, mid, start, end);
			
			
		}
		
		
	}
	

	public static void main(String[] args) {
		Hanoi hanoi=new Hanoi(3);
		

	}

}
