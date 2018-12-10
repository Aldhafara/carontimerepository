package com.carontime.on_time.forms;

import com.carontime.on_time.model.car.CarStatus;

import javax.validation.constraints.Pattern;

public class CarForm {
    private CarStatus status;
    @Pattern(regexp = "^[\\d.,]{1,64}$", message = "Niepoprawna szerokość geograficzna")
    private String latitude;
    @Pattern(regexp = "^[\\d.,]{1,64}$", message = "Niepoprawna długość geograficzna")
    private String longitude;

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
