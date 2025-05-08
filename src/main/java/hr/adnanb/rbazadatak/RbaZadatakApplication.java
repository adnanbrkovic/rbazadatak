package hr.adnanb.rbazadatak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "hr.adnanb.rbazadatak.domain.entity")
public class RbaZadatakApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbaZadatakApplication.class, args);
	}

}
