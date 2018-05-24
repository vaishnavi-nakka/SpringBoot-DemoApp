package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer>{

	public List<Question> findByTid(int tid);
}
