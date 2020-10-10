package com.hakansander.currency.controller;

import com.hakansander.currency.model.requestModels.CurrencyRangeRequestBody;
import com.hakansander.currency.model.responseModels.CurrencyServiceDateRangeResponse;
import com.hakansander.currency.model.responseModels.CurrencyServiceResponse;
import com.hakansander.currency.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency")
public class CurrencyExchangeController {
    @Autowired
    CurrencyExchangeService currencyExchangeService;

    @GetMapping("/{baseCurrency}")
    public CurrencyServiceResponse getCurrencyValues(@PathVariable String baseCurrency) {

        CurrencyServiceResponse CurrencyServiceResponse = currencyExchangeService.getCurrencyExchangeValues(baseCurrency);

        return CurrencyServiceResponse;
    }

    @GetMapping(value = "/{date}/{baseCurrency}")
    public CurrencyServiceResponse getCurrencyValues(@PathVariable String date,
                                                    @PathVariable String baseCurrency) {

        CurrencyServiceResponse CurrencyServiceResponse = currencyExchangeService.getCurrencyExchangeValues(baseCurrency, date);

        return CurrencyServiceResponse;
    }

    @GetMapping(value = "/{date}/{baseCurrency}", params = { "targetCurrencies" })
    public CurrencyServiceResponse getCurrencyValues(@PathVariable String date,
                                                    @PathVariable String baseCurrency,
                                                    @RequestParam(value = "targetCurrencies") String targetCurrencies ) {

        CurrencyServiceResponse CurrencyServiceResponse = currencyExchangeService.getCurrencyExchangeValues(baseCurrency, date, targetCurrencies);

        return CurrencyServiceResponse;
    }

    @PostMapping(path = "/{baseCurrency}", consumes = "application/json", produces = "application/json")
    public CurrencyServiceDateRangeResponse getCurrencyValues(@PathVariable String baseCurrency,
                                                              @RequestBody CurrencyRangeRequestBody requestBody) {

        CurrencyServiceDateRangeResponse currencyServiceDateRangeResponse = currencyExchangeService.getCurrencyExchangeValues(baseCurrency, requestBody);

        return currencyServiceDateRangeResponse;
    }

    @GetMapping(value = "/{baseCurrency}", params = { "startDate", "endDate" })
    public CurrencyServiceResponse getCurrencyValuesForGivenRange(@PathVariable String baseCurrency,
                                                     @RequestParam(value = "startDate") String startDate,
                                                     @RequestParam(value = "endDate") String endDate) {

        CurrencyServiceResponse CurrencyServiceResponse = currencyExchangeService.getCurrencyExchangeValues(baseCurrency, startDate, endDate, true);

        return CurrencyServiceResponse;
    }
}
