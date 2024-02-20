package com.pidev.backend.Controller;

import com.pidev.backend.Entity.Question;
import com.pidev.backend.Service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",exposedHeaders="Access-Control-Allow-Origin" )
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionServiceImpl questionserv;
    @PostMapping("/add-question")
    @ResponseBody
    public Question ajoutquestion(@RequestBody Question p) {
        return questionserv.ajoutQuestion(p);

    }
    @GetMapping("/get-question/{id-question}")
    @ResponseBody
    public Question getquestionbyid(@PathVariable("id-question") String idq) {
        return questionserv.affichDetailQuestion(idq);

    }
    @GetMapping("/get-questions")
    @ResponseBody
    public List<Question> getquestionbyid() {
        return questionserv.afficherQuestions();

    }
    @PutMapping("/update-question/{id-question}")
    @ResponseBody
    public Question upadatequestion(@RequestBody Question t, @PathVariable("id-question") String idq) {
        return questionserv.updateQuestion(idq,t);

    }
    @DeleteMapping("/delete-question/{id-question}")
    @ResponseBody
    public void deletequestion(@PathVariable("id-question") String idq) {
         questionserv.deleteQuestion(idq);

    }
}
