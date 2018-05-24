package com.example.controllerTest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.controller.Controller;
import com.example.domain.SqlCode;
import com.example.service.MainService;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(Controller.class)
public class ControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MainService mainService;



	Controller controller;

	SqlCode sqlCode;



	@Before
	public void setupMock() throws Exception {
		MockitoAnnotations.initMocks(this);
		controller = new Controller();
		controller.setMainService(mainService);
	}

	@Test
	public void test() {
		// Arrange

		List<String> sql = new ArrayList<>();

		String query1="USE templates; INSERT INTO template (description,templatename,udTemplate,lastupdateAttuid,lastupdatedate,createdate,cbus,type_of_cbus,tas) VALUES ('status template for inbound calls and nct','status template','','','1523013747','','0','','')";
		String query2="INSERT INTO question (id,question,questionType,required,hidden,onchange,aotsfield,from_ticket,lastupdatedateAttuid,tid,qorder,lastupdatedate,createdate,include_question) VALUES ('1','note:fold down to next tour','comment','n','y','','','','as759d','1','2','1523','152396','1')";
		String query3="INSERT INTO choice (qid,choice,defaultvalue,choicevalue,corder,lastupdatedateATTuid,lastupdatedate,createdate) VALUES ('1','1st level','n','1st level','1','','','')";
		String query4="INSERT INTO question (id,question,questionType,required,hidden,onchange,aotsfield,from_ticket,lastupdatedateAttuid,tid,qorder,lastupdatedate,createdate,include_question) VALUES ('2','please update something','comment','n','y','','','','gc8750','1','2','152','17558','1')";
		sql.add(query1);
		sql.add(query2);
		sql.add(query3);
		sql.add(query4);
		Map<String,List<String>> resMap = new HashMap<>();
		resMap.put("sqlcode", sql);
		sqlCode = new SqlCode();
		sqlCode.setData(resMap);

		//Act
		when(mainService.generateSQLQuery(1)).thenReturn(sqlCode);


		//Assert
		System.out.println(jsonPath("$.data.sqlcode"));
		try {
			mockMvc.perform(get("/api/v1/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
			.andExpect(jsonPath("$.data.sqlcode", is(sql)));

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}		


	}



}