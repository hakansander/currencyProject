package com.hakansander.currency.exceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchangeErrorResponse {
    private int status;
    private String message;
    private String timeStamp;
}
