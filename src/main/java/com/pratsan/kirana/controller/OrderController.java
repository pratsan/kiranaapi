package com.pratsan.kirana.controller;

import com.pratsan.kirana.dto.OrderDto;
import com.pratsan.kirana.dto.ResponseDto;
import com.pratsan.kirana.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders/")
public class OrderController {
    @Autowired
    private OrderService orderService;
@PutMapping("/{customerId}")
    public ResponseEntity<Boolean> placeOrder(@RequestBody List<OrderDto> orderDtoList, @PathVariable("customerId") String customerId)
{
    return new ResponseEntity<>(orderService.placeOrder(orderDtoList,customerId), HttpStatus.ACCEPTED);
}
@GetMapping("/{customerId}")
    public ResponseEntity<ResponseDto> getPlacedOrder(@PathVariable("customerId") String customerId)
{
    return new ResponseEntity<>(orderService.getPlacedOrder(customerId),HttpStatus.ACCEPTED);
}
}
