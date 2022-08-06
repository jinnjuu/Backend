package com.alevel.backend.domain.alcohol;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AlcoholRepositoryCustom {

    Page<Alcohol> findAllAlcohol(String type, String category, Pageable pageable);

}
