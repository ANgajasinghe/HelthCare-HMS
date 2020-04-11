package model;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import auth.AuthToken;
import dto.UserDTO;
import utility.LMessage;

public class LoginModel {

	Logger logger = Logger.getLogger("MyLog");
	FileHandler fh;

	private final ConnectionBuilder cBuilder = new ConnectionBuilder();
	private final Connection MYSQLcon = cBuilder.MYSQLConnection();

	public LoginModel() {
		super();
		try {
			fh = new FileHandler("C:/PAF/log/MyLogFile.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean connectionChecker() {

		if (MYSQLcon == null) {
			return false;
		}
		return true;
	}

	public String checkUser(String username, String user_password) {

		UserDTO userDTO = this.getUserBYPassword(username, user_password);

		if (userDTO != null) {

			return this.InsertIntoLogin(userDTO.getUser_id(), userDTO.getUsername(), userDTO.getUser_password(),
					userDTO.getUser_role());

		} else {
			return LMessage.wrongUser;
		}

	}

	private UserDTO getUserBYPassword(String username, String user_password) {

		UserDTO userDTO = new UserDTO();

		if (connectionChecker()) {

			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("SELECT\n");
			sBuilder.append("user_id,");
			sBuilder.append("username,");
			sBuilder.append("user_email,");
			sBuilder.append("user_password,");
			sBuilder.append("user_role\n");
			sBuilder.append("FROM\n");
			sBuilder.append("userprofile\n");
			sBuilder.append("WHERE\n");
			sBuilder.append("(username = ? OR user_email = ?)\n");
			sBuilder.append("AND\n");
			sBuilder.append("(user_password = ?)\n");

			String queryString = sBuilder.toString();

			try {
				PreparedStatement pStatement = this.MYSQLcon.prepareStatement(queryString);
				pStatement.setString(1, username);
				pStatement.setString(2, username);
				pStatement.setString(3, user_password);

				ResultSet rs = pStatement.executeQuery();

				while (rs.next()) {
					userDTO.setUser_id(rs.getInt("user_id"));
					userDTO.setUsername(rs.getString("username"));
					userDTO.setUser_email(rs.getString("user_email"));
					userDTO.setUser_password("user_password");
					userDTO.setUser_role(rs.getString("user_role"));
					break;
				}

				return userDTO;
			} catch (SQLException e) {
				System.out.println("calling");
				e.printStackTrace();
				return userDTO;
			}

		}
		System.out.println("calling 03 ");
		return userDTO;
	}

	private String InsertIntoLogin(int userId, String userName, String password, String role) {

		String token = AuthToken.getToken(userName, password, role);

		InetAddress hostname = null;
		String ipAddress = null;

		try {
			hostname = InetAddress.getLocalHost();
			ipAddress = hostname.getHostAddress();
		} catch (UnknownHostException e1) {

			e1.printStackTrace();
		}

		if (connectionChecker()) {
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("INSERT INTO \n");
			sBuilder.append("login (user_id,Token,log_count,ipAddress,hostname) VALUES( \n");
			sBuilder.append("?,?,?,?,? )");

			String queryString = sBuilder.toString();

			try {
				PreparedStatement pStatement = this.MYSQLcon.prepareStatement(queryString);
				pStatement.setInt(1, userId);
				pStatement.setString(2, token);
				pStatement.setInt(3, 1);
				pStatement.setString(4, ipAddress);
				pStatement.setString(5, hostname.toString());

				pStatement.execute();
				logger.info(token);
				return token;

			} catch (SQLException e) {
				logger.info(e.toString());
				e.printStackTrace();
			}

		}
		logger.info(LMessage.sqlInsertErr);
		return LMessage.sqlInsertErr;

	}

	public String CheckLogin(String tokenString) {

		if (connectionChecker()) {
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("SELECT u.user_role \n");
			sBuilder.append("FROM login l \n");
			sBuilder.append("INNER JOIN userprofile u \n");
			sBuilder.append("ON l.user_id = u.user_id \n");
			sBuilder.append("WHERE l.Token = ? \n");
			sBuilder.append("AND 1=1");

			String queryString = sBuilder.toString();

			try {
				PreparedStatement pStatement = this.MYSQLcon.prepareStatement(queryString);
				pStatement.setString(1, tokenString);
				
				ResultSet rs = pStatement.executeQuery();
				
				while (rs.next()) {
					
					return rs.getString("user_role");
				}
				
			} catch (SQLException e) {
				logger.info(e.toString());
				e.printStackTrace();
			}

		}
		return "false";

	}

}
