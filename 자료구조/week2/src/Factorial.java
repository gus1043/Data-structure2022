
public class Factorial {
	public static int factorial(int n) {
		if(n<=1)
			return 1;
		else
			return n*factorial(n-1);
	}

	public static void main(String[] args) {
		int result;
		result = factorial(4);
		System.out.println(result);
		
		
		
		
		//for������ �����
		int n=4;
		int result2=1;
		for (int i=1;i<=n;i++)
			result=result*i;
		System.out.println(result);
	}
	//���丮�� �ð����⵵ O(n)
	
	
	
	
	
	

}
