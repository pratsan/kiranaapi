package com.pratsan.kirana.service;

import com.pratsan.kirana.dto.OrderDto;
import com.pratsan.kirana.dto.ProductOrderDetail;
import com.pratsan.kirana.dto.ResponseDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public interface OrderService {
    @Transactional
    public boolean placeOrder(List<OrderDto> orderDto,String customerId);
    public ResponseDto<ProductOrderDetail> getPlacedOrder(String customerId);
}
