package com.alevel.backend.domain.alcohol;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlcoholRepositoryCustom {

    Page<Alcohol> findAllAlcohol(String type, String category, Pageable pageable);

}
