package com.pretest.Pretest;

import com.pretest.Pretest.Entity.Order;
import com.pretest.Pretest.Entity.Shipment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

@SpringBootApplication
@EnableSwagger2
public class PretestApplication {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
				.build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	@Bean
	public ApiInfo apiInfo() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		return builder.build();
	}


	public static void main(String[] args) {
		SpringApplication.run(PretestApplication.class, args);
		/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		Product p = new Product("Prod1","Shirt","Each", LocalDate.parse("22-03-2022",formatter));
		ProductList l = new ProductList();
		List<Product> ist = new ArrayList<>();
		ist.add(p);*/
		Order order= new Order ("Order1", "Prod1", 2.0);
		Shipment shipment = new Shipment ("Order1", "Ship1", "Prod1" ,new Date(2021 - 02 - 19), 2.0);
	}

}