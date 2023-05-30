package com.project.FlipCommerce.Service;

import com.project.FlipCommerce.Dto.ReqDto.CardReqDto;
import com.project.FlipCommerce.Dto.ResDto.CardResDto;
import com.project.FlipCommerce.Exception.CustomerNotFoundException;

public interface CardService {
    CardResDto addCard(CardReqDto cardReqDto) throws CustomerNotFoundException;
}
