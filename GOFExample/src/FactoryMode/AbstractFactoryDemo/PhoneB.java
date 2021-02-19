package FactoryMode.AbstractFactoryDemo;

public class PhoneB implements Phone {
    @Override
    public void shutdown() {
        System.out.println("手机A关机");
    }

    @Override
    public void call() {
        System.out.println("手机A打电话");
    }

    @Override
    public void start() {
        System.out.println("手机A开机");
    }
}
