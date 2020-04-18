package healthcare.payments.model;

//importing files
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import dto.PaymentDTO;
import utility.ConnectionBuilder;


public class PaymentModel {
	
	
	private final  ConnectionBuilder cBuilder = new ConnectionBuilder();

	

//Insert Into Payments	
public String InsertIntoPayments(PaymentDTO paymentDTO ) {


		Connection MYSQLcon = cBuilder.MYSQLConnection();
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("INSERT INTO payments(\n");
		sBuilder.append("doc_id,");
		sBuilder.append("hos_id,");
		sBuilder.append("amount,");
		sBuilder.append("doc_fee,");
		sBuilder.append("hos_fee,");
		sBuilder.append("reference_No)\n");
		sBuilder.append(" VALUES( \n");
		sBuilder.append("?,?,?,?,?,?\n");
		sBuilder.append(")");

		String queryString = sBuilder.toString();

		try {
			PreparedStatement pStatement = MYSQLcon.prepareStatement(queryString);
			pStatement.setInt(1, paymentDTO.getDoc_id());
			pStatement.setInt(2, paymentDTO.getHos_id());
			pStatement.setDouble(3, paymentDTO.getAmount());
			pStatement.setDouble(4, paymentDTO.getDoc_fee());
			pStatement.setDouble(5, paymentDTO.getHos_fee());
			pStatement.setInt(6, paymentDTO.getReference_No());
			

			System.out.println("calling Model");
			
			boolean result = pStatement.execute();
			
			if (!result) {
				return "dataADDEDSuccess";
			}
		
			
			MYSQLcon.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
			return e.toString();
		}
		
	return "connectionER";
}
	

	
	
//Read From Payments	
public List<PaymentDTO> getPaymentData() {
	 System.out.println("getPaymentData()");

		List<PaymentDTO> payDTOList = new ArrayList<PaymentDTO>();
		//Connection MYSQLcon = cBuilder.MYSQLConnection();
		
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("SELECT\n");
			sBuilder.append("*\t");
			sBuilder.append("FROM\n");
			sBuilder.append("payments\n");
		
			String queryString = sBuilder.toString();
	
		
		try {
			Statement stmt = MYSQLcon.createStatement();
			ResultSet rs = stmt.executeQuery(queryString);

			while (rs.next()) {
				PaymentDTO payDTO = new PaymentDTO();
				payDTO.setPayment_id(rs.getInt("payment_id"));
				payDTO.setDoc_id(rs.getInt("doc_id"));
				payDTO.setHos_id(rs.getInt("hos_id"));
				payDTO.setAmount(rs.getDouble("amount"));
				payDTO.setDoc_fee(rs.getDouble("doc_fee"));
				payDTO.setHos_fee(rs.getDouble("hos_fee"));
				payDTO.setReference_No(rs.getInt("reference_No"));
				payDTO.setDate_time(rs.getString("date_time"));
				payDTOList.add(payDTO);
			
			}
			MYSQLcon.close();
			return payDTOList;
			
		} catch (SQLException e) {
			System.out.println("calling");
			e.printStackTrace();
			return payDTOList;
		}
}



//Update Payment Details
public boolean UpdatePayment(PaymentDTO paymentDTO) {
		//update 
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("UPDATE payments \n");
		sBuilder.append( "SET \n");
		sBuilder.append("doc_id= ?,");
		sBuilder.append("hos_id=?,");
		sBuilder.append("amount=?,");
		sBuilder.append("doc_fee=?,");
		sBuilder.append("hos_fee=?,");
		sBuilder.append("reference_No=?,");
		sBuilder.append("date_time=?");
		sBuilder.append(" WHERE payment_id =?");
		

		String queryString = sBuilder.toString();

		PreparedStatement pStatement;
		try {
			pStatement = MYSQLcon.prepareStatement(queryString);
			pStatement.setInt(1, paymentDTO.getDoc_id());
			pStatement.setInt(2, paymentDTO.getHos_id());
			pStatement.setDouble(3, paymentDTO.getAmount());
			pStatement.setDouble(4, paymentDTO.getDoc_fee());
			pStatement.setDouble(5, paymentDTO.getHos_fee());
			pStatement.setInt(6, paymentDTO.getReference_No());
			pStatement.setString(7, paymentDTO.getDate_time());
			pStatement.setInt(8, paymentDTO.getPayment_id());
			
			boolean result = pStatement.execute();
			if (!result) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				MYSQLcon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}


//Delete From Payments
public boolean DeletePayment(int id) {
		//delete 
		Connection MYSQLcon = cBuilder.MYSQLConnection();
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("DELETE FROM payments WHERE payment_id= ? \n");
		

		String queryString = sBuilder.toString();

		PreparedStatement pStatement;
		try {
			pStatement = MYSQLcon.prepareStatement(queryString);
			pStatement.setInt(1, id);
			
			boolean result = pStatement.execute();
			if (!result) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				MYSQLcon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}





//Get hospital id of the payments
public String SelecthospitalName(String hos_id) {
		if (hos_id != null) {
			Connection MYSQLcon = cBuilder.MYSQLConnection();
			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("SELECT\n");
			sBuilder.append("hos_id\n");
			sBuilder.append("FROM\n");
			sBuilder.append("payments\n");
			sBuilder.append("WHERE payment_id = ?");
			String qurtString = sBuilder.toString();

			try {
				PreparedStatement pStatement = MYSQLcon.prepareStatement(qurtString);
				pStatement.setString(1, hos_id.trim());
				ResultSet rs = pStatement.executeQuery();
				while (rs.next()) {
					return rs.getString("hos_id");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					MYSQLcon.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}


//IT18073256
//Dilshan K.K.D.N.
