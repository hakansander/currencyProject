package com.hakansander.currency.model.responseModels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date",
        "base",
        "rate"
})
public class CurrencyServiceResponse {
    @JsonProperty("date")
    private String date;
    @JsonProperty("base")
    private String base;
    @JsonProperty("rates")
    Map<String, Double> rates;
}