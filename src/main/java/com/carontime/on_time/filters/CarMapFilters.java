package com.carontime.on_time.filters;

import com.carontime.on_time.model.car.Car;
import com.carontime.on_time.service.carservice.CarService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CarMapFilters implements Filter {

    private CarService carService;
    private List<String> ignoredSuffixes = Arrays.asList(".jpg", ".jpeg", ".png", ".fav");

    public CarMapFilters(CarService carService) {
        this.carService = carService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if(!isIgnored(request.getRequestURI())) {
            List<Car> cars = carService.getAll();
            servletRequest.setAttribute("listOfCars", cars);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isIgnored(String uri) {
        return ignoredSuffixes.stream().anyMatch(uri::endsWith);
    }
}
