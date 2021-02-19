package BridgingMode;

public abstract class Brand  {
    private Phone phone;

    public Brand(Phone phone) {
        this.phone = phone;
    }

    public void shape(){
        phone.play();
    };

    public void operation(){
        phone.call();
    };
}
