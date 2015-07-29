package com.fenuk.example.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fenuk.example.dao.EmployeeDao;
import com.fenuk.example.model.Employee;

public class App {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeDao dao = (EmployeeDao) context.getBean(EmployeeDao.class);
		
		dao.saveEmployee(new Employee("Alex", 35000L));
		Employee e = dao.getEmployeeByName("Alex");

		System.out.println(e);
	}

}
