package com.alevel.backend.domain.review;


import com.alevel.backend.dto.AlcoholReviewResponseDto;

import java.util.List;

public interface ReviewRepositoryCustom {

    List<AlcoholReviewResponseDto> findAllByAlcoholId(Long id);

}
