package com.hakansander.currency.dto.CurrencyResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.SortedMap;

@Data
@Getter
@Setter
@AllArgsConstructor
public class CurrencyResponseDto {
    boolean success;
    String responseMsg;
    String statusCode;
    String response;
    SortedMap<String, Object> data;
}
