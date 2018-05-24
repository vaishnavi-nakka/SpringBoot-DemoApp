package com.example.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Choice;
import com.example.domain.SqlCode;
import com.example.service.ExtractService;
import com.example.service.MainService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class Controller {

	
	MainService mainService;
	
	
	@Autowired
	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}



	@GetMapping("/{id}")
	public 	ResponseEntity<SqlCode> getQueries(@PathVariable int id){
		SqlCode sqlCode = mainService.generateSQLQuery(id);
	    JSONObject jObj = new JSONObject();
	    try {
			jObj.put("data", sqlCode);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("Something went wrong");
		}
	    String result = jObj.toString();
		return new ResponseEntity<SqlCode>(sqlCode, HttpStatus.CREATED);
	}



}
