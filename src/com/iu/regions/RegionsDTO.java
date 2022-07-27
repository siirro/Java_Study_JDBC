package com.iu.regions;

public class RegionsDTO {
	//멤버변수 접근지정자 : private
	//Getter/Setter
	//기본생성자 필수
	//멤버변수명은 Table의 컬럼명과 동일하게 선언
	
	
	private Integer region_id; //이유는 오라클에 널이 있을수있기때문에. 인트는 널 못받음
	private String region_name;
	
	public Integer getRegion_id() {
		return region_id;
	}
	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	
}
