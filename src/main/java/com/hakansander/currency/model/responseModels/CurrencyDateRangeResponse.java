package com.hakansander.currency.model.responseModels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "start_at",
        "end_at",
        "base"
})
public class CurrencyDateRangeResponse {
    @JsonProperty("date")
    private String date;
    @JsonProperty("base")
    private String base;
    @JsonProperty("rates")
    JsonNode rates;
    @JsonProperty("start_at")
    public String startAt;
    @JsonProperty("end_at")
    public String endAt;
}
