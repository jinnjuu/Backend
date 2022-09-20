package com.alevel.backend.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlcoholReviewSaveDto {

        private Long alcoholid;
        private Long userid;
        private String content;

        public AlcoholReviewSaveDto(Long alcoholid, Long userid, String content) {
            this.alcoholid = alcoholid;
            this.userid = userid;
            this.content = content;
        }

}
