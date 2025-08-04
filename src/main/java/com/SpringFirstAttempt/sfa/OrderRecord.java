package com.SpringFirstAttempt.sfa;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderRecord (
    @JsonProperty("c-name")
    String customerName,
    @JsonProperty("p-name")
    String productName,
    int quantity
) {

}
