package mgt.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import jakarta.transaction.Transactional;
import mgt.model.Employee;
import mgt.util.HibernateUtil;

public class EmployeeServices {

	public static EmployeeServices employeeServices;
	protected static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	protected static Session session;

	public static EmployeeServices getInstance() {
		if (employeeServices == null) {
			employeeServices = new EmployeeServices();
		}
		return employeeServices;
	}

	private EmployeeServices() {
	}

	// Change the access modifier of addEmployee to public
	public void addEmployee(Employee employee) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
	}

	@Transactional
	public List<Employee> getAllEmployees() {
		session = sessionFactory.openSession();
		Query query = session.createQuery("from Employee"); // QUERY FROM JAKARTA
		List<Employee> employees = query.list();
		return employees;
	}
}
