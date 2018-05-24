package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Template;

@Repository
public interface TemplateRepository extends CrudRepository<Template, Integer>{

	public Template findById(int id);
}
