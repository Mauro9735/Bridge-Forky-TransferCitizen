package com.marcianos.bridge_transfer_citizen.service;



import com.marcianos.bridge_transfer_citizen.dto.RequestTransferCitizenBridge;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferCitizenBridgeService {

    private final RabbitTemplate rabbitTemplate;


    public void sendTransferCitizenData(RequestTransferCitizenBridge requestTransferCitizenBridge) {
        rabbitTemplate.convertAndSend("transfer_citizen_queue", requestTransferCitizenBridge);
    }



}
