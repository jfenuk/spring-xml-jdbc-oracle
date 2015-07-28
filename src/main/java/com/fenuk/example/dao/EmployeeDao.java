package com.fenuk.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.fenuk.example.model.Employee;

public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveEmployee(Employee e) {
		String query = "insert into employee (id, name, salary) values('" + e.getId() + "','" + e.getName() + "','"
				+ e.getSalary() + "')";
		return jdbcTemplate.update(query);
	}

	public int updateEmployee(Employee e) {

		String query = "update employee set name='" + e.getName() + "',salary='" + e.getSalary() + "' where id='"
				+ e.getId() + "'";
		return jdbcTemplate.update(query);
	}

	public int deleteEmployee(Employee e) {

		String query = "delete from employee where id='" + e.getId() + "'";
		return jdbcTemplate.update(query);
	}

	public Employee getEmployeeById(int id) {

		Employee e = this.jdbcTemplate.queryForObject("select id, name, salary from employee where id = ?",
				new Object[] { id }, new RowMapper<Employee>() {
					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee e = new Employee();
						e.setId(rs.getInt("id"));
						e.setName(rs.getString("name"));
						e.setSalary(rs.getFloat("salary"));

						return e;

					}
				});
		return e;
	}
	
	public Employee getEmployeeByName(String name) {

		Employee e = this.jdbcTemplate.queryForObject("select id, name, salary from employee where name = ?",
				new Object[] { name }, new RowMapper<Employee>() {
					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee e = new Employee();
						e.setId(rs.getInt("id"));
						e.setName(rs.getString("name"));
						e.setSalary(rs.getFloat("salary"));

						return e;

					}
				});
		return e;
	}
}
