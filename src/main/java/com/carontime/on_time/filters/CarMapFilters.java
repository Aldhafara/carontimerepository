package com.carontime.on_time.filters;

import com.carontime.on_time.model.car.Car;
import com.carontime.on_time.service.carservice.CarService;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

@Component
public class CarMapFilters implements Filter {

    private CarService carService;

    public CarMapFilters(CarService carService) {
        this.carService = carService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        List<Car> cars = carService.getAll();
        servletRequest.setAttribute("listOfCars", cars);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
