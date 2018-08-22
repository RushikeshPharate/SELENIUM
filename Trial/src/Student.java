
public class Student {

	
	
	static final String company ="LTI";
	
	int psNo;
	String name;
	float salary;
	
	
	public Student(int psNo, String name, float salary) {
		super();
		this.psNo = psNo;
		this.name = name;
		this.salary = salary;
	}
	public int getPsNo() {
		return psNo;
	}
	public void setPsNo(int psNo) {
		this.psNo = psNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Student [psNo=" + psNo + ", name=" + name + ", salary="
				+ salary + "Company=" +company+ "]";
	}
	
	
}
