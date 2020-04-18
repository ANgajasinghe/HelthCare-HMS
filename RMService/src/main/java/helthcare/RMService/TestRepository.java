package helthcare.RMService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utility.connectionBuilder;



public class TestRepository {
	Connection con = null;
	
	List<Test> tests;
	
	public TestRepository() {

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/healthcare", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		
	}
	
	public List<Test> getTests(){
		
		List<Test> tests = new ArrayList<>();
		String sql = "Select * from testsnrooms";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Test t = new Test();
				t.setTest_id(rs.getInt(1));
				t.setTest_name(rs.getString(2));
				t.setTest_cost(rs.getString(3));
				t.setTest_desc(rs.getString(4));
				t.setRoom_no(rs.getString(5));
				t.setHospital_name(rs.getString(6));
				
				tests.add(t);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return tests;
	}
	
	public Test getTest(int test_id) {
		
		String sql = "Select * from testsnrooms where id ="+test_id;
		Test t = new Test();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				t.setTest_id(rs.getInt(1));
				t.setTest_name(rs.getString(2));
				t.setTest_cost(rs.getString(3));
				t.setTest_desc(rs.getString(4));
				t.setRoom_no(rs.getString(5));
				t.setHospital_name(rs.getString(6));
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return t;
	}

	public void insertTest(Test t1) {
		String sql = "Insert into testsnrooms (test_name,test_cost,test_desc,room_no,hospital_name) values (?,?,?,?,?) ";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,t1.getTest_name());
			st.setString(2,t1.getTest_cost());
			st.setString(3,t1.getTest_desc());
			st.setString(4,t1.getRoom_no());
			st.setString(5,t1.getHospital_name());
				
			st.execute();
				
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void updateTest(Test t1) {
		String sql = "update testsnrooms set test_name=?,test_cost=?,test_desc=?,room_no=?,hospital_name=? where test_id=? ";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,t1.getTest_name());
			st.setString(2,t1.getTest_cost());
			st.setString(3,t1.getTest_desc());
			st.setString(4,t1.getRoom_no());
			st.setString(5,t1.getHospital_name());
			st.setInt(6,t1.getTest_id());
				
			st.executeUpdate();
				
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void deleteTest(int test_id) {
		String sql = "delete from testsnrooms where test_id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,test_id);
			
			st.execute();
				
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
