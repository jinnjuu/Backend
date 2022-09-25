package com.alevel.backend.domain.alcohol;

import com.alevel.backend.controller.dto.AlcoholResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlcoholRepositoryCustom {

    Page<AlcoholResponseDto> findAllAlcohol(String type, String category, Pageable pageable);

}
