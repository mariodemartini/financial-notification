package br.com.geradordedevs.financialnotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class FinancialNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialNotificationApplication.class, args);
	}

}
