package io.chetan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RoomServiceApplication {

	private static Logger LOGGER = LogManager.getLogger(RoomServiceApplication.class);
	
	public static void main(String[] args) 
	{
		LOGGER.info("\n\n RoomServiceApplication - main\n\n");
		
		SpringApplication.run(RoomServiceApplication.class, args);
	}

}
