package NAL_JavaQuestions;

public class _39_StudentPO {

	private String Name;
	private int Rollno;
	private int Age;
	private int Marks;
	
	public _39_StudentPO(String name, int rollno, int age, int marks) {
		Name = name;
		Rollno = rollno;
		Age = age;
		Marks = marks;
	}

	public String getName() {
		return Name;
	}

	public int getRollno() {
		return Rollno;
	}


	public int getAge() {
		return Age;
	}



	public int getMarks() {
		return Marks;
	}

	@Override
	public String toString() {
		return "_39_StudentPO [Name=" + Name + ", Rollno=" + Rollno + ", Age=" + Age + ", Marks=" + Marks + "]";
	}
	
}
