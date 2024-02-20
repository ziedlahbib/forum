package com.pidev.backend.Iservice;

import com.pidev.backend.Entity.Question;
import com.pidev.backend.Entity.User;
import com.pidev.backend.Entity.Vote;

public interface IVoteService {
    public void ajoutdeletevote(Question v, String idu , String idq);
    public int nbvotebyquest(String idq);

}
