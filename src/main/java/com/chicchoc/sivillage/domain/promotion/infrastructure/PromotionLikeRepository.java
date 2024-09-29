package com.chicchoc.sivillage.domain.promotion.infrastructure;

import com.chicchoc.sivillage.domain.promotion.domain.PromotionLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PromotionLikeRepository extends JpaRepository<PromotionLike, Long> {

    Optional<PromotionLike> findTopByPromotionUuidAndUserUuid(String promotionUuid, String userUuid);

    Optional<PromotionLike> findTopByPromotionUuidAndUserUuid(String promotionUuid, String userUuid);

    List<PromotionLike> findByUserUuidAndIsLiked(String userUuid, Boolean liked);

}
