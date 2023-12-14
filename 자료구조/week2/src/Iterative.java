
public class Iterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	//순환이 빠른 예:거듭제곱 계산 시간복잡도 O(n)
		public static int power_iter(int x,int n) {
			int result3=1;
			for(int i=0;i<n;i++)
				result3*=x;
			return result3;
		}
		
		public static int power(int x, int n) {
			if (n==0) return 1;
			else if (n%2==0)
				return power(x*x,x/2);
			else
				return x*power(x*x,(n-1)/2);
		}
		//n이 2의 제곱이라면 문제의 크기가 절반씩 줄어듦
		//시간 복잡도 O(log아래2 N)

}
