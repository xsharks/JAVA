package test;

public class Student extends Personal {

	private Course course;
	private String teacher;
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getTeather() {
		return teacher;
	}
	public void setTeacher(String teather) {
		extracted();
	}
	private String extracted() {
		return this.teacher = teacher;
	}
	public String toString(){
//		System.out.println("Student toString is operating");
		return id+name+sex+course+teacher;
	}

	public Student(int id, String name, String sex,Course course,Teacher teacher) {
		super(id, name, sex);
		this.course=course;
		this.teacher=teacher.name;
	}
	public Course delete() {
		return course=null;
	}
	public void putcourse(){
		if(course==null){
			System.out.println("ÄúÉĞÎ´Ñ¡¿Î");
		}else{
		this.toString();
		}
	}

}
