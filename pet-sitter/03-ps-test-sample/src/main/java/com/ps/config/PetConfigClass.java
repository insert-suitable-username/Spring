package com.ps.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ps.services.impl", "com.ps.repos.impl"})
public class PetConfigClass {
}
