package com.carontime.on_time.model.car;

public enum CarStatus {
    UNUSED("Nieużywany"), INUSE("Używany"), BROKEN("Zepsuty");

    private String name;
    private CarStatus(String name) {
        this.name = name;
    }

    public String getFullName() {
        return name;
    }
}
