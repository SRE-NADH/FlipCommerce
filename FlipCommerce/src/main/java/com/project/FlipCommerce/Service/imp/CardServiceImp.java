package com.project.FlipCommerce.Service.imp;

import com.project.FlipCommerce.Dto.ReqDto.CardReqDto;
import com.project.FlipCommerce.Dto.ResDto.CardResDto;
import com.project.FlipCommerce.Exception.CustomerNotFoundException;
import com.project.FlipCommerce.Model.Card;
import com.project.FlipCommerce.Model.Customer;
import com.project.FlipCommerce.Repocitory.CustomerRepocitory;
import com.project.FlipCommerce.Service.CardService;
import com.project.FlipCommerce.Transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImp implements CardService {
    @Autowired
    CustomerRepocitory customerRepocitory;
    @Override
    public CardResDto addCard(CardReqDto cardReqDto) throws CustomerNotFoundException{
        Customer customer = customerRepocitory.findByEmail(cardReqDto.getEmail());
        if(customer==null){
            throw new CustomerNotFoundException("invalid email");
        }
        Card card = CardTransformer.ReqToCard(cardReqDto,customer);
        customer.getCardList().add(card);
        Customer SavedCustomer = customerRepocitory.save(customer);
        Card  savedCard = SavedCustomer.getCardList().get(SavedCustomer.getCardList().size()-1);
       return CardTransformer.CardToRes(savedCard);
    }
}
