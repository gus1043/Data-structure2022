import java.util.Arrays;

public class Main_student {
	public static void print(student[] studs, String key) {
		System.out.println();
		System.out.println(key+"으로 정렬");
		System.out.println("------------");
		for(student s:studs) {
			System.out.println(s.getId()+" "+ s.getName()+" "+
		s.getDept()+" "+s.getGrade() );
		}
		
	}

	public static void main(String[] args) {
		student[] studs= {
				new student(14042, "박**", "융소", 2),
				new student(62028, "한**", "국문", 3),
				new student(49064, "최**", "경제", 2),
				new student(31075, "김**", "컴공", 2),
				new student(12354, "이**", "경영", 2),
				new student(42345, "윤**", "융소", 2)};
		
		 Arrays.sort(studs);
		 print(studs, "id");
		 
		 Arrays.sort(studs, student.CompName);
		 print(studs,"이름");
		 
		 
		 
	}

}
