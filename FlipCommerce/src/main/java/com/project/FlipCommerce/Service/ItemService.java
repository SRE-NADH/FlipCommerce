package com.project.FlipCommerce.Service;

import com.project.FlipCommerce.Dto.ReqDto.ItemReqDto;
import com.project.FlipCommerce.Exception.CustomerNotFoundException;
import com.project.FlipCommerce.Exception.InsufficientProductException;
import com.project.FlipCommerce.Exception.ProductNotFoundException;
import com.project.FlipCommerce.Model.Customer;
import com.project.FlipCommerce.Model.Item;
import com.project.FlipCommerce.Model.Product;

public interface ItemService {
    Item buildItem(ItemReqDto itemReqDto) throws InsufficientProductException, CustomerNotFoundException, ProductNotFoundException;
}
