package com.marcianos.bridge_transfer_citizen.service;



import com.marcianos.bridge_transfer_citizen.dto.RequestTransferCitizenBridge;
import com.marcianos.bridge_transfer_citizen.dto.RequestTransferCitizenConfirm;
import com.marcianos.bridge_transfer_citizen.dto.RequestTransferCitizenOperator;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransferCitizenBridgeService {

    private final RabbitTemplate rabbitTemplate;


    public void sendTransferCitizenData(RequestTransferCitizenBridge requestTransferCitizenBridge) {
        rabbitTemplate.convertAndSend("transfer_citizen_queue", requestTransferCitizenBridge);
    }

    public void sendTransferCitizenDataOperator(RequestTransferCitizenOperator requestTransferCitizenOperator) {
        if (requestTransferCitizenOperator.getUrlDocuments() != null && !requestTransferCitizenOperator.getUrlDocuments().isEmpty()) {
            Map<String, String[]> updatedUrlDocuments = requestTransferCitizenOperator.getUrlDocuments().entrySet().stream()
                    .collect(Collectors.toMap(
                            entry -> entry.getKey().toLowerCase(),
                            Map.Entry::getValue
                    ));
            requestTransferCitizenOperator.setUrlDocuments(updatedUrlDocuments);
        }
        rabbitTemplate.convertAndSend("register_transfer_citizen_queue", requestTransferCitizenOperator);
    }

    public void sendTransferCitizenDataOperatorConfirm(RequestTransferCitizenConfirm requestTransferCitizenConfirm) {
        rabbitTemplate.convertAndSend("delete_data_transferred_documents_queue", requestTransferCitizenConfirm);
    }



}
