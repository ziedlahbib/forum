package com.pidev.backend.Service;

import com.pidev.backend.Entity.Question;
import com.pidev.backend.Entity.Reponse;
import com.pidev.backend.Entity.SignalBadword;
import com.pidev.backend.Entity.User;
import com.pidev.backend.Iservice.ISignalBadWordService;
import com.pidev.backend.Repository.QuestionRepository;
import com.pidev.backend.Repository.ReponseRepository;
import com.pidev.backend.Repository.SignaBAdWordRepository;
import com.pidev.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignalBadWordServImpl implements ISignalBadWordService {
    @Autowired
    SignaBAdWordRepository sbwrepo;
    @Autowired
    QuestionRepository questrepo;
    @Autowired
    UserRepository userrpo;
    @Autowired
    ReponseRepository reponserepo;

    @Override
    public SignalBadword ajouterbadword(String idq,String idu,String s) {
        SignalBadword sbw=new SignalBadword();
        Question q = questrepo.findById(idq).orElse(null);
        Reponse r = reponserepo.findById(idq).orElse(null);
        User u = userrpo.findById(idu).orElse(null);
        if(u!=null&&(q!=null||r!=null)){
            sbw.setUser(u);
            if(r!=null){
                sbw.setQuestion(q);
                sbw.setBadword(s);
            }
            if(q!=null){
                sbw.setQuestion(q);
                sbw.setBadword(s);
            }


        }
        return sbwrepo.save(sbw);
    }

    @Override
    public List<SignalBadword> afficheBadword() {
        return sbwrepo.findAll();
    }
}
