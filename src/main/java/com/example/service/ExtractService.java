package com.example.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Choice;
import com.example.domain.Question;
import com.example.domain.Template;
import com.example.repository.ChoiceRepository;
import com.example.repository.QuestionRepository;
import com.example.repository.TemplateRepository;

@Service
public class ExtractService {
	
	
	ChoiceRepository choiceRepository;
	@Autowired
	public void setChoiceRepository(ChoiceRepository choiceRepository) {
		this.choiceRepository = choiceRepository;
	}

	
	public List<Choice> searchByCId(int qid) {
		return choiceRepository.findByQid(qid);
	}
	
	
	TemplateRepository templateRepository;
	@Autowired
	public void setTemplateRepository(TemplateRepository templateRepository) {
		this.templateRepository = templateRepository;
	}

	public Template searchByTid(int id) {
		return templateRepository.findById(id);
	}
	

	QuestionRepository questionRepository;
	@Autowired
	public void setQuestionRepository(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	public List<Question> searchByQid(int tid){
		return questionRepository.findByTid(tid);
	}
	

}
