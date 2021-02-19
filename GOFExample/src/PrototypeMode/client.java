package PrototypeMode;


public class client {
    public static void main(String[] args) {
        Sheep friend=new Sheep("nick",2,"黑色",null);
        Sheep sheep=new Sheep("tom",1,"白色",friend);
        Sheep clone1 = sheep.clone();
        Sheep clone2 = sheep.clone();
        Sheep clone3 = sheep.clone();
        Sheep clone4 = sheep.clone();

        System.out.println(clone1.toString()+clone1.getFriend().hashCode());
        System.out.println(clone2.toString()+clone2.getFriend().hashCode());
        System.out.println(clone3.toString()+clone3.getFriend().hashCode());
        System.out.println(clone4.toString()+clone4.getFriend().hashCode());



    }
}
