package com.hakansander.currency.model.requestModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class CurrencyRangeRequestBody {
    private String startDate;
    private String endDate;
    private String targetCurrencies;
}
