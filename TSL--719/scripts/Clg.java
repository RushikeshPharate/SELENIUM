package scripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Clg {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		
		System.out.println("Static Variable: " +Student.num);
		
		
		s1.setName("RUSHIKESH");
		s1.setPSno(10652441);
		s1.setDOB("23/11/1996");
		s1.setCity("PUNE");
		s1.setNum(5);

		/*System.out.println("Static Variable: " + s1.getNum());
		*/
		s2.setName("NEERAJ");
		s2.setPSno(10652442);
		s2.setDOB("23/11/1997");
		s2.setCity("PUNE");
		
		/*System.out.println("Static Variable: " + s2.getNum());
		*/
		s3.setName("TEJAL");
		s3.setPSno(10652443);
		s3.setDOB("23/11/1998");
		s3.setCity("PUNE");
		s3.setNum(2);
		
		/*System.out.println("Static Variable: " + s3.getNum());
		*/
		s4.setName("PURVI");
		s4.setPSno(10652444);
		s4.setDOB("23/11/1999");
		s4.setCity("MUMBAI");
		s4.setNum(1);
		
		/*System.out.println("Static Variable: " + s4.getNum());
		
		System.out.println( s1.getName() +"\t"  + s1.getPSno()+ "\t" +s1.getDOB()+ "\t" +s1.getCity()+ "\t" +s1.getNum());
		*/
		/*System.out.println( s1.getPSno());
		System.out.println( s1.getDOB());
		System.out.println( s1.getCity());*/
		
		/*
		System.out.println( s2.getName() +"\t"  + s2.getPSno()+ "\t" +s2.getDOB()+ "\t" +s2.getCity()+ "\t" +s2.getNum());
		System.out.println( s3.getName() +"\t"  + s3.getPSno()+ "\t" +s3.getDOB()+ "\t" +s3.getCity()+ "\t" +s3.getNum());
		System.out.println( s4.getName() +"\t"  + s4.getPSno()+ "\t" +s4.getDOB()+ "\t" +s4.getCity()+ "\t" +s4.getNum());
		*/
		
		/*
		List<Student> lst=new ArrayList<>();
		lst.add(s1);
		lst.add(s2);
		lst.add(s3);
		lst.add(s4);
		
		for(Student s: lst)
		{
		
			System.out.println(s);
		}
		*/
		
		HashMap<Integer, Student> hmap = new HashMap<Integer, Student>();

		hmap.put(new Integer (s1.getPSno()), s1);
		hmap.put(new Integer (s2.getPSno()), s2);
		hmap.put(new Integer (s3.getPSno()), s3);
		hmap.put(new Integer (s4.getPSno()), s4);
				
		System.out.println("Enter PSno : ");
		Scanner sc=new Scanner(System.in);
		int ps=sc.nextInt();
		
		Student value = hmap.get(ps);  
        System.out.println("Student info :" + value);  
		
	 
	}

}
