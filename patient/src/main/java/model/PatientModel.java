package model;

import java.sql.Connection;

import utility.ConnectionBuilder;

public class PatientModel {
	private final ConnectionBuilder cBuilder = new ConnectionBuilder();

	public boolean connectionChecker(Connection MYSQLcon) {

		if (MYSQLcon == null) {
			return false;
		}
		return true;
	}
	
	
}
