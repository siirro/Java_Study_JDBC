package com.iu.employees;

import java.util.ArrayList;

public class EmployeesView {
	
	public void view(ArrayList<EmployeesDTO> ar) {
		System.out.println("너무많음");
		System.out.println("=====================");
		
		for(EmployeesDTO dto : ar) {
			System.out.print(dto.getEmployee_id()+"\t");
			System.out.print(dto.getFirst_name()+"\t");
			System.out.print(dto.getLast_name()+"\t");
			System.out.print(dto.getEmail()+"\t");
			System.out.print(dto.getPhone_number()+"\t");
			System.out.print(dto.getHire_date()+"\t");
			System.out.print(dto.getJob_id()+"\t");
			System.out.print(dto.getSalary()+"\t");
			System.out.print(dto.getCommission_pct()+"\t");
			System.out.print(dto.getManager_id()+"\t");
			System.out.println(dto.getDepartment_id()+"\t");
		}
		
	}
	
	public void view(EmployeesDTO dto) {
	
		System.out.println("너무많음");
		System.out.println("=====================");
		System.out.print(dto.getEmployee_id()+"\t");
		System.out.print(dto.getFirst_name()+"\t");
		System.out.print(dto.getLast_name()+"\t");
		System.out.print(dto.getEmail()+"\t");
		System.out.print(dto.getPhone_number()+"\t");
		System.out.print(dto.getHire_date()+"\t");
		System.out.print(dto.getJob_id()+"\t");
		System.out.print(dto.getSalary()+"\t");
		System.out.print(dto.getCommission_pct()+"\t");
		System.out.print(dto.getManager_id()+"\t");
		System.out.println(dto.getDepartment_id()+"\t");
		
		
	}

}
