package FactoryMode.AbstractFactoryDemo;

public class ComputerA implements Computer {
    @Override
    public void shutdown() {
        System.out.println("电脑A关机");
    }

    @Override
    public void start() {
        System.out.println("电脑A开机");
    }

    @Override
    public void play() {
        System.out.println("电脑A玩游戏");
    }
}
