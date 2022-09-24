package lab.day;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class employeeDao {
	
	Configuration cf; 
	SessionFactory sf;
	Session se;
	Transaction ts;
	public void connect() {
		cf=new Configuration().configure().addAnnotatedClass(employee.class).addAnnotatedClass(experienceEmployee.class).addAnnotatedClass(fresherEmployee.class);
		sf=cf.buildSessionFactory();
		se=sf.openSession();
		ts=se.beginTransaction();
	}
	
	public void addEmployee(employee e) {
		se.save(e);
		ts.commit();
		se.close();
	}
	
    public void addEmployee(fresherEmployee f) {
    	se.save(f);
		ts.commit();
		se.close();
	}
	
    public void addEmployee(experienceEmployee g) {
    	se.save(g);
		ts.commit();
		se.close();
	}

	public employee getEmployee(int empId) {
		employee ep = (employee)se.load(employee.class, empId);
    	ts.commit();
    	return ep;
	}
	
	public int removeEmployee(int empId) {
    	Query qe = se.createQuery("delete from employee e where e.empId=: Id").setParameter("Id", empId);
    	int temp= qe.executeUpdate();
		return temp;
	}
}