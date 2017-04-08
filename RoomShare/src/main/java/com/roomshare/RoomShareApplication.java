package com.roomshare;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class RoomShareApplication {
	
	
	private static final Logger log = LoggerFactory.getLogger(RoomShareApplication.class);

     public static void main(String[] args)
     {
		SpringApplication.run(RoomShareApplication.class, args);
		log.info("In Spring Main");
	 
     }
}
