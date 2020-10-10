package com.hakansander.currency.service;

import com.hakansander.currency.model.requestModels.CurrencyRangeRequestBody;
import com.hakansander.currency.model.responseModels.CurrencyServiceDateRangeResponse;
import com.hakansander.currency.model.responseModels.CurrencyServiceResponse;

public interface CurrencyExchangeService {
    CurrencyServiceResponse getCurrencyExchangeValues(String baseCurrency);
    CurrencyServiceResponse getCurrencyExchangeValues(String baseCurrency, String date);
    CurrencyServiceResponse getCurrencyExchangeValues(String baseCurrency, String date, String targetCurrencies);
    CurrencyServiceDateRangeResponse getCurrencyExchangeValues(String baseCurrency, CurrencyRangeRequestBody requestBody);
    CurrencyServiceResponse getCurrencyExchangeValues(String baseCurrency, String startDate, String endDate, boolean dummyFlag);
}
