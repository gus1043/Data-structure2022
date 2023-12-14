import java.util.Comparator;

public class Student2 implements Comparable <Student2> {	
	protected int id;
	String name;
	protected String dept;
	protected int grade;
	
	public Student2 (int id, String name, String dept, int grade) {
		this.id=id;
		this.name=name;
		this.dept=dept;
		this.grade=grade;
	}
	public int getId() {return id;}
	public String getName() {return name;}
	public String getDept() {return dept;}
	public int getGrade() {return grade;}
	
	//학번으로 비겨하는 compare
	@Override
	public int compareTo(Student2 s) {
		return this.id-s.id;
	}
	
	//이름으로 비교하는 compare()
	public static Comparator<Student2> CompName = new Comparator<Student2>() {
		@Override
		public int compare(Student2 s1, Student2 s2) {
			return s1.name.compareTo(s2.name);
		}
	};
	
	//학과 이름으로 비교하는 compare()
	public static Comparator<Student2> CompDept = new Comparator<Student2>() {
		@Override
		public int compare(Student2 s1, Student2 s2) {
			return s1.dept.compareTo(s2.dept);
		}
	};
	
	
	public static Comparator<Student2> CompGrade = new Comparator<Student2>() {
		@Override
		public int compare(Student2 s1, Student2 s2) {
			return s1.grade-s2.grade;
		}
	};
	
	

}
