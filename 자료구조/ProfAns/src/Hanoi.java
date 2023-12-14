
public class Hanoi {
	public static void hanoi(int n, char from, char by, char to) {
		if (n==1) 
			System.out.println("원반 1을 "+from+"에서 "+to+"로 이동");
		else {
			hanoi(n-1, from, to, by);
			System.out.println("원반 "+n+"을 "+from+"에서 "+to+"로 이동");
			hanoi(n-1, by, from, to);
		}
	}

	public static void main(String[] args) {
		System.out.println("원반이 3개인 경우\n(원반 이름 : 크기가 작은-큰 순서 1-2-3)\n");
		hanoi(3,'A','B','C');
		
		System.out.println("원반이 4개인 경우\n(원반 이름 : 크기가 작은-큰 순서 1-2-3)\n");
		hanoi(4,'A','B','C');
		

	}

}
