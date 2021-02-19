package FactoryMode.AbstractFactoryDemo;

public class Client {
    public static void main(String[] args) {
        ProductFactory aFactory=new AFactory();
        Phone phone1 = aFactory.MakePhone();
        Computer computer1 = aFactory.MakeComputer();
        phone1.call();
        computer1.play();
        ProductFactory bFactory=new BFactory();
        Phone phone2 = bFactory.MakePhone();
        Computer computer2= bFactory.MakeComputer();
        phone2.call();
        computer2.play();

    }
}
