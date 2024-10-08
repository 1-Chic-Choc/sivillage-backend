package com.chicchoc.sivillage.domain.order.dto.out;

import com.chicchoc.sivillage.domain.order.domain.Order;
import com.chicchoc.sivillage.domain.order.vo.out.OrderDetailResponseVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponseDto {

    private String ordererName;
    private String ordererEmail;
    private String ordererPhone;
    private String recipientName;
    private String recipientPhone;
    private String recipientAddress;
    private String deliveryName;
    private String deliveryRequest;

    public OrderDetailResponseVo toVo() {
        return OrderDetailResponseVo.builder()
                .ordererName(ordererName)
                .ordererEmail(ordererEmail)
                .ordererPhone(ordererPhone)
                .recipientName(recipientName)
                .recipientPhone(recipientPhone)
                .recipientAddress(recipientAddress)
                .deliveryName(deliveryName)
                .deliveryRequest(deliveryRequest)
                .build();
    }

    public static OrderDetailResponseDto fromEntity(Order order) {
        return OrderDetailResponseDto.builder()
                .ordererName(order.getOrdererName())
                .ordererEmail(order.getOrdererEmail())
                .ordererPhone(order.getOrdererPhone())
                .recipientName(order.getRecipientName())
                .recipientPhone(order.getRecipientPhone())
                .recipientAddress(order.getRecipientAddress())
                .deliveryName(order.getDeliveryName())
                .deliveryRequest(order.getDeliveryRequest())
                .build();
    }
}
