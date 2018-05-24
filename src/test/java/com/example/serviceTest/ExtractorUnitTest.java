package com.example.serviceTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.domain.Choice;
import com.example.domain.Question;
import com.example.domain.Template;
import com.example.repository.ChoiceRepository;
import com.example.repository.QuestionRepository;
import com.example.repository.TemplateRepository;
import com.example.service.ExtractService;

public class ExtractorUnitTest {

	@Mock
	ChoiceRepository choiceRepository;
	@Mock
	TemplateRepository templateRepository;
	@Mock
	QuestionRepository questionRepository;
	@Mock
	List<Choice> cList;
	@Mock
	Template template;
	@Mock
	List<Question> qList;


	ExtractService extractService;

	@Before
	public void setupMock() throws Exception {
		MockitoAnnotations.initMocks(this);
		extractService = new ExtractService();
		extractService.setChoiceRepository(choiceRepository);
		extractService.setQuestionRepository(questionRepository);
		extractService.setTemplateRepository(templateRepository);

	}
	@Test
	public void testSearchByCId() {
		//Arrange
		when(extractService.searchByCId(1)).thenReturn(cList);
		//		Act
		List<Choice> result = extractService.searchByCId(1);
		//		Assert
		assertEquals(result.toString(),cList.toString());
	}

	@Test
	public void testSearchByQid() {
		//Arrange
		when(extractService.searchByQid(1)).thenReturn(qList);
		//		Act
		List<Question> result = extractService.searchByQid(1);
		//		Assert
		assertEquals(result.toString(),qList.toString());
	}

	@Test
	public void testSearchByTid() {
		//Arrange
		when(extractService.searchByTid(1)).thenReturn(template);
		//		Act
		Template result = extractService.searchByTid(1);
		//		Assert
		assertThat(result,equalTo(template));
	}

}
