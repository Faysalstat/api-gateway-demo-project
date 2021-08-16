package com.ababilauth.ababildemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Import;

//@EnableAutoConfiguration(exclude= HibernateJpaAutoConfiguration.class)
@SpringBootApplication
//@Import({SpringConfig.class})
public class AbabilDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbabilDemoApplication.class, args);
	}

}
