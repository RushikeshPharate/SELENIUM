import java.util.HashMap;
import java.util.Scanner;


public class LTIUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		System.out.println("Hello World");
		
		Student stu;
		int psNo;
		String name;
		float salary;
		
		
		HashMap <Integer,Student> hmap=new HashMap<Integer,Student>();
		
		for(int i=0;i<5;i++){
			System.out.println("Enter details :- ");
			System.out.println("Enter psNo :- ");
			psNo=sc.nextInt();
			System.out.println("Enter name :- ");
			name=sc.next();
			System.out.println("Enter salary :- ");
			salary=sc.nextFloat();
			
			stu=new Student(psNo,name,salary);
			
			hmap.put(psNo, stu);
			
		}
		
		System.out.println("Enter psno to search :- ");
		System.out.println(hmap.get(sc.nextInt()));
		
		
		
		
		sc.close();
	
	}

}
