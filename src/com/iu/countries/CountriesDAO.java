package com.iu.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class CountriesDAO {
	
	public CountriesDTO getDetail(String country_id) throws Exception {
		CountriesDTO countriesDTO = null;
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, country_id);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			countriesDTO = new CountriesDTO();
			String cid = rs.getString("COUNTRY_ID");
			countriesDTO.setCountry_id(cid);
			String cname = rs.getString("COUNTRY_NAME");
			countriesDTO.setCountry_name(cname);
			int rid = rs.getInt("REGION_ID");
			countriesDTO.setRegion_id(rid);
			
			
		}
		
		DBConnector.disconnect(rs, st, con);
		
		return countriesDTO;
		
	}
	
	public ArrayList<CountriesDTO> getList() throws Exception {
		CountriesDTO countriesDTO = null;
		ArrayList<CountriesDTO> ar = new ArrayList();
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM COUNTRIES";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			countriesDTO = new CountriesDTO();
			String cid = rs.getString("COUNTRY_ID");
			countriesDTO.setCountry_id(cid);
			String cname = rs.getString("COUNTRY_NAME");
			countriesDTO.setCountry_name(cname);
			int rid = rs.getInt("REGION_ID");
			countriesDTO.setRegion_id(rid);
			ar.add(countriesDTO);
		}
		
		DBConnector.disconnect(rs, st, con);
		
		return ar;
		
	}

}
