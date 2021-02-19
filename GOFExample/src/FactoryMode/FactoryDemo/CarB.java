package FactoryMode.FactoryDemo;

public class CarB implements Car {
    private String name;

    public CarB() {
    }

    public CarB(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getCarName() {
        System.out.println("该车为B类车!!");
    }
}
