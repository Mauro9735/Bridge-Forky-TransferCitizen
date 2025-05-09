package com.marcianos.bridge_transfer_citizen.controller;


import com.marcianos.bridge_transfer_citizen.dto.RequestTransferCitizenBridge;
import com.marcianos.bridge_transfer_citizen.dto.RequestTransferCitizenConfirm;
import com.marcianos.bridge_transfer_citizen.dto.RequestTransferCitizenOperator;
import com.marcianos.bridge_transfer_citizen.service.TransferCitizenBridgeService;
import com.marcianos.bridge_transfer_citizen.service.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TransferCitizenBridgeController {

    private final TransferCitizenBridgeService transferCitizenBridgeService;
    private final JwtService jwtService;

    @PostMapping("/v1/events/transfer/citizen")
    public String sendDataToRabbitMq(@RequestHeader("Authorization") String authorizationHeader,
                                     @RequestBody RequestTransferCitizenBridge requestTransferCitizenBridge) {

        String id = jwtService.getUserId(authorizationHeader);
        transferCitizenBridgeService.sendTransferCitizenData(id,requestTransferCitizenBridge);
        return "Data sent to RabbitMQ successfully!";
    }

    @PostMapping("/api/transferCitizen")
    public String transferCitizen(@RequestBody RequestTransferCitizenOperator requestTransferCitizenOperator) {
        transferCitizenBridgeService.sendTransferCitizenDataOperator(requestTransferCitizenOperator);
        return "Data sent to RabbitMQ successfully!";
    }

    @PostMapping("/api/transferCitizenConfirm")
    public String transferCitizenConfirm(@RequestBody RequestTransferCitizenConfirm requestTransferCitizenOperatorConfirm) {
        transferCitizenBridgeService.sendTransferCitizenDataOperatorConfirm(requestTransferCitizenOperatorConfirm);
        return "Data sent to RabbitMQ successfully!";
    }
}
