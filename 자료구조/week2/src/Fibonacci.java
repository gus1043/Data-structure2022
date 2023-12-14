
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result;
		result=fib(4);
		System.out.println(result);
		
		int result2;
		result2=fib_iter(4);
		System.out.println(result2);

	}
	//순환이 느린 예:피보나치 수열
	public static int fib(int n) {
		if(n==0) return 0;
		else if (n==1) return 1;
		else
			return fib(n-1)+fib(n-2);
	}
	//시간복잡도 O(2 n승)
	
	
	
	//만약 반복문으로 구현한다면-->시간 복잡도 O(n)
	public static int fib_iter(int n) {
		if(n<2) return n;
		else {
			int last =0;
			int current =1;
			for(int i=2;i<n+1;i++) {
				int tmp=current;
				current+=last;
				last=tmp;
			}
			return current;
		}
	}
}
