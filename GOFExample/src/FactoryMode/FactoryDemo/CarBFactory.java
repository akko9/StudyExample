package FactoryMode.FactoryDemo;

public class CarBFactory implements OriginalFactory{
    @Override
    public Car MakeCar() {
        return new CarB();
    }
}
