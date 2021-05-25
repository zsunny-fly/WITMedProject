package ekgc.witmed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 智慧医疗 - 患者功能 - Consumer
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OutPatientConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(OutPatientConsumerStarter.class,args);
	}
}
