
public class Iterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	//��ȯ�� ���� ��:�ŵ����� ��� �ð����⵵ O(n)
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
		//n�� 2�� �����̶�� ������ ũ�Ⱑ ���ݾ� �پ��
		//�ð� ���⵵ O(log�Ʒ�2 N)

}
