package com.project.FlipCommerce.Transformer;

import com.project.FlipCommerce.Dto.ReqDto.ProductReqDto;
import com.project.FlipCommerce.Dto.ResDto.ProductResDto;
import com.project.FlipCommerce.Model.Product;

public class ProductTransformer {

    public static Product ReqToProduct(ProductReqDto productReqDto) {
        return Product.builder().name(productReqDto.getName()).price(productReqDto.getPrice())
                .category(productReqDto.getCategory()).quantity(productReqDto.getQuantity()).build();
    }

    public static ProductResDto ProductToRes(Product savedProduct) {
        return ProductResDto.builder().productStatus(savedProduct.getProductStatus())
                .productName(savedProduct.getName()).sellerName(savedProduct.getSeller().getName())
                .category(savedProduct.getCategory()).price(savedProduct.getPrice()).quantity(savedProduct.getQuantity()).build();
    }
}
