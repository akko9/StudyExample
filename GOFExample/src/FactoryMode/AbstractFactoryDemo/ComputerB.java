package FactoryMode.AbstractFactoryDemo;

public class ComputerB implements Computer {
    @Override
    public void shutdown() {
        System.out.println("电脑B关机");
    }

    @Override
    public void start() {
        System.out.println("电脑B开机");
    }

    @Override
    public void play() {
        System.out.println("电脑B玩游戏");
    }
}
