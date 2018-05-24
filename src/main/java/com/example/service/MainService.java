package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Choice;
import com.example.domain.Question;
import com.example.domain.SqlCode;
import com.example.domain.Template;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MainService {

	
	ExtractService extractService;
	@Autowired
	public void setExtractService(ExtractService extractService) {
		this.extractService = extractService;
	}
	
	

	public SqlCode generateSQLQuery(int id){
		List<String> queries = new ArrayList<>();
		Template template = extractService.searchByTid(id);
		// template query
		Map<String,Object> tMap = mapConverter(template);
		String templateQuery = "USE templates; INSERT INTO template (";
		System.out.println("1"+templateQuery);
		templateQuery = insertKeyValue(templateQuery, tMap);
		System.out.println("2"+templateQuery);
		queries.add(templateQuery);

		// questions query

		List<Question> questions = extractService.searchByQid(id);
		for(Question question : questions) {
			Map<String,Object> qMap = mapConverter(question);
			String questionQuery = "INSERT INTO question (";
			questionQuery = insertKeyValue(questionQuery, qMap);
			System.out.println("3"+questionQuery);
			queries.add(questionQuery);

			List<Choice> choices = extractService.searchByCId(question.id);
			System.out.println("7"+choices.size());
			System.out.println("6"+question.id);
			for(Choice choice : choices) {
				Map<String,Object> cMap = mapConverter(choice);
				String choiceQuery = "INSERT INTO choice (";
				choiceQuery = insertKeyValue(choiceQuery, cMap);
				System.out.println("4"+choiceQuery);
				queries.add(choiceQuery);
			}

		}
		Map<String,List<String>> resMap = new HashMap<>();
		resMap.put("sqlcode", queries);
		SqlCode sqlCode = new SqlCode(); 
		sqlCode.setData(resMap);
		System.out.println("5"+sqlCode.getData());
		return sqlCode;

	}

	

	

	public Map<String,Object> mapConverter(Object object){
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = objectMapper.convertValue(object, Map.class);
		System.out.println(map.keySet());
		return map;
	}

	public String insertKeyValue(String query, Map<String, Object> map) {
		for(String key : map.keySet()) {
			if(!key.equals("id"))
				query += key + ",";
		}
		query = query.substring(0,query.length()-1);
		query += ") VALUES (";
		for(String key : map.keySet()) {
			if(!key.equals("id")) {
				if(map.get(key)!=null)
					query += "'"+map.get(key)+"'" + ",";
				else
					query += "''"+ ",";
			}
		}
		query = query.substring(0,query.length()-1);
		query += ")";
		return query;
	}


}
