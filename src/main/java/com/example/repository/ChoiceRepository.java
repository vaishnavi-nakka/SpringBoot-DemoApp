package com.example.repository;

import java.util.List;

import org.json.JSONObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Choice;

@Repository
public interface ChoiceRepository extends CrudRepository<Choice, Integer> {
	
	public List<Choice> findByQid(int qid);

}
