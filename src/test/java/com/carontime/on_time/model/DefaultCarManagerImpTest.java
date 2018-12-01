package com.carontime.on_time.model;

import com.carontime.on_time.model.car.Car;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

public class DefaultCarManagerImpTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldReturnNewCar() {
        //given
        DefaultCarManagerImp carManager = Mockito.mock(DefaultCarManagerImp.class);
        when(carManager.addCar(new Car())).thenReturn(

        )
    }

    @Test
    public void asd() {
    }

    @Test
    public void removeCar() {
    }

    @Test
    public void getCar() {
    }
}