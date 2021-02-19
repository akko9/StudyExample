package FactoryMode.FactoryDemo;

import FactoryMode.SimpleFactoryDemo.CarFactory;

public class Client {
    public static void main(String[] args) {
        OriginalFactory factoryA=new CarAFactory();
        Car car1 = factoryA.MakeCar();
        OriginalFactory factoryB=new CarBFactory();
        Car car2 = factoryB.MakeCar();

        car1.getCarName();
        car2.getCarName();
    }
}
