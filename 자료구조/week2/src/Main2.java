import java.util.Arrays;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student2[] studs2= {
				new Student2(14042,"박**","융소",2),
				new Student2(62028,"한**","국문",3),
				new Student2(49064,"정**","경제",4),
				new Student2(14055,"장**","융소",2),
				new Student2(31076,"박**","경영",3),
				new Student2(29010,"이**","컴퓨터",1),
				new Student2(67034,"김**","영문",4),
				new Student2(14020,"최**","융소",1),
				new Student2(14007,"강**","융소",2),
				new Student2(51061,"남**","경영",3)
		};
		
		Arrays.sort(studs2);
		print(studs2,"id");
		
		Arrays.sort(studs2,Student2.CompName);
		print(studs2,"이름");
		
		Arrays.sort(studs2,Student2.CompDept);
		print(studs2,"학과");
		
		Arrays.sort(studs2,Student2.CompGrade);
		print(studs2,"학년");
	}
		
		
		
	public static void print(Student2[] studs2, String key) {
		System.out.println();
		System.out.println(key + "로 정렬");
		System.out.println("-----------------");
		for(Student2 s: studs2) {
			System.out.println(s.getId()+" "+s.getName()+" "+s.getDept()+" "+s.getGrade());
		}
	}	
		

	

}