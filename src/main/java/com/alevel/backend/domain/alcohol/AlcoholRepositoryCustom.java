package com.alevel.backend.domain.alcohol;

import com.alevel.backend.controller.dto.RecommendAlcoholDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlcoholRepositoryCustom {

    Page<Alcohol> findAllAlcohol(String type, String category, Pageable pageable);
    RecommendAlcoholDto findNameAndImageByUseridAndType(Long id, String type);

}
