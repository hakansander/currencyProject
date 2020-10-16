package com.hakansander.currency.controller;

import com.hakansander.currency.dto.CurrencyResponse.CurrencyResponseDto;
import com.hakansander.currency.model.requestModels.CurrencyRangeRequestBody;
import com.hakansander.currency.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency")
public class CurrencyExchangeController {
    @Autowired
    CurrencyExchangeService currencyExchangeService;

    @GetMapping("/{baseCurrency}")
    public CurrencyResponseDto getCurrencyValues(@PathVariable String baseCurrency) {
        return currencyExchangeService.getCurrencyExchangeValues(baseCurrency);
    }

    @GetMapping(value = "/{date}/{baseCurrency}")
    public CurrencyResponseDto getCurrencyValues(@PathVariable String date,
                                              @PathVariable String baseCurrency) {
        return currencyExchangeService.getCurrencyExchangeValues(baseCurrency, date);
    }

    @GetMapping(value = "/{date}/{baseCurrency}", params = { "targetCurrencies" })
    public CurrencyResponseDto getCurrencyValues(@PathVariable String date,
                                              @PathVariable String baseCurrency,
                                              @RequestParam(value = "targetCurrencies") String targetCurrencies ) {
        return currencyExchangeService.getCurrencyExchangeValues(baseCurrency, date, targetCurrencies);
    }

    @PostMapping(path = "/{baseCurrency}", consumes = "application/json", produces = "application/json")
    public CurrencyResponseDto getCurrencyValues(@PathVariable String baseCurrency,
                                                       @RequestBody CurrencyRangeRequestBody requestBody) {

        return currencyExchangeService.getCurrencyExchangeValues(baseCurrency, requestBody);
    }

    @GetMapping(value = "/{baseCurrency}", params = { "startDate", "endDate" })
    public CurrencyResponseDto getCurrencyValuesForGivenRange(@PathVariable String baseCurrency,
                                                           @RequestParam(value = "startDate") String startDate,
                                                           @RequestParam(value = "endDate") String endDate) {
        return currencyExchangeService.getCurrencyExchangeValues(baseCurrency, startDate, endDate, true);
    }
}
