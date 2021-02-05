package com.hakansander.currency.mapper;

import com.hakansander.currency.dto.CurrencyResponse.CurrencyResponseDto;
import com.hakansander.currency.model.responseModels.CurrencyDateRangeResponse;

import java.util.TreeMap;

public class CurrencyDateRangeResponseMapper {

    public static CurrencyResponseDto mapCurrencyDateRangeCurrencyResponse(CurrencyDateRangeResponse currencyDateRangeResponse) {

        CurrencyResponseDto currencyResponseDto = new CurrencyResponseDto(true,
                "Successfully returned currency list",
                "200",
                "success",
                new TreeMap<String, Object>());

        currencyResponseDto.getData().put("startDate", currencyDateRangeResponse.getStartAt());
        currencyResponseDto.getData().put("endDate", currencyDateRangeResponse.getEndAt());
        currencyResponseDto.getData().put("base", currencyDateRangeResponse.getBase());
        currencyResponseDto.getData().put("rates",currencyDateRangeResponse.getRates());

        return currencyResponseDto;

    }

}
