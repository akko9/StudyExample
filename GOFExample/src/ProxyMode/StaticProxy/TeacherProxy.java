package ProxyMode.StaticProxy;

public class TeacherProxy {
    private SuperTeacher superTeacher;
    public TeacherProxy(SuperTeacher superTeacher) {
        this.superTeacher=superTeacher;
    }
    public void run(){
        System.out.println("执行代理方法开始");
        superTeacher.teach();
        System.out.println("执行代理方法结束");
    }
}
