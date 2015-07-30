package com.fenuk.example.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fenuk.example.model.Employee;
import com.fenuk.example.repository.EmployeeJdbcRepository;

public class App {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeJdbcRepository employeeRepository = (EmployeeJdbcRepository) context
				.getBean(EmployeeJdbcRepository.class);

		employeeRepository.save(new Employee("Alex", 35000L));
		Employee e = employeeRepository.getByName("Alex");

		System.out.println(e);
	}

}
