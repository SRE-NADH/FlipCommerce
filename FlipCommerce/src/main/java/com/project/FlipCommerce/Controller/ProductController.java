package com.project.FlipCommerce.Controller;

import com.project.FlipCommerce.Dto.ReqDto.ProductReqDto;
import com.project.FlipCommerce.Dto.ResDto.ProductResDto;
import com.project.FlipCommerce.Enum.Category;
import com.project.FlipCommerce.Exception.SellerNotFoundException;
import com.project.FlipCommerce.Model.Product;
import com.project.FlipCommerce.Service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flipcommerce/product")
public class ProductController {
    @Autowired
    ProductServiceImp productServiceImp;
    @PostMapping("/add_product")
    public ResponseEntity addProduct(@RequestBody ProductReqDto productReqDto){
        try {
            ProductResDto productResDto = productServiceImp.addProduct(productReqDto);
            return new ResponseEntity<>(productResDto, HttpStatus.CREATED);
        }
        catch (SellerNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
@GetMapping("/get/category/{category}/price/{price}")
    public ResponseEntity getAllProductByCategoryAndPrice(@PathVariable("category") Category category,@PathVariable int price){
    List<ProductResDto> products = productServiceImp.getAllProductByCategoryAndPrice(category,price);
    return new ResponseEntity<>(products,HttpStatus.OK);
    }
}
