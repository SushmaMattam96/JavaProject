package com.cg.ems.dao;

public interface QueryMapper {
	public static final String insertQuery=
			"insert into jee_jdbcdemo values(jee_jdbc_sequence.nextval,?,?)";
	public static final String updateQuery=
			"update jee_jdbcdemo set salary=? where id=?";
	public static final String selectAllEmployeesQuery="select *from jee_jdbcdemo"; 
	public static final String selectNameEmployeeQuery="select id,name from jee_jdbcdemo where salary>?";
	public static final String newSelectQuery = "select * from jee_jdbcdemo where id=?";
}
