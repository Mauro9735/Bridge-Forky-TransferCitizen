package com.marcianos.bridge_transfer_citizen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BridgeTransferCitizenApplication {

	public static void main(String[] args) {
		SpringApplication.run(BridgeTransferCitizenApplication.class, args);
	}

}
