package org.geekbang.projects.cs;

import com.dbappsecurity.base.custdev.CustDevConfigurer;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@CustDevConfigurer
@Slf4j
@SpringBootApplication(scanBasePackages = "package")
@MapperScan("org.geekbang.projects.cs.mapper")
@EnableFeignClients(basePackages = {"org.geekbang.projects.cs.provider"})
public class Application {

    @Bean
    public RestTemplate restTemplate() {
        //注入RestTemplate
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("*************************************************************");
        log.info("****************** CUSTOMER SYSTEM START ******************");
        log.info("*************************************************************");
    }
}
