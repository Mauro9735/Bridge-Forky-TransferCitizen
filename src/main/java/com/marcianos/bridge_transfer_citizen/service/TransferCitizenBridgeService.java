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
        String exchangeName = "transfer_citizen_exchange";
        String routingKey = "transfer_citizen_routing_key";
        rabbitTemplate.convertAndSend(exchangeName, routingKey, requestTransferCitizenBridge);
    }



}
