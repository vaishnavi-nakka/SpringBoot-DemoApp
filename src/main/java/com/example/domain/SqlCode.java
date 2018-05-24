package com.example.domain;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class SqlCode {
	
	private Map<String,List<String>> data;

	public Map<String, List<String>> getData() {
		return data;
	}

	public void setData(Map<String, List<String>> data) {
		this.data = data;
	}

	
	

}
