package spb.iac.calc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author eugenBoris
 * @version 0.001
 * https://www.baeldung.com/spring-boot-soap-web-service
 */
@SpringBootApplication
@Slf4j
public class ServiceApplication {

    public static void main(String[] args) {
        log.info(" -> starting begin");
        SpringApplication.run(ServiceApplication.class, args);
        log.info(" -> starting end");
    }

}
