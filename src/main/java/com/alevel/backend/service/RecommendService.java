package com.alevel.backend.service;

import com.alevel.backend.domain.Alchol;
import com.alevel.backend.domain.RecommendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendService {
    private final RecommendRepository recommendRepository;

    @Autowired
    public RecommendService(RecommendRepository recommendRepository){
        this.recommendRepository=recommendRepository;
    }

    public Alchol search(Alchol alchol){
        RecommendRepository.findByCol()
         }

}
