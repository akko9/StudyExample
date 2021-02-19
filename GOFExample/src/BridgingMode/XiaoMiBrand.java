package BridgingMode;

public class XiaoMiBrand extends Brand {

    public XiaoMiBrand(Phone phone) {
        super(phone);
    }

    @Override
    public void shape() {
        super.shape();
        System.out.println("小米折叠");
    }

    @Override
    public void operation() {
        System.out.println("小米操作");
    }
}
