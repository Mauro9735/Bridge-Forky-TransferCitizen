package com.marcianos.bridge_transfer_citizen.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestTransferCitizenConfirm {
    @JsonProperty("id")
    private long id;
    @JsonProperty("req_status")
    private int req_status;
}
