package com.chicchoc.sivillage.domain.review.infrastructure;

import com.chicchoc.sivillage.domain.review.domain.ReviewMedia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewMediaRepository extends JpaRepository<ReviewMedia, Long> {
    List<ReviewMedia> findByReviewUuid(String reviewUuid);
}
