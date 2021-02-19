package FactoryMode.FactoryDemo;

public class CarA implements Car {
    private String name;

    public CarA() {
    }

    public CarA(String name) {
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
        System.out.println("该车为A类车!!");
    }
}
