package com.pidev.backend.Iservice;

import com.pidev.backend.Entity.User;
import com.pidev.backend.Entity.Vote;

public interface IVoteService {
    public void ajoutdeletevote(Vote v,String idu , String idq);

}
