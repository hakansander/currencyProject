package com.hakansander.currency.mapper;

import com.hakansander.currency.dto.CurrencyResponse.CurrencyResponseDto;
import com.hakansander.currency.model.responseModels.CurrencyResponse;

import java.util.TreeMap;

public class CurrencyResponseMapper {

    public static CurrencyResponseDto mapCurrencyResponse(CurrencyResponse currencyResponse) {

        CurrencyResponseDto currencyResponseDto = new CurrencyResponseDto(true,
                "Successfully returned currency list",
                "200",
                "success",
                new TreeMap<String, Object>());

        currencyResponseDto.getData().put("date", currencyResponse.getDate());
        currencyResponseDto.getData().put("base", currencyResponse.getBase());
        currencyResponseDto.getData().put("rates",currencyResponse.getRates());

        return currencyResponseDto;

    }

}
