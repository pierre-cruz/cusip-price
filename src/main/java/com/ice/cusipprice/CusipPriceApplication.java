package com.ice.cusipprice;

import com.ice.cusipprice.model.Cusip;
import com.ice.cusipprice.repository.CusipRepository;
import com.ice.cusipprice.service.CusipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CusipPriceApplication {

	private static final Logger log = LoggerFactory.getLogger(CusipPriceApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(CusipPriceApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(CusipService service, CusipRepository repository) {
		return (args) -> {
			service.ingestCusipFile("CusipPrice.txt");

			log.info("----------------------------------");
			log.info("CUSIP's latest prices:");
			for (Cusip cusip : repository.findAll()) {
				log.info(cusip.toString());
			}
		};
	}
}
