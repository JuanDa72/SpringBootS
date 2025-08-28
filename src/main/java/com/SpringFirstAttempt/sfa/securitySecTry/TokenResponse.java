package com.SpringFirstAttempt.sfa.securitySecTry;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenResponse(

        //Usamos jsonProperty para usar la notación estandar de java y de el jwb.
        @JsonProperty("access_token")
        String accessToken,
        @JsonProperty("refresh_token")
        String refreshToken

) {
}
