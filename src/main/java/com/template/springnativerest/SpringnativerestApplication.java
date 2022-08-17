package com.template.springnativerest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.template.springnativerest.exception.utils.JacksonConfiguratorUtil;

@SpringBootApplication
public class SpringnativerestApplication {

	@Value("${spring.jackson.time-zone}")
    private String timeZone;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringnativerestApplication.class, args);
	}

	@Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        return JacksonConfiguratorUtil.createObjectMapper(configureObjectMapper());
    }

    @Bean
    public Jackson2ObjectMapperBuilder configureObjectMapper() {
        return JacksonConfiguratorUtil.createJacksonMapperBuilder(timeZone, 2);
    }

}
