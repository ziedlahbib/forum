package com.pidev.backend.Iservice;

import com.pidev.backend.Entity.Question;
import com.pidev.backend.Entity.Reponse;

import java.util.List;

public interface IReponseService {
    public Reponse ajoutReponse(Reponse q,String idq ,Long iduse);
    public Reponse updateReponse(Long idq ,Reponse q);

    public void deleteReponse(Long idq);

    public Reponse affichDetailReponse(Long idq);

    public List<Reponse> afficherReponse();
}
