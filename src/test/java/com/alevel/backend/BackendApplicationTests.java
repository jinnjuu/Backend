package com.alevel.backend;

import com.alevel.backend.domain.Alchol;
import com.alevel.backend.domain.RecommendRepository;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BackendApplicationTests {

    @Autowired
    private RecommendRepository repo;

    @Test
    public void 반환테스트(){

    }

}
