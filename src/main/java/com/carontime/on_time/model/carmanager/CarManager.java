package com.carontime.on_time.model.carmanager;

import com.carontime.on_time.model.car.Car;

public interface CarManager {
    /*
    * Return:
    *   - Id pojazdu na liście
    *   - -1 w przypadku jeśli pojazd już istnieje na liście
    *   - NullPointerException jeżeli paramter car jest nullem
    * */
    int addCar(Car car);

    /*
    * Return:
    *   - true jeśli obiekt został usunięty z listy
    *   - false jeśli obiekt nie został usunięty z listy (paramter car jest null lub nie ma go na liście)
    * */
    boolean removeCar(Car car);

    /*
    * Return:
    *   - obiekt 'Car' jeśli na liście znajduje się to id
    *   - IllegalArgumentException jeśli przekazane w parametrze 'id' wykracza poza zakres listy
    * */
    Car getCar(int id);

    /*
    * Return:
    *   - true jeśli obiekt znajduje się na liście
    *   - false jeśli obiekt nie znajduej się na liście
    * */
    boolean isOnList(Car car);
}
