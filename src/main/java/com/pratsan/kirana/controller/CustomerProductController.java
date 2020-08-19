package com.pratsan.kirana.controller;

import com.pratsan.kirana.dto.ProductDto;
import com.pratsan.kirana.dto.ResponseDto;
import com.pratsan.kirana.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("products")

public class CustomerProductController {
@Autowired
private CustomerService customerService;
@GetMapping("")
    public ResponseEntity<ResponseDto> getAllProducts()
{
return  new ResponseEntity<>(customerService.getAllProducts(), HttpStatus.ACCEPTED);
}
    @PostMapping("/{sellerId}")
    public ResponseEntity<ResponseDto> storeProducts(@PathVariable("sellerId") String sellerId, @RequestBody ProductDto productDto,@RequestParam("file") MultipartFile file ) throws IOException {
   productDto.setProductImage(file.getBytes());
    return  new ResponseEntity<>(customerService.storeProduct(sellerId,productDto), HttpStatus.ACCEPTED);
}


}
