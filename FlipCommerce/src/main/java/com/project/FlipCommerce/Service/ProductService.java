package com.project.FlipCommerce.Service;

import com.project.FlipCommerce.Dto.ReqDto.ProductReqDto;
import com.project.FlipCommerce.Dto.ResDto.ProductResDto;
import com.project.FlipCommerce.Enum.Category;
import com.project.FlipCommerce.Exception.SellerNotFoundException;
import com.project.FlipCommerce.Model.Product;

import java.util.List;

public interface ProductService {
    ProductResDto addProduct(ProductReqDto productReqDto) throws SellerNotFoundException;

    List<ProductResDto> getAllProductByCategoryAndPrice(Category category, int price);
}
