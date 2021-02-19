package GC;

public class MemorySizeDemo {
    public static void main(String[] args) {
        long TotalMemory=Runtime.getRuntime().totalMemory(); //虚拟机中的内存总量
        long maxMemory=Runtime.getRuntime().maxMemory();    //虚拟机试图使用最大内存
        System.out.println("Total_Memory(-Xms)="+TotalMemory+"字节"+(TotalMemory/(double)1024/1024)+"MB" ); //1/64
        System.out.println("Max_Memory(-Xmx)="+maxMemory+"字节"+(maxMemory/(double)1024/1024)+"MB" );//1/4
    }
}
