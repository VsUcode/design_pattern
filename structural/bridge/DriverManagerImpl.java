package com.vsu.structural.bridge;

/**
 * Created by vsu on 2017/12/09.
 */
public class DriverManagerImpl extends DriverManager{
    public void connect(){
        super.connect();
    }




    public static void main(String[] args) {
        DriverManager driverManager = new DriverManagerImpl();
        Driver driver = new DriverImpl1();
        driverManager.setDriver(driver);
        driverManager.connect();//connect sql done


        Driver driver1 = new DriverImpl2();
        driverManager.setDriver(driver1);
        driverManager.connect();//connect db done

    }
}
