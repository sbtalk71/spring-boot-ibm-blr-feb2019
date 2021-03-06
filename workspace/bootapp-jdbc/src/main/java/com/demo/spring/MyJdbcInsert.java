package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;

//@Component
public class MyJdbcInsert implements CommandLineRunner {

	@Autowired
	JdbcTemplate jt;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		String insert_sql="insert into emp(empno,name,address,salary) values(?,?,?,?)";
		
		int update=jt.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(insert_sql);
				pst.setInt(1, 201);
				pst.setString(2, "Raju");
				pst.setString(3, "Hyderabad");
				pst.setDouble(4, 90000);
				return pst;
			}
			
		});

		System.out.println("Rows Updated: "+update);
	}

}
