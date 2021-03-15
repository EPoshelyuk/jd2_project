package it.academy.monitorSensorProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import static java.util.Collections.singletonList;

@SpringBootApplication
@EntityScan("it.academy.monitorSensorProject.repository.entity")
@EnableJpaRepositories(basePackages = "it.academy.monitorSensorProject.repository")
public class MonitorSensorProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorSensorProjectApplication.class, args);
	}

	public MonitorSensorProjectApplication(FreeMarkerConfigurer freeMarkerConfigurer) {
		freeMarkerConfigurer.getTaglibFactory().setClasspathTlds(singletonList("/META-INF/security.tld"));
	}

}
