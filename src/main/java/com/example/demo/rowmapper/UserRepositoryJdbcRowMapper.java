package com.example.demo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.UserJdbc;

public class UserRepositoryJdbcRowMapper implements RowMapper<UserJdbc> {

	@Override
	public UserJdbc mapRow(ResultSet arg0, int arg1) throws SQLException {
		UserJdbc user = new UserJdbc();
		user.setUserId(arg0.getString("USER_ID"));
		user.setUserName(arg0.getString("USER_NM"));
		user.setDeptName(arg0.getString("DEPT_NM"));
		return user;
	}
}
