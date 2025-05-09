package com.marcianos.bridge_transfer_citizen.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.Map;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestTransferCitizenOperator {

    @JsonProperty("id")
    private long id;
    @JsonProperty("citizenName")
    private String citizenName;
    @JsonProperty("citizenEmail")
    private String citizenEmail;
    @JsonProperty("urlDocuments")
    private Map<String,String[]> urlDocuments;
    @JsonProperty("confirmAPI")
    private String confirmAPI;
}
