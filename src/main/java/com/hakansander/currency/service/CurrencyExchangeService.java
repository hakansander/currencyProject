package com.hakansander.currency.service;

import com.hakansander.currency.dto.CurrencyResponse.CurrencyResponseDto;
import com.hakansander.currency.model.requestModels.CurrencyRangeRequestBody;

public interface CurrencyExchangeService {
    CurrencyResponseDto getCurrencyExchangeValues(String baseCurrency);
    CurrencyResponseDto getCurrencyExchangeValues(String baseCurrency, String date);
    CurrencyResponseDto getCurrencyExchangeValues(String baseCurrency, String date, String targetCurrencies);
    CurrencyResponseDto getCurrencyExchangeValues(String baseCurrency, CurrencyRangeRequestBody requestBody);
    CurrencyResponseDto getCurrencyExchangeValues(String baseCurrency, String startDate, String endDate, boolean dummyFlag);
}
