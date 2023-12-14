import java.util.Comparator;

public class student implements Comparable <student>{
	protected int id;
	String name;
	protected String dept;
	protected int grade;
	
	public student(int id, String name, String dept, int grade) {
		this.id=id;
		this.name=name;
		this.dept=dept;
		this.grade=grade;
	}
	public int getId() {return id;}
	public String getName() {return name;}
	public String getDept() {return dept;}
	public int getGrade() {return grade;}
	
	@Override
	public int compareTo(student s) {
		return this.id-id;
	}
		
	public static Comparator<student> CompName=new Comparator<student>() {
		@Override
		public int compare(student s1,student s2) {
			return s1.name.compareTo(s2.name);
		}
	};
	
	public static Comparator<student> CompDept = new Comparator<student>() {
		@Override
		public int compare(student s1, student s2) {
			return s1.dept.compareTo(s2.dept);
		}
	};
	
	public static Comparator<student> CompGrade = new Comparator<student>() {
		@Override
		public int compare(student s1, student s2) {
			return s1.grade-s2.grade;
		}
	};
}
