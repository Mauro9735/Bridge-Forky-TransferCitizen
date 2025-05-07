package com.marcianos.bridge_transfer_citizen.controller;


import com.marcianos.bridge_transfer_citizen.dto.RequestTransferCitizenBridge;
import com.marcianos.bridge_transfer_citizen.dto.RequestTransferCitizenConfirm;
import com.marcianos.bridge_transfer_citizen.dto.RequestTransferCitizenOperator;
import com.marcianos.bridge_transfer_citizen.service.TransferCitizenBridgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransferCitizenBridgeController {

    private final TransferCitizenBridgeService transferCitizenBridgeService;

    @PostMapping("/v1/events/transfer/citizen")
    public String sendDataToRabbitMq(@RequestBody RequestTransferCitizenBridge requestTransferCitizenBridge) {
        transferCitizenBridgeService.sendTransferCitizenData(requestTransferCitizenBridge);
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
