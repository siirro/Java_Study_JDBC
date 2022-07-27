package com.iu.countries;

import java.util.ArrayList;

import com.iu.regions.RegionsDTO;

public class CountriesView {
	
	public void view(CountriesDTO countriesDTO) throws Exception {
		System.out.println("Countries_ID\tCountries_name\tRegion_ID");
		System.out.println("===========================");
		System.out.print(countriesDTO.getCountry_id()+"\t\t");
		System.out.print(countriesDTO.getCountry_name()+"\t\t");
		System.out.println(countriesDTO.getRegion_id());
		System.out.println("===========================");
		
		
	}
	
	public void viewAll(ArrayList<CountriesDTO> ar) {
		System.out.println("Countries_ID\tCountries_name\t\tRegion_ID");
		System.out.println("===========================");
		for(int i=0;i<ar.size();i++) {
			
			
			System.out.print(ar.get(i).getCountry_id()+"\t\t");
			System.out.print(ar.get(i).getCountry_name()+"\t\t");
			System.out.println(ar.get(i).getRegion_id());
			//System.out.println("===========================");
		}
	}

}
