package com.carontime.on_time.config;

import com.carontime.on_time.filters.CarMapFilters;
import com.carontime.on_time.service.carservice.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FiltersConfig {
    @Autowired
    private CarService carService;

    @Bean
    public FilterRegistrationBean<CarMapFilters> carMapFilter(){
        FilterRegistrationBean<CarMapFilters> carMapFilter = new FilterRegistrationBean<>();
        carMapFilter.setFilter(new CarMapFilters(carService));
        carMapFilter.addUrlPatterns("/*");
        return carMapFilter;
    }
}
