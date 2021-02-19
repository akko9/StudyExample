package FactoryMode.AbstractFactoryDemo;

public class BFactory implements ProductFactory {
    @Override
    public Phone MakePhone() {
        return new PhoneA();
    }

    @Override
    public Computer MakeComputer() {
        return new ComputerB();
    }
}
