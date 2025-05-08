package com.marcianos.bridge_transfer_citizen.service;



import com.marcianos.bridge_transfer_citizen.dto.RequestTransferCitizenBridge;
import com.marcianos.bridge_transfer_citizen.dto.RequestTransferCitizenConfirm;
import com.marcianos.bridge_transfer_citizen.dto.RequestTransferCitizenOperator;
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

    public void sendTransferCitizenDataOperator(RequestTransferCitizenOperator requestTransferCitizenOperator) {
        rabbitTemplate.convertAndSend("register-queue", requestTransferCitizenOperator);
    }

    public void sendTransferCitizenDataOperatorConfirm(RequestTransferCitizenConfirm requestTransferCitizenConfirm) {
        rabbitTemplate.convertAndSend("delete_data_transferred_documents_queue", requestTransferCitizenConfirm);
    }



}
