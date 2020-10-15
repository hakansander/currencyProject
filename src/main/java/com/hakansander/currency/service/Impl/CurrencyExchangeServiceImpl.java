package com.hakansander.currency.service.Impl;

import com.hakansander.currency.dto.CurrencyResponse.CurrencyResponseDto;
import com.hakansander.currency.exceptionHandling.CurrencyFormatException;
import com.hakansander.currency.mapper.CurrencyDateRangeResponseMapper;
import com.hakansander.currency.mapper.CurrencyResponseMapper;
import com.hakansander.currency.model.requestModels.CurrencyRangeRequestBody;
import com.hakansander.currency.model.responseModels.CurrencyDateRangeResponse;
import com.hakansander.currency.model.responseModels.CurrencyResponse;
import com.hakansander.currency.service.CurrencyExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    private final static String SCHEME = "https";
    private final static String HOST = "api.exchangeratesapi.io";
    private final static String LATEST_PATH = "/latest";
    private final static String DATE_PATH = "/";
    private final static String DATE_RANGE_PATH = "/history";
    private final static String QUERY_BASE_CURRENCY = "base={base}";
    private final static String QUERY_TARGET_CURRENCIES = "symbols={targetCurrencies}";
    private final static String QUERY_START_DATE = "start_at={startDate}";
    private final static String QUERY_END_DATE = "end_at={endDate}";

    public CurrencyResponseDto getCurrencyExchangeValues(String baseCurrency) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance().
                scheme(SCHEME).host(HOST).
                path(LATEST_PATH).
                query(QUERY_BASE_CURRENCY).
                buildAndExpand(baseCurrency);
        CurrencyResponse response = currencyServiceCall(uriComponents, baseCurrency);

        return CurrencyResponseMapper.mapCurrencyResponse(response);
    }

    public CurrencyResponseDto getCurrencyExchangeValues(String baseCurrency, String date) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance().
                scheme(SCHEME).host(HOST).
                path(DATE_PATH + date).
                query(QUERY_BASE_CURRENCY).
                buildAndExpand(baseCurrency);
        CurrencyResponse response = currencyServiceCall(uriComponents, baseCurrency);

        return CurrencyResponseMapper.mapCurrencyResponse(response);
    }

    public CurrencyResponseDto getCurrencyExchangeValues(String baseCurrency, String date, String targetCurrencies) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance().
                scheme(SCHEME).host(HOST).
                path(DATE_PATH + date).
                query(QUERY_BASE_CURRENCY).
                query(QUERY_TARGET_CURRENCIES).
                buildAndExpand(baseCurrency, targetCurrencies);

        CurrencyResponse response = currencyServiceCall(uriComponents, baseCurrency);

        return CurrencyResponseMapper.mapCurrencyResponse(response);
    }

    public CurrencyResponseDto getCurrencyExchangeValues(String baseCurrency, CurrencyRangeRequestBody requestBody) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance().
                scheme(SCHEME).host(HOST).
                path(DATE_RANGE_PATH).
                query(QUERY_BASE_CURRENCY).
                query(QUERY_TARGET_CURRENCIES).
                query(QUERY_START_DATE).
                query(QUERY_END_DATE).
                buildAndExpand(baseCurrency, requestBody.getTargetCurrencies(), requestBody.getStartDate(), requestBody.getEndDate());

        RestTemplate restTemplate = new RestTemplate();

        CurrencyDateRangeResponse response = null;
        try {
            response = restTemplate.getForObject(uriComponents.toString(), CurrencyDateRangeResponse.class);
        } catch (Exception e) {
            log.error("[currencyServiceCall] Exception occurred.", e);
            throw new CurrencyFormatException("Currency format is invalid for the currency input " + baseCurrency);
        }

        return CurrencyDateRangeResponseMapper.mapCurrencyDateRangeCurrencyResponse(response);
    }

    public CurrencyResponse getCurrencyExchangeValues(String baseCurrency, String startDate, String endDate, boolean dummyFlag) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance().
                scheme(SCHEME).host(HOST).
                path(DATE_RANGE_PATH).
                query(QUERY_BASE_CURRENCY).
                query(QUERY_START_DATE).
                query(QUERY_END_DATE).
                buildAndExpand(baseCurrency, startDate, endDate);

        return currencyServiceCall(uriComponents, baseCurrency);
    }

    private CurrencyResponse currencyServiceCall(UriComponents uriComponents, String baseCurrency) {
        RestTemplate restTemplate = new RestTemplate();

        CurrencyResponse response = null;
        try {
            response = restTemplate.getForObject(uriComponents.toString(), CurrencyResponse.class);
        } catch (Exception e) {
            log.error("[currencyServiceCall] Exception occurred.", e);
            throw new CurrencyFormatException("Currency format is invalid for the currency input " + baseCurrency);
        }

        return response;
    }
}
