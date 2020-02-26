package com.arasu.vacancy.questions.repository;

import com.arasu.vacancy.entity.Questions;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends org.springframework.data.repository.Repository<Questions, Integer> {
    
}
