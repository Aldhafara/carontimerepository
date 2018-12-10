package com.carontime.on_time.dto;

import com.carontime.on_time.forms.CarForm;
import com.carontime.on_time.model.car.Car;

import java.awt.geom.Point2D;

public class AddCarDao {
    public static Point2D.Double convertCoordsToPoint2D(CarForm carForm) {
        double x = Double.parseDouble(carForm.getLatitude().replace(',', '.'));
        double y = Double.parseDouble(carForm.getLongitude().replace(',', '.'));
        return new Point2D.Double(x, y);
    }

    public static CarForm fromCar(Car car) {
        CarForm carForm = new CarForm();
        carForm.setStatus(car.getStatus());
        carForm.setLatitude(Double.toString(car.getX()));
        carForm.setLongitude(Double.toString(car.getY()));
        return carForm;
    }
}
