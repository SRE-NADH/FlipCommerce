package com.project.FlipCommerce.Transformer;

import com.project.FlipCommerce.Dto.ReqDto.CardReqDto;
import com.project.FlipCommerce.Dto.ResDto.CardResDto;
import com.project.FlipCommerce.Model.Card;
import com.project.FlipCommerce.Model.Customer;

public class CardTransformer {

    public static Card ReqToCard(CardReqDto cardReqDto, Customer customer) {
        return Card.builder().cardNo(cardReqDto.getCardNo()).cardType(cardReqDto.getCardType())
                .cvv(cardReqDto.getCvv()).customer(customer).validTill(cardReqDto.getValidTill()).build();
    }

    public static CardResDto CardToRes(Card savedCard) {
        return  CardResDto.builder().cardNo(savedCard.getCardNo()).cardType(savedCard.getCardType())
                .name(savedCard.getCustomer().getName()).build();
    }

    public static String MaskedCardNo(Card card) {
        String cardno = card.getCardNo();
        String newNo = "";
        for(int i=0;i<cardno.length()-4;i++){
            newNo+='X';
        }
        return newNo+cardno.substring(cardno.length()-4);
    }
}
