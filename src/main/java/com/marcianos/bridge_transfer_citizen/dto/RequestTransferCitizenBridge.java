package com.marcianos.bridge_transfer_citizen.dto;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestTransferCitizenBridge {
    private String operatorId;
    private String operatorName;
    private String transferUrl;
}
