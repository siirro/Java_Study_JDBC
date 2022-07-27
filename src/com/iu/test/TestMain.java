package com.iu.test;

import java.util.ArrayList;

import com.iu.countries.CountriesDAO;
import com.iu.countries.CountriesDTO;
import com.iu.countries.CountriesView;
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
		try {
			//ArrayList<RegionsDTO> ar = regionsDAO.getList();
			//rv.viewAll(ar);
			
			ArrayList<CountriesDTO> aa = countriesDAO.getList();
			cv.viewAll(aa);
			
			//컨트리리테일 겟리스트, 뷰
			//CountriesDTO cto = countriesDAO.getDetail("AU");
			//cv.view(cto);
			
			//리턴디테일 실행,보기
//			RegionsDTO dto = regionsDAO.getDetail(2);
//			rv.view(dto);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}





