package com.iu.regions;

import java.util.ArrayList;

public class RegionsView {
	
	public void view(RegionsDTO regionsDTO) throws Exception {
		System.out.println("Region_ID\tRegion_name");
		System.out.println("===========================");
		System.out.print(regionsDTO.getRegion_id()+"\t\t");
		System.out.println(regionsDTO.getRegion_name());
		System.out.println("===========================");
		
		
	}
	
	public void viewAll(ArrayList<RegionsDTO> ar) {
		for(int i=0;i<ar.size();i++) {
			System.out.println("Region_ID\tRegion_name");
			System.out.println("===========================");
			System.out.print(ar.get(i).getRegion_id()+"\t\t");
			System.out.println(ar.get(i).getRegion_name());
		}
	}
}
