package com.pidev.backend.Controller;

import com.pidev.backend.Entity.Question;
import com.pidev.backend.Entity.Reponse;
import com.pidev.backend.Entity.Vote;
import com.pidev.backend.Service.VoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",exposedHeaders="Access-Control-Allow-Origin" )
@RestController
@RequestMapping("/vote")
public class VoteController {
    @Autowired
    VoteServiceImpl voteserv;

    @PostMapping("/add-delete-vote/{id-use}/{id-question}")
    @ResponseBody
    public void ajoutdeletevote(@RequestBody Question p, @PathVariable("id-question") String idq, @PathVariable("id-use") String idu) {
         voteserv.ajoutdeletevote(p,idu,idq);

    }
    @GetMapping("/nbr-vote/{id-question}")
    @ResponseBody
    public void ajoutdeletevote( @PathVariable("id-question") String idq) {
        voteserv.nbvotebyquest(idq);

    }
}
