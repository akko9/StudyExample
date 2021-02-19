package BridgingMode;

public  class PhoneA implements Phone {
    @Override
    public void call() {
        System.out.println("A场打电话功能");
    }

    @Override
    public void play() {
        System.out.println("A场玩游戏功能");
    }
}
