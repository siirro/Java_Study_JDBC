package com.iu.test;

import java.util.ArrayList;

import com.iu.countries.CountriesDAO;
import com.iu.countries.CountriesDTO;
import com.iu.countries.CountriesView;
import com.iu.employees.EmployeesDAO;
import com.iu.employees.EmployeesDTO;
import com.iu.employees.EmployeesView;
import com.iu.regions.RegionsDAO;
import com.iu.regions.RegionsDTO;
import com.iu.regions.RegionsView;
import com.iu.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {
		RegionsDAO regionsDAO = new RegionsDAO();
		CountriesDAO countriesDAO = new CountriesDAO();
		RegionsView rv = new RegionsView();
		CountriesView cv = new CountriesView();
		EmployeesDAO ed = new EmployeesDAO();
		EmployeesView ev = new EmployeesView();
		
		try {
			ArrayList<RegionsDTO> ar = regionsDAO.getList();
			rv.viewAll(ar);
			
			//ArrayList<CountriesDTO> aa = countriesDAO.getList();
			//cv.viewAll(aa);
			
			//컨트리리테일 겟리스트, 뷰
			//CountriesDTO cto = countriesDAO.getDetail("AU");
			//cv.view(cto);
			
			//리턴디테일 실행,보기
//			RegionsDTO dto = regionsDAO.getDetail(2);
//			rv.view(dto);
			
			//ArrayList<EmployeesDTO> aaa = ed.getList();
			//ev.view(aaa);
			
			//EmployeesDTO eee = ed.getDetail(102);
			//ev.view(eee);
			
			//ed.getSalaryInfo();
			
			//디비에 인서트 하는거 실행하기
			RegionsDTO regionsDTO = new RegionsDTO();
			regionsDTO.setRegion_id(6);
			regionsDTO.setRegion_name("Mars");
			int result = regionsDAO.setRegion(regionsDTO);
			
			if(result > 0 ) {
					System.out.println("성공");
			}else {
				System.out.println("실패");
			}
			
			
			//컨트리에 인서트하기
			/*CountriesDTO cdto = new CountriesDTO();
			cdto.setCountry_id("PR");
			cdto.setCountry_name("푸랑이");
			cdto.setRegion_id(4);
			int result2 = countriesDAO.setCountry(cdto);
			
			if(result2 > 0) {
				System.out.println("컨트리인서트 성공");
			} else {
				System.out.println("컨트리인서트 실패");
			}
			*/
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}





