package AdapterMode.interfaceMode;



public class Phone {
    public void Recharge(IVoltage voltage){
        if (voltage.output()==5){
            System.out.println("手机开始充电!");
        }else if (voltage.output()==220){
            System.out.println("手机无法充电!需转换");
        }

    }
}
