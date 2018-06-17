package com.kodilla.patterns2.facade.api;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import com.kodilla.patterns2.facade.ShopService;

@Service
@EnableAspectJAutoProxy
public class OrderFacade {

    @Autowired
    private ShopService shopService;

    public void processOrder(final OrderDto order, final Long userId) throws OrderProcessingException {
        boolean wasError = false;
        long orderId = shopService.openOrder(userId);
        if (orderId < 0) {
            wasError = true;
            throw new OrderProcessingException(OrderProcessingException.ERR_NOT_AUTHORIZED);
        }
        try {
            for (ItemDto itemDto : order.getItems()) {
                shopService.addItem(orderId, itemDto.getProductId(), itemDto.getQty());
            }
            BigDecimal value = shopService.calculateValue(orderId);

            if (!shopService.doPayment(orderId)) {
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_PAYMENT_REJECTED);
            }

            if (!shopService.verifyOrder(orderId)) {
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_VERIFICATION_ERROR);
            }

            if (!shopService.submitOrder(orderId)) {
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_SUBMITTING_ERROR);
            }
        } finally {
            if (wasError) {
                shopService.cancelOrder(orderId);
            }
        }
    }
}