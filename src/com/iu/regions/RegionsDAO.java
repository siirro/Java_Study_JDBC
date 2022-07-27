package com.iu.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class RegionsDAO {
	
	//2. Regions에서 하나의 결과(row)
	public RegionsDTO getDetail(int region_id) throws Exception {
		RegionsDTO regionsDTO = null;
		ArrayList<RegionsDTO> ar = new ArrayList<>();
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM REGIONS WHERE REGION_ID=?"; //값으로 들어가야 할 곳을 물음표로 처리 (보안때문)
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, region_id); //몇번째 물음표에 넣을것이니?, 오라클은 1부터 시작합니다. 자바, mysql은 0부터
		//WHERE NUM BETWEEN ?(1) AND ?(2);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			regionsDTO = new RegionsDTO();
			int rid = rs.getInt(1);
			regionsDTO.setRegion_id(rid);
			String rName = rs.getString(2);
			regionsDTO.setRegion_name(rName);
			
			
		}
		
		
		DBConnector.disconnect(rs, st, con);
		
		return regionsDTO;
		
	}
	
	//1. Regions 의 모든 데이터 가져오기
	public ArrayList<RegionsDTO> getList() throws Exception {
		RegionsDTO regionsDTO = null;
		ArrayList<RegionsDTO> ar = new ArrayList<>();
		//1.DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. Query 문 작성
		String sql = "SELECT * FROM REGIONS";
		
		//3. Query 문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?의 값을 세팅한다
		//st.setInt(몇번, 넣을것);
		
		//5. 최종 전송 후 결과를 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			regionsDTO = new RegionsDTO();
			int id = rs.getInt("Region_id");
			regionsDTO.setRegion_id(id);
			String name = rs.getString("Region_Name");
			regionsDTO.setRegion_name(name);
			ar.add(regionsDTO);
		}
		
		//6. 자원해제
		DBConnector.disconnect(rs, st, con);
		
		return ar;
	}
	
}
