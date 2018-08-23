package scripts;

public class Student {
		
		String name;
		int PSno;
		String DOB;
		String city;
		
		static int num=10;
	
		
		
		public static int getNum() {
			return num;
		}
		public static void setNum(int num) {
			Student.num = num;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPSno() {
			return PSno;
		}
		public void setPSno(int pSno) {
			PSno = pSno;
		}
		public String getDOB() {
			return DOB;
		}
		public void setDOB(String dOB) {
			DOB = dOB;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		
		
		public Student(String name, int pSno, String dOB, String city) {
			super();
			this.name = name;
			PSno = pSno;
			DOB = dOB;
			this.city = city;
		}
		
		
		
		
		@Override
		public String toString() {
			return "Student [name=" + name + ", PSno=" + PSno + ", DOB=" + DOB
					+ ", city=" + city + "]";
		}
		public Student() {
			super();
		}

		
		
	
}
