package FactoryMode.SimpleFactoryDemo;
/*
静态工厂 没满足开闭原则
 */
public class CarFactory {

    public static Car getInstance(String name){
        if ("A类车".equals(name)){
            return new CarA();
        }else if ("B类车".equals(name)){
            return new CarB();
        }else {
            return null;
        }
    }

}
