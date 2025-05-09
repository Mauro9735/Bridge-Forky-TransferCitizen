package com.marcianos.bridge_transfer_citizen.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestTransferCitizenRabbit implements Serializable {
    private String id;
    private String operatorId;
    private String operatorName;
    private String transferUrl;
}
