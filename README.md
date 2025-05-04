# Bridge-Forky-TransferCitizen

This repository contains the "Bridge Forky TransferCitizen" service, a Javas application designed to receive transfer citizen requests via an HTTP endpoint (/v1/transfer). It forwards the transfer data to a RabbitMQ queue (transferCitizen-queue) for asynchronous processing
