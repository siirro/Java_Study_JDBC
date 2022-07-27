package com.iu.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class EmployeesDAO {
	
	public ArrayList<EmployeesDTO> getList() throws Exception {
		EmployeesDTO ed = null;
		ArrayList<EmployeesDTO> ar = new ArrayList();
		
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM EMPLOYEES";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ed = new EmployeesDTO();
			ed.setEmployee_id(rs.getInt("employee_id"));
			ed.setFirst_name(rs.getString("first_name"));
			ed.setLast_name(rs.getString("last_name"));
			ed.setEmail(rs.getString("email"));
			ed.setPhone_number(rs.getString("phone_number"));
			ed.setHire_date(rs.getDate("hire_date"));
			ed.setJob_id(rs.getString("job_id"));
			ed.setSalary(rs.getInt("salary"));
			ed.setCommission_pct(rs.getDouble("commission_pct"));
			ed.setManager_id(rs.getInt("manager_id"));
			ed.setDepartment_id(rs.getInt("department_id"));
			
			ar.add(ed);
			
			}
		
		DBConnector.disconnect(rs, st, con);
		
		return ar;
	}
	
	public EmployeesDTO getDetail(int employee_id) throws Exception {
		EmployeesDTO ed = null;
		
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM EMPLOYEES WHERE employee_id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, employee_id);
		ResultSet rs = st.executeQuery();
		
		
		while(rs.next()) {
			ed = new EmployeesDTO();
			ed.setEmployee_id(rs.getInt("employee_id"));
			ed.setFirst_name(rs.getString("first_name"));
			ed.setLast_name(rs.getString("last_name"));
			ed.setEmail(rs.getString("email"));
			ed.setPhone_number(rs.getString("phone_number"));
			ed.setHire_date(rs.getDate("hire_date"));
			ed.setJob_id(rs.getString("job_id"));
			ed.setSalary(rs.getInt("salary"));
			ed.setCommission_pct(rs.getDouble("commission_pct"));
			ed.setManager_id(rs.getInt("manager_id"));
			ed.setDepartment_id(rs.getInt("department_id"));
		}
		
		DBConnector.disconnect(rs, st, con);
		
		return ed;
	}
}
