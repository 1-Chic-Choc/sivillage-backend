package com.chicchoc.sivillage.global.data.presentation;

import com.chicchoc.sivillage.global.common.entity.BaseResponse;
import com.chicchoc.sivillage.global.data.application.ProductDataService;
import com.chicchoc.sivillage.global.data.dto.product.ProductDataRequestDto;
import com.chicchoc.sivillage.global.data.util.JsonFileUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "데이터", description = "데이터 삽입용 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/data")
public class ProductDataController {

    private final ProductDataService productDataService;

    @Operation(summary = "상품 데이터 업로드")
    @PostMapping(value = "/product/all", consumes = {"multipart/form-data"})
    public BaseResponse<Void> uploadProductData(@RequestParam("file") MultipartFile file) throws IOException {

        List<ProductDataRequestDto> productDataRequestDtos = JsonFileUtil.parseFileToDtoList(
                file,
                ProductDataRequestDto[].class);

        // 변환된 DTO 리스트 저장
        productDataService.saveProductData(productDataRequestDtos);

        return new BaseResponse<>();
    }
}
