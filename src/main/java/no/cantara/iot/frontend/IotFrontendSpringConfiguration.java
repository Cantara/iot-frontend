package no.cantara.iot.frontend;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackageClasses = IotFrontendSpringConfiguration.class)
@ImportResource("classpath:constretto/spring-constretto.xml")
public class IotFrontendSpringConfiguration {
}
