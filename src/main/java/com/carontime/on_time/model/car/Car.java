package com.carontime.on_time.model.car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.geom.Point2D;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
