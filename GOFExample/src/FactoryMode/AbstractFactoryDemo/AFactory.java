package FactoryMode.AbstractFactoryDemo;

import java.util.Calendar;

public class AFactory implements ProductFactory {
    @Override
    public Phone MakePhone() {
        return new PhoneA();
    }

    @Override
    public Computer MakeComputer() {
        return new ComputerA();
    }

}
