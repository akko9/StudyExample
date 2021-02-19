package SpringIOCDemo;

public class User {
    private Integer id;
    private String name;
    private String address;
    private Dept dept;

    public User() {
    }

    public User(Integer id, String name, String address,Dept dept) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dept=dept;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dept.name=" + dept.getName() +
                '}';
    }

    public void run(){
        System.out.println("跑步中。。。。。。。。。");
    }
}
