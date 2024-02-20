package com.pidev.backend.Service;

import com.pidev.backend.Entity.Question;
import com.pidev.backend.Iservice.IQuestionService;
import com.pidev.backend.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    QuestionRepository questionrepo;

    @Override
    public Question ajoutQuestion(Question q) {
        q.setContenue(this.hashbadword(q.getContenue()));
        return questionrepo.save(q);
    }

    @Override
    public Question updateQuestion(String idq, Question q) {
        Question qu =questionrepo.findById(idq).orElse(null);
        qu.setContenue(q.getContenue());
        return questionrepo.save(qu);
    }

    @Override
    public void deleteQuestion(String idq) {
        questionrepo.deleteById(idq);
    }

    @Override
    public Question affichDetailQuestion(String idq) {
        return questionrepo.findById(idq).orElse(null);
    }

    @Override
    public List<Question> afficherQuestions() {
        return questionrepo.findAll();
    }
    public static String hashbadword(String c) {

        List<String> badWords = new ArrayList<>();
        badWords.add("Hello");
        badWords.add("World");
        badWords.add("Java");

        // Split the paragraph into words using whitespace as the delimiter
        String[] words = c.split("\\s+");

        // Iterate through the bad words list
        for (String badWord : badWords) {
            // Iterate through each word in the paragraph
            for (int i = 0; i < words.length; i++) {
                // If the word matches the bad word, replace it with ***
                if (words[i].equalsIgnoreCase(badWord)) {
                    words[i] = "***";
                }
            }
        }

        // Reconstruct the paragraph with replaced words
        String modifiedParagraph = String.join(" ", words);

        // Output the modified paragraph
        return modifiedParagraph;
    }
}
