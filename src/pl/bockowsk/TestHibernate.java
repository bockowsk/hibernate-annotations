package pl.bockowsk;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class TestHibernate {

	public static void main(String[] args) {
		// stworzenie factory
		SessionFactory factory = new Configuration().configure("./hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		ArrayList<Student> students=new ArrayList<Student>();
		Student student1=new Student("Olimp","Bockowski", "bockowsk@student.agh.edu.pl");
		Student student2=new Student("Jan","Jankowski", "jjankows@student.agh.edu.pl");
		students.add(student1);students.add(student2);
		for (Student s: students) {
			try {
				// stworzenie sesji
				Session session = factory.getCurrentSession();
				session.beginTransaction();
				session.save(s);
				session.getTransaction().commit();
			} catch (Exception ex) {
				ex.printStackTrace();
			} 
		}
		factory.close();
	}

}
