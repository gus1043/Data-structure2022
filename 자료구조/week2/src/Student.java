public class Student implements Comparable <Student> {
	private int id;
	private String name;
	private String dept;
	private int grade;
	
	public Student (int id, String name, String dept, int grade) {
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
	public int compareTo(Student s) {
		return this.id-s.id;
	}

}
