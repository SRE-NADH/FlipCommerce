package com.project.FlipCommerce.Service.imp;

import com.project.FlipCommerce.Dto.ReqDto.ProductReqDto;
import com.project.FlipCommerce.Dto.ResDto.ProductResDto;
import com.project.FlipCommerce.Enum.Category;
import com.project.FlipCommerce.Enum.ProductStatus;
import com.project.FlipCommerce.Exception.SellerNotFoundException;
import com.project.FlipCommerce.Model.Product;
import com.project.FlipCommerce.Model.Seller;
import com.project.FlipCommerce.Repocitory.ProductRepocitory;
import com.project.FlipCommerce.Repocitory.SellerRepocitory;
import com.project.FlipCommerce.Service.ProductService;
import com.project.FlipCommerce.Transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    SellerRepocitory sellerRepocitory;

    @Autowired
    ProductRepocitory productRepocitory;
    @Override
    public ProductResDto addProduct(ProductReqDto productReqDto)throws SellerNotFoundException {
        Seller seller = sellerRepocitory.findByEmail(productReqDto.getEmail());
        if(seller==null){
            throw new SellerNotFoundException("invalid seller email");
        }
        Product product = ProductTransformer.ReqToProduct(productReqDto);
        product.setProductStatus(ProductStatus.AVAILABLE);
        product.setSeller(seller);
        seller.getProductList().add(product);
        Seller savedSeller = sellerRepocitory.save(seller);
        Product savedProduct = savedSeller.getProductList().get(savedSeller.getProductList().size()-1);
        return  ProductTransformer.ProductToRes(savedProduct);

    }

    @Override
    public List<ProductResDto> getAllProductByCategoryAndPrice(Category category, int price) {

        List<Product> productList = productRepocitory.findByCategoryAndPrice(category,price);

      List<ProductResDto> tmp = new ArrayList<>();
      for(Product product:productList){
          tmp.add(ProductTransformer.ProductToRes(product));
      }
        return tmp;
    }
}
