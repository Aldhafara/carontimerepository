package com.carontime.on_time.model.car;

import java.awt.geom.Point2D;

public class Car {
    private int id;
    private CarStatus status=CarStatus.UNUSED;
    private Point2D.Double localization;

    public int getId() {
        return id;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    public Point2D.Double getLocalization() {
        return localization;
    }

    public void setLocalization(Point2D.Double localization) {
        this.localization = localization;
    }
}
