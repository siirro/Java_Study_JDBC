package com.iu.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class EmployeesDAO {
	
	public void getJoinTest(EmployeesDTO employeesdto)throws Exception {
		//디비연결 쿼리문생성 미리전송 물음표세팅 최종전송 결과처리 자원해제
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT E.LAST_NAME, E.SALARY, D.DEPARTMENT_NAME "
				+ "FROM EMPLOYEES E "
				+ "        INNER JOIN "
				+ "        DEPARTMENTS D "
				+ "        ON E.DEPARTMENT_ID = D.DEPARTMENT_ID "
				+ "WHERE E.EMPLOYEE_ID=?;";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, employeesdto.getEmployee_id());
		
		
		
		
		
		ResultSet rs = st.executeQuery();
		//인서트 업데이트 딜리트는 결과를 성공1 실패0 으로 받고 나머지는 아님
		
		if(rs.next()) {
			employeesdto = new EmployeesDTO();
			employeesdto.setLast_name(rs.getString(1));
			employeesdto.setSalary(rs.getInt(2));
			
			//DepartmentsDTO dt = new DepartmentsDTO();
			//dt.setDepartment_name(rs.getString(3));
			
		}
		
		DBConnector.disconnect(rs, st, con);
		
		
	}
	
	
	public void getSalaryInfo() throws Exception{
		
		//디비연결, 쿼리문작성, 미리전송, 물음표설정, 최종전송, 결과처리, 자원해제
		Connection con = DBConnector.getConnection();
		String sql = "SELECT SUM(SALARY), AVG(SALARY), MAX(SALARY) AS MAX FROM EMPLOYEES"; //쿼리문 안에 세미콜론찍지않는다. 알아서찍어준다.
		PreparedStatement st = con.prepareStatement(sql);
		
		//최종전송
		ResultSet rs = st.executeQuery();
		//ArrayList<Object> 
		//결과처리
		if(rs.next()) {
			
			int sum = rs.getInt("SUM(SALARY)");
			double avg = rs.getDouble(2);
			int max = rs.getInt("MAX");
			System.out.println(sum);
			System.out.println(avg);
			System.out.println(max);
		}
		
		
		DBConnector.disconnect(rs, st, con);
	}
	
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
