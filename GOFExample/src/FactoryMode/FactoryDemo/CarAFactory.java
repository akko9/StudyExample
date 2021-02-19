package FactoryMode.FactoryDemo;

public class CarAFactory implements OriginalFactory{

    @Override
    public Car MakeCar() {
        return new CarA();
    }
}
