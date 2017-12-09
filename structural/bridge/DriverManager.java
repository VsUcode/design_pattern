package com.vsu.structural.bridge;

/**
 * Created by vsu on 2017/12/09.
 */
public abstract class DriverManager {

    Driver driver = null;

    public void connect(){
        driver.connect();
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
