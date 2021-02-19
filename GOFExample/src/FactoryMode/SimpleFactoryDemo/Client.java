package FactoryMode.SimpleFactoryDemo;

public class Client {
    public static void main(String[] args) {
        Car car1 = CarFactory.getInstance("A类车");
        Car car2 = CarFactory.getInstance("B类车");

        car1.getCarName();
        car2.getCarName();
    }
}
