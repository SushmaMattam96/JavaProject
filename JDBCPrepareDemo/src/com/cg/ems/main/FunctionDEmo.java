package com.cg.ems.main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.cg.ems.exception.EMSException;
import com.cg.ems.utility.JDBCUtility;

public class FunctionDEmo {

	public static void main(String[] args) {

		CallableStatement callablestatement = null;
		Connection connection = null;
		try {

			try {
				connection = JDBCUtility.getConnection();
				connection.setAutoCommit(false);

				String query = "{? = call book_name_function(?)}";

				callablestatement = connection.prepareCall(query);
				callablestatement.setInt(2, 1020);
				callablestatement.registerOutParameter(1, Types.VARCHAR);

				int result = callablestatement.executeUpdate();

				System.out.println(callablestatement.getString(1));

				System.out.println(result + "   selected");
				connection.commit();

			} catch (EMSException e) {
				System.err.println(e.getMessage());
			}
		} catch (SQLException e) {

		}

	}

}
