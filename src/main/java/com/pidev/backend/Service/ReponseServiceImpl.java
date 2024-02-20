package com.pidev.backend.Service;

import com.pidev.backend.Entity.Question;
import com.pidev.backend.Entity.Reponse;
import com.pidev.backend.Entity.User;
import com.pidev.backend.Iservice.IReponseService;
import com.pidev.backend.Repository.QuestionRepository;
import com.pidev.backend.Repository.ReponseRepository;
import com.pidev.backend.Repository.UserRepository;
import com.pidev.backend.Repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReponseServiceImpl implements IReponseService {
    @Autowired
    ReponseRepository reponserepo;
    @Autowired
    UserRepository userrepo;
    @Autowired
    QuestionRepository questionrepo;

    @Override
    public Reponse ajoutReponse(Reponse q,String idq ,String iduse) {

        Question qu =questionrepo.findById(idq).orElse(null);
        User u=userrepo.findById(iduse).orElse(null);
        String contenu = QuestionServiceImpl.hashbadword(q.getContenue()) ;
        q.setContenue(contenu);
        q.setQuestion(qu);
        q.setUser(u);
        return reponserepo.save(q);
    }

    @Override
    public Reponse updateReponse(String idq, Reponse q) {
        Reponse qu =reponserepo.findById(idq).orElse(null);
        if (qu != null) {
            qu.setContenue(q.getContenue());
        }
        if (qu != null) {
            return reponserepo.save(qu);
        }
        return qu;
    }

    @Override
    public void deleteReponse(String idq) {
        reponserepo.deleteById(idq);
    }

    @Override
    public Reponse affichDetailReponse(String idq) {
        return reponserepo.findById(idq).orElse(null);
    }

    @Override
    public List<Reponse> afficherReponse() {
        return reponserepo.findAll();
    }

    @Override
    public List<Reponse> afficherReponsebypost(String idq) {
        Question q = questionrepo.findById(idq).orElse(null);
        if (q != null) {
            return q.getReponses();
        }
        return null;
    }
}
