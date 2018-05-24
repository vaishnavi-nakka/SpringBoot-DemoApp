package com.example.serviceTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.controller.Controller;
import com.example.domain.Choice;
import com.example.domain.Question;
import com.example.domain.SqlCode;
import com.example.domain.Template;
import com.example.service.ExtractService;
import com.example.service.MainService;

public class MainServiceUnitTest {

	@Mock
	ExtractService extractService;

	MainService mainService;

	

	SqlCode sqlCode1;


	@Before
	public void setupMock() throws Exception {
		MockitoAnnotations.initMocks(this);
		mainService = new MainService();
		mainService.setExtractService(extractService);
	}

	@Test
	public void test() {
		// Arrange
		Template template = new Template();
		template.setDescription("status template for inbound calls and nct");
		template.setTemplatename("status template");
		template.setLastupdatedate("1523013747");
		template.setCbus("0");


		List<Question> qList = new ArrayList<>();
		Question question = new Question();
		question.id = 1;
		question.setQuestion("note:fold down to next tour");
		question.setQuestionType("comment");
		question.setRequired("n");
		question.setHidden("y");
		question.setLastupdatedateAttuid("as759d");
		question.setTid(1);
		question.setQorder("2");
		question.setLastupdatedate("1523");
		question.setCreatedate("152396");
		question.setInclude_question("1");
		qList.add(question);

		Question question2 = new Question();
		question2.id = 2;
		question2.setQuestion("please update something");
		question2.setQuestionType("comment");
		question2.setRequired("n");
		question2.setHidden("y");
		question2.setLastupdatedateAttuid("gc8750");
		question2.setTid(1);
		question2.setQorder("2");
		question2.setLastupdatedate("152");
		question2.setCreatedate("17558");
		question2.setInclude_question("1");
		qList.add(question2);
		List<Choice> cList = new ArrayList<>();
		Choice choice = new Choice();
		choice.setQid(1);
		choice.setChoice("1st level");;
		choice.setDefaultvalue("n");
		choice.setChoicevalue("1st level");
		choice.setCorder("1");
		cList.add(choice);

		List<String> sql = new ArrayList<>();
		String query1="USE templates; INSERT INTO template (description,templatename,udTemplate,lastupdateAttuid,lastupdatedate,createdate,cbus,type_of_cbus,tas) VALUES ('status template for inbound calls and nct','status template','','','1523013747','','0','','')";
		String query2="INSERT INTO question (question,questionType,required,hidden,onchange,aotsfield,from_ticket,lastupdatedateAttuid,tid,qorder,lastupdatedate,createdate,include_question) VALUES ('note:fold down to next tour','comment','n','y','','','','as759d','1','2','1523','152396','1')";
		String query3="INSERT INTO choice (qid,choice,defaultvalue,choicevalue,corder,lastupdatedateATTuid,lastupdatedate,createdate) VALUES ('1','1st level','n','1st level','1','','','')";
		String query4="INSERT INTO question (question,questionType,required,hidden,onchange,aotsfield,from_ticket,lastupdatedateAttuid,tid,qorder,lastupdatedate,createdate,include_question) VALUES ('please update something','comment','n','y','','','','gc8750','1','2','152','17558','1')";
		sql.add(query1);
		sql.add(query2);
		sql.add(query3);
		sql.add(query4);
		Map<String,List<String>> resMap = new HashMap<>();
		resMap.put("sqlcode", sql);
		sqlCode1 = new SqlCode();
		sqlCode1.setData(resMap);

//		Act
		Mockito.when(extractService.searchByTid(1)).thenReturn(template);
		when(extractService.searchByQid(1)).thenReturn(qList);
		when(extractService.searchByCId(1)).thenReturn(cList);
		SqlCode result=mainService.generateSQLQuery(1);
		System.out.println("dbnasidi"+result.getData());
		Map<String,List<String>> actualMap= result.getData();
		List<String> actualList = actualMap.get("sqlcode");
		System.out.println("hello"+actualList);
		
		



//		Assert
		assertEquals(sql.toString(),actualList.toString());

	}

}