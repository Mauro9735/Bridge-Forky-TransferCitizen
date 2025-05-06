package com.marcianos.bridge_transfer_citizen.controller;


import com.marcianos.bridge_transfer_citizen.dto.RequestTransferCitizenBridge;
import com.marcianos.bridge_transfer_citizen.service.TransferCitizenBridgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/events/transfer")
public class TransferCitizenBridgeController {

    private final TransferCitizenBridgeService transferCitizenBridgeService;

    @PostMapping("/citizen")
    public String sendDataToRabbitMq(@RequestBody RequestTransferCitizenBridge requestTransferCitizenBridge) {
        transferCitizenBridgeService.sendTransferCitizenData(requestTransferCitizenBridge);
        return "Data sent to RabbitMQ successfully!";
    }
}
