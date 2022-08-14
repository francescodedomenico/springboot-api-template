package com.template.springnativerest.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "springdoc")
public class OpenApi30Config {

  @Value("${springdoc.moduleName}")
  private String moduleName;
  @Value("${springdoc.apiVersion}")
  private String apiVersion;

 
}