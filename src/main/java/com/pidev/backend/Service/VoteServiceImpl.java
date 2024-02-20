package com.pidev.backend.Service;

import com.pidev.backend.Entity.Question;
import com.pidev.backend.Entity.Reponse;
import com.pidev.backend.Entity.User;
import com.pidev.backend.Entity.Vote;
import com.pidev.backend.Iservice.IVoteService;
import com.pidev.backend.Repository.QuestionRepository;
import com.pidev.backend.Repository.UserRepository;
import com.pidev.backend.Repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteServiceImpl implements IVoteService {
    @Autowired
    UserRepository userrepo;
    @Autowired
    VoteRepository voterepo;
    @Autowired
    QuestionRepository questionrepo;
    @Override
    public void ajoutdeletevote(Question question,String idu, String idq) {
        Vote v=new Vote();
        Question question = questionrepo.findById(idq).orElse(null);
        User user = userrepo.findById(idu).orElse(null);
        Vote vote =voterepo.findByQuestionAndUser(idq,idu);
        if(v==null){
            v.setUser(user);
            v.setQuestion(question);
            user.getVotes().add(v);
            question.getVotes().add(v);
            userrepo.save(user);
            voterepo.save(v);
            questionrepo.save(question);

        }else{
            vote.setUser(null);
            vote.setQuestion(null);
            if(user.getVotes()!=null&&question.getVotes()!=null){
                user.getVotes().remove(vote);
                question.getVotes().remove(vote);
                userrepo.save(user);
                questionrepo.save(question);
                voterepo.save(vote);
                voterepo.delete(v);
            }


        }

    }

    @Override
    public int nbvotebyquest(String idq) {
        List ques =questionrepo.findAll();
        return ques.size();
    }

}
