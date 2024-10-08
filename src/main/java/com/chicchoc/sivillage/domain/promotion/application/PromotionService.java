package com.chicchoc.sivillage.domain.promotion.application;

import com.chicchoc.sivillage.domain.promotion.dto.in.PromotionFilterRequestDto;
import com.chicchoc.sivillage.domain.promotion.dto.in.PromotionRequestDto;
import com.chicchoc.sivillage.domain.promotion.dto.out.PromotionBenefitResponseDto;
import com.chicchoc.sivillage.domain.promotion.dto.out.PromotionMediaResponseDto;
import com.chicchoc.sivillage.domain.promotion.dto.out.PromotionProductResponseDto;
import com.chicchoc.sivillage.domain.promotion.dto.out.PromotionResponseDto;

import java.util.List;

public interface PromotionService {

    void addPromotion(PromotionRequestDto promotionRequestDto);

    List<PromotionResponseDto> findAllPromotions();

    void updatePromotion(String promotionUuid, PromotionRequestDto promotionRequestDto);

    PromotionResponseDto findPromotion(String promotionUuid);

    List<PromotionBenefitResponseDto> findPromotionBenefits(String promotionUuid);

    List<PromotionMediaResponseDto> findPromotionMedias(String promotionUuid);

    // 필터링 된 프로모션 조회
    List<PromotionResponseDto> getFilteredPromotions(PromotionFilterRequestDto promotionFilterRequestDto);

    List<PromotionProductResponseDto> findPromotionProducts(String promotionUuid);
}
