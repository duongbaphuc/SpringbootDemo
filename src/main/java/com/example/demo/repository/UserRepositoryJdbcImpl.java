package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserJdbc;
import com.example.demo.rowmapper.UserRepositoryJdbcRowMapper;

@Repository
public class UserRepositoryJdbcImpl implements UserRepositoryJdbc {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<UserJdbc> findAll() {
		String sql = "select a.USER_ID, a.USER_NM, b.DEPT_NM from MESUSER.TB_A10_USR_INF a, MESUSER.TB_A10_EMP_INF b where a.USER_ID =b.USER_ID";
		return jdbcTemplate.query(sql, new UserRepositoryJdbcRowMapper());
	}

	@Override
	public UserJdbc findByUsername(String userName) {
		return jdbcTemplate.queryForObject("select a.USER_ID, a.USER_NM, b.DEPT_NM from MESUSER.TB_A10_USR_INF a, MESUSER.TB_A10_EMP_INF b where a.USER_ID =b.USER_ID and a.USER_NM like'%?%'"
				,  new UserRepositoryJdbcRowMapper(),userName);
	}

	@Override
	public int update(UserJdbc userJdbc) {
		String sql = "update MESUSER.TB_A10_USR_INF set USER_NM=?, DEPT_NM =? where USER_ID=? ";
		return jdbcTemplate.update(sql, new Object[] {userJdbc.getUserName(), userJdbc.getDeptName(), userJdbc.getUserId()});
	}

	@Override
	public int insert(UserJdbc userJdbc) {
		String sql = "insert into MESUSER.TB_A10_USR_INF(USER_ID, USER_NM, DEPT_NM) values (?, ?, ?)";
		return jdbcTemplate.update(sql, new Object[] {userJdbc.getUserId(), userJdbc.getUserName(), userJdbc.getDeptName()});
	}

	@Override
	public int deletebyUserId(String userId) {
		String sql = "delete MESUSER.TB_A10_USR_INF where USER_ID =?";
		return jdbcTemplate.update(sql, new Object[] {userId});
	}

	@Override
	public int deleteAll() {
		String sql = "delete MESUSER.TB_A10_USR_INF";
		return jdbcTemplate.update(sql);
	}

	@Override
	public UserJdbc findByUserId(String userId) {
		return jdbcTemplate.queryForObject("select a.USER_ID, a.USER_NM, b.DEPT_NM from MESUSER.TB_A10_USR_INF a, MESUSER.TB_A10_EMP_INF b where a.USER_ID =b.USER_ID and a.USER_NM like'%?%'"
				,  new UserRepositoryJdbcRowMapper(),userId);
	}
}
