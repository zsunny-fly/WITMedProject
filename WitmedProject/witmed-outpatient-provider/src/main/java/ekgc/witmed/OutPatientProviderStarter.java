package ekgc.witmed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("ekgc.witmed.*.dao")
public class OutPatientProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(OutPatientProviderStarter.class, args);
	}
}
