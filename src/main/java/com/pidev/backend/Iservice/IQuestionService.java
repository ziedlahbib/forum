package com.pidev.backend.Iservice;

import com.pidev.backend.Entity.Question;

import java.util.List;

public interface IQuestionService {
     public Question ajoutQuestion(Question q);
     public Question updateQuestion(String idq ,Question q);

     public void deleteQuestion(String idq);

     public Question affichDetailQuestion(String idq);

     public List<Question> afficherQuestions();

}
