
/**
 * @author Nishant Kumar
 * Illustrating STUDENT MANAGEMENT SYSTEM TO CREATE STUDENT, LAPTOP AND ADD TO DATABASE USING HIBERNATE 
 * AND PRINT DATA OF ONE OR ALL STUDENTS AND LAPTOPS, DELETE STUDENT USING DATA ACCESS OBJECT AND HQL 
 * ILLUSTRATING ONE TO MANY MAPPING OF ENTITY IN DATABASE USING HIBERNATE
 * ONE STUDENT -> MANY LAPTOP
 */

package oneToMany;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// ONE TO MANY MAPPING
// ONE STUDNET -> MANY LAPTOPS

public class studentDao {

	Configuration con;
	SessionFactory  sf;
	Session ses;
	Transaction tran ;
	
	public void connect() {												// METHOD 1
	con = new Configuration().configure().addAnnotatedClass(student.class).addAnnotatedClass(laptop.class);		// CONNECT METHOD TO BEGIN SESSION AND CONNECT WITH DATABASE
	sf = con.buildSessionFactory();
	ses = sf.openSession();										
	tran = ses.beginTransaction();
	}
	
	// METHOD 2
	// DISCONNECT METHOD TO END SESSION
	public void disconnect() {
		tran.commit();
		ses.close();
	}
	
	// METHOD 3
	// ADD STUDENT INTO DATABASE
	public Session registerStu(student s){
		ses.save(s);// SAVING STUDENT ENTITY
		return ses;
	}
	
	// METHOD 4
	// ADD STUENT INTO DATABASE
	public Session registerLap(laptop l) {
		ses.save(l);// SAVING LAPTOP ENTITY
		return ses;
	}
	
	// METHOD 5
	// TO DLETE STUDENT FORM DATABASE
	public int deleteStd(int id) {
		Query q = ses.createQuery("delete from student s where s.stId=: Id").setParameter("Id", id);
		int count = q.executeUpdate();// DELETING STUDENT FROM DATABASE
		return count;
	}
	
	// METHOD 6
	// TO FETCH A STUDENT DATA
	// FETCH STUDENT USING ID
	public student fetchStd(int id) {
		student s = (student) ses.load(student.class, id); // FETCHING STUDENT 
		return s;
	}
	
	// METHOD 7
	// TO FETCH A LAPTOP DATA
	// FETCH LAPTOP USING LAPTOP ID
	public laptop fetchLap(int id) {
		laptop l = (laptop) ses.load(laptop.class,id);// FETCHING LAPTOP
		return l;
	}
	
	// METHOD 8
	// TO FETCH ALL LAPTOP DATA
	public List fetchAllLap() {
		Query q =  ses.createQuery(" from laptop");
		List<laptop> l = q.getResultList(); // FETCHING LIST OF LAPTOP
		return l;
	}
	
	// METHOD 9
	// TO FETCH ALL STUDENT DATA
	public List fetchAll() {
		Query q =  ses.createQuery(" from student");
		List<student> s = q.getResultList(); // FETCHING LIST OF STUDENT
		return s;
	}
	
	
} 
