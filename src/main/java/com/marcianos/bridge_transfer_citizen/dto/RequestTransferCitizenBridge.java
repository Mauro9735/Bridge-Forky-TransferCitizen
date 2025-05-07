package com.marcianos.bridge_transfer_citizen.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestTransferCitizenBridge implements Serializable {
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("operatorId")
    private String operatorId;
    @JsonProperty("operatorName")
    private String operatorName;
    @JsonProperty("transferUrl")
    private String transferUrl;
}
