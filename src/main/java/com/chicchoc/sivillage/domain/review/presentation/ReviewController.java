package com.chicchoc.sivillage.domain.review.presentation;

import com.chicchoc.sivillage.domain.review.application.ReviewService;
import com.chicchoc.sivillage.domain.review.dto.in.ReviewRequestDto;
import com.chicchoc.sivillage.domain.review.dto.out.ReviewResponseDto;
import com.chicchoc.sivillage.domain.review.vo.in.ReviewRequestVo;
import com.chicchoc.sivillage.domain.review.vo.out.ReviewResponseVo;
import com.chicchoc.sivillage.global.common.entity.CommonResponseEntity;
import java.util.List;
import java.util.stream.Collectors;
import javax.naming.AuthenticationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public CommonResponseEntity<Void> createReview(@RequestBody ReviewRequestVo reviewRequestVo) {
        ReviewRequestDto reviewRequestDto = ReviewRequestDto.builder()
                .productId(reviewRequestVo.getProductId())
                .size(reviewRequestVo.getSize())
                .reviewOption(reviewRequestVo.getReviewOption())
                .info(reviewRequestVo.getInfo())
                .rate(reviewRequestVo.getRate())
                .content(reviewRequestVo.getContent())
                .build();
        reviewService.addReview(reviewRequestDto);
        return new CommonResponseEntity<>(
                HttpStatus.CREATED,
                "리뷰 작성 성공",
                null
        );
    }

    @GetMapping("/product/{productId}")
    public CommonResponseEntity<List<ReviewResponseVo>> getReviewByProductId(
            @PathVariable("productId") Long productId) {
        List<ReviewResponseDto> reviewResponseDto = reviewService.getReviewByProductId(productId);

        List<ReviewResponseVo> reviewResponseVoList = reviewResponseDto.stream()
                .map(ReviewResponseDto::toResponseVo)  // 각각의 ReviewResponseDto를 ReviewResponseVo로 변환
                .toList();         // 변환된 리스트를 List로 수집

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "리뷰 불러오기 성공",
                reviewResponseVoList
        );
    }

    @GetMapping("/user/{userId}")
    public CommonResponseEntity<List<ReviewResponseVo>> getReviewByUserId(@PathVariable("userId") Long userId) {
        // Authentication authentication
        // log.info("test" + authentication);

        List<ReviewResponseDto> reviewResponseDto = reviewService.getReviewByUserId(userId);

        List<ReviewResponseVo> reviewResponseVoList = reviewResponseDto.stream()
                .map(ReviewResponseDto::toResponseVo)
                .toList();

        return new CommonResponseEntity<>(
                HttpStatus.OK,
                "리뷰 불러오기 성공",
                reviewResponseVoList
        );
    }
}



