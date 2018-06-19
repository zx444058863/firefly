package org.zealot.fireflyweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"org.zealot"})
@EnableJpaRepositories(basePackages = "org.zealot.fireflydao")
@EntityScan(basePackages = "org.zealot.fireflybase")
@SpringBootApplication(scanBasePackages = {"org.zealot.fireflyweb", "org.zealot.fireflycommon"})
public class FireflyWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(FireflyWebApplication.class, args);
    }
}
