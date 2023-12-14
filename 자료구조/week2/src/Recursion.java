
public class Recursion {
	public void recurse(int count) {
		if (count <= 0)
			System.out.println(".");
		else {
			recurse(count-1);
			System.out.println(count+"*");
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Recursion r = new Recursion();
		r.recurse(5);

	}

}
