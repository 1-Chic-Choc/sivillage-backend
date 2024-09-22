package com.chicchoc.sivillage.domain.review.infrastructure;

import com.chicchoc.sivillage.domain.review.domain.Review;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByProductUuid(String productUuid);

    List<Review> findByUserUuid(String userUuid);

    Optional<Review> findByReviewUuid(String reviewUuid);
}
