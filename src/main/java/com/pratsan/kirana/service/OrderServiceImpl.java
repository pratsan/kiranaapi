package com.pratsan.kirana.service;

import com.pratsan.kirana.dto.OrderDto;
import com.pratsan.kirana.dto.ProductOrderDetail;
import com.pratsan.kirana.dto.ResponseDto;
import com.pratsan.kirana.entity.Order;
import com.pratsan.kirana.entity.ProductList;
import com.pratsan.kirana.repository.OrderRepository;
import com.pratsan.kirana.repository.ProductListRepository;
import com.pratsan.kirana.util.ApplicationConstant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductListRepository productListRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    ResponseDto responseDto;

    @Transactional
    @Override
    public boolean placeOrder(List<OrderDto> orderDtoList,String customerId) {
        try {
            List<ProductList> productLists = new ArrayList<>();
            List<Order> orderList = new ArrayList<>();
            for (OrderDto orderDto : orderDtoList) {
                long productId = orderDto.getProductId();
                Optional<ProductList> productListOptional = productListRepository.findById(productId);
                if (!productListOptional.isPresent()) {

                }
                ProductList productList = productListOptional.get();
                productList.setQuantity(productList.getQuantity()-orderDto.getTotalQuantity() );
                productLists.add(productList);
                Order order = new Order();
                BeanUtils.copyProperties(orderDto, order);
                order.setOrderDate(LocalDate.now());
                order.setCustomerId(customerId);
                orderList.add(order);
            }


            orderRepository.saveAll(orderList);
            productListRepository.saveAll(productLists);

            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public ResponseDto<ProductOrderDetail> getPlacedOrder(String customerId) {
        List<Order> orders=orderRepository.findByCustomerId(customerId);
        List<ProductOrderDetail> productOrderDetails=new ArrayList<>();
        if(!orders.isEmpty())
        {
            for (Order order:orders) {
            Optional<ProductList> productList=productListRepository.findById(order.getProductId());
                ProductList productList1=productList.get();
                ProductOrderDetail productOrderDetail=new ProductOrderDetail();
          productOrderDetail.setProductName(productList1.getProductName());
          productOrderDetail.setTotalAmount(order.getTotalAmount());
          productOrderDetail.setOrderDate(order.getOrderDate());
          productOrderDetail.setTotalQuantity(order.getTotalQuantity());
          productOrderDetails.add(productOrderDetail);

            }
        }
        responseDto.setObject(productOrderDetails);
        responseDto.setStatus_code(ApplicationConstant.SUCCESS_CODE);
        responseDto.setStatus_msg("order deatil found");
        return responseDto;
    }
}
